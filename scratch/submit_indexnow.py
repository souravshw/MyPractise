#!/usr/bin/env python3
import argparse
import json
import os
import re
import sys
import shutil
import time
import urllib.request
import urllib.error
import urllib.parse
import uuid
import xml.etree.ElementTree as ET
from http.server import HTTPServer, BaseHTTPRequestHandler

# Resolve Base Cache / Credentials Directory from SAMAY_HOME
SAMAY_HOME = os.environ.get("SAMAY_HOME")
if SAMAY_HOME:
    BASE_CACHE_DIR = os.path.abspath(SAMAY_HOME)
    # Ensure SAMAY_HOME directory exists
    try:
        os.makedirs(BASE_CACHE_DIR, exist_ok=True)
    except Exception as e:
        print(f"Warning: Failed to create SAMAY_HOME directory at {BASE_CACHE_DIR}: {e}")
        BASE_CACHE_DIR = os.path.abspath(".")
else:
    BASE_CACHE_DIR = os.path.abspath(".")

# Helper to migrate files from workspace root to BASE_CACHE_DIR
def migrate_cache_files(target_dir):
    if target_dir == os.path.abspath("."):
        return
    files_to_migrate = [
        "indexnow_history.json",
        "google_history.json",
        "google_token.json"
    ]
    for filename in files_to_migrate:
        src = os.path.join(".", filename)
        dst = os.path.join(target_dir, filename)
        if os.path.exists(src):
            if not os.path.exists(dst):
                try:
                    shutil.copy2(src, dst)
                    print(f"Migrated cache file {filename} from workspace root to {target_dir}")
                    os.remove(src)
                except Exception as e:
                    print(f"Warning: Failed to migrate {filename} to {target_dir}: {e}")
            else:
                try:
                    os.remove(src)
                    print(f"Removed redundant copy of {filename} from workspace root")
                except Exception as e:
                    print(f"Warning: Failed to remove redundant {filename}: {e}")

# Run migration on startup
if SAMAY_HOME:
    migrate_cache_files(BASE_CACHE_DIR)

# Configuration defaults
DEFAULT_SITEMAP = os.path.join("docs", "sitemap-blog-post.xml")
DOCS_DIR = "docs"
HISTORY_FILE_INDEXNOW = os.path.join(BASE_CACHE_DIR, "indexnow_history.json")
HISTORY_FILE_GOOGLE = os.path.join(BASE_CACHE_DIR, "google_history.json")
INDEXNOW_ENDPOINT = "https://api.indexnow.org/indexnow"

# Google OAuth2 credentials token file (must load client credentials from JSON in BASE_CACHE_DIR)
GOOGLE_TOKEN_FILE = os.path.join(BASE_CACHE_DIR, "google_token.json")

def load_google_credentials(base_dir):
    """
    Attempt to load client_id and client_secret from a JSON file in base_dir.
    Checks:
      1. base_dir/google_credentials.json
      2. base_dir/client_secrets.json
    Returns (None, None) if not found.
    """
    for filename in ["google_credentials.json", "client_secrets.json"]:
        filepath = os.path.join(base_dir, filename)
        if os.path.exists(filepath):
            try:
                with open(filepath, "r", encoding="utf-8") as f:
                    data = json.load(f)

                # Check standard OAuth2 client secrets structure
                if "installed" in data:
                    installed = data["installed"]
                    cid = installed.get("client_id")
                    csec = installed.get("client_secret")
                    if cid and csec:
                        return cid, csec
                elif "web" in data:
                    web = data["web"]
                    cid = web.get("client_id")
                    csec = web.get("client_secret")
                    if cid and csec:
                        return cid, csec

                # Check flat format
                cid = data.get("client_id") or data.get("clientId")
                csec = data.get("client_secret") or data.get("clientSecret")
                if cid and csec:
                    return cid, csec
            except Exception as e:
                print(f"Warning: Failed to load credentials from {filepath}: {e}")

    return None, None

# Shared variable for Google OAuth code
auth_code = None

class OAuthCallbackHandler(BaseHTTPRequestHandler):
    def do_GET(self):
        global auth_code
        self.send_response(200)
        self.send_header("Content-Type", "text/html; charset=utf-8")
        self.end_headers()

        parsed_url = urllib.parse.urlparse(self.path)
        params = urllib.parse.parse_qs(parsed_url.query)

        if "code" in params:
            auth_code = params["code"][0]
            response_text = """
            <html>
            <head><title>Authentication Successful</title></head>
            <body style="font-family: Arial, sans-serif; text-align: center; margin-top: 50px;">
                <h1 style="color: #2e7d32;">Authentication Successful!</h1>
                <p>You can now close this tab and return to the terminal.</p>
            </body>
            </html>
            """
        else:
            response_text = """
            <html>
            <head><title>Authentication Failed</title></head>
            <body style="font-family: Arial, sans-serif; text-align: center; margin-top: 50px;">
                <h1 style="color: #c62828;">Authentication Failed</h1>
                <p>No authorization code found in the query parameters. Please try again.</p>
            </body>
            </html>
            """
        self.wfile.write(response_text.encode("utf-8"))

    def log_message(self, format, *args):
        # Suppress request logging to keep console clean
        pass

def get_existing_key(docs_dir):
    """
    Search docs_dir for a file named <key>.txt, where key is an 8-128 character hex string,
    and the file contains that same key.
    """
    if not os.path.isdir(docs_dir):
        return None, None

    pattern = re.compile(r"^[a-fA-F0-9]{8,128}$")

    for filename in os.listdir(docs_dir):
        base, ext = os.path.splitext(filename)
        if ext.lower() == ".txt" and pattern.match(base):
            filepath = os.path.join(docs_dir, filename)
            try:
                with open(filepath, "r", encoding="utf-8") as f:
                    content = f.read().strip()
                if content == base:
                    return base, filepath
            except Exception as e:
                print(f"Warning: Failed to read key file {filepath}: {e}")
    return None, None

def generate_and_save_key(docs_dir, dry_run=False):
    """
    Generate a new 32-character hex key, and write it to docs_dir/<key>.txt.
    """
    key = uuid.uuid4().hex
    filepath = os.path.join(docs_dir, f"{key}.txt")
    if dry_run:
        print(f"[Dry Run] Would generate new key '{key}' and write to '{filepath}'")
    else:
        os.makedirs(docs_dir, exist_ok=True)
        with open(filepath, "w", encoding="utf-8") as f:
            f.write(key)
        print(f"Generated new IndexNow key '{key}' and saved to '{filepath}'")
        print("IMPORTANT: Remember to deploy this key file to your production server so it can be verified at:")
        print(f"  https://<your-domain>/{key}.txt")
    return key, filepath

def parse_sitemap(sitemap_path):
    """
    Parse sitemap XML and extract all URL locations (<loc>).
    Supports sitemaps with namespaces.
    """
    if not os.path.exists(sitemap_path):
        print(f"Error: Sitemap file not found at {sitemap_path}")
        return []

    try:
        tree = ET.parse(sitemap_path)
        root = tree.getroot()
    except Exception as e:
        print(f"Error: Failed to parse XML sitemap {sitemap_path}: {e}")
        return []

    urls = []
    # Find all loc tags regardless of namespace prefix
    for elem in root.iter():
        tag_name = elem.tag.split("}")[-1] if "}" in elem.tag else elem.tag
        if tag_name == "loc" and elem.text:
            urls.append(elem.text.strip())

    return urls

def extract_host(urls, cname_path=os.path.join("docs", "CNAME")):
    """
    Determine the host name.
    1. Try reading CNAME file.
    2. Try extracting from sitemap URLs.
    """
    if os.path.exists(cname_path):
        try:
            with open(cname_path, "r", encoding="utf-8") as f:
                host = f.read().strip()
                if host:
                    return host
        except Exception as e:
            print(f"Warning: Failed to read CNAME file {cname_path}: {e}")

    if urls:
        match = re.match(r"https?://([^/]+)", urls[0])
        if match:
            return match.group(1)

    return None

def load_history(history_path):
    if not os.path.exists(history_path):
        return set()
    try:
        with open(history_path, "r", encoding="utf-8") as f:
            data = json.load(f)
            if isinstance(data, list):
                return set(data)
    except Exception as e:
        print(f"Warning: Failed to load history file {history_path}: {e}")
    return set()

def save_history(history_path, submitted_urls):
    try:
        existing = load_history(history_path)
        updated = existing.union(submitted_urls)
        with open(history_path, "w", encoding="utf-8") as f:
            json.dump(sorted(list(updated)), f, indent=2)
    except Exception as e:
        print(f"Error: Failed to save history to {history_path}: {e}")

# --- Google OAuth2 & Indexing Helpers ---

def exchange_code_for_tokens(client_id, client_secret, code, redirect_uri):
    url = "https://oauth2.googleapis.com/token"
    params = {
        "code": code,
        "client_id": client_id,
        "client_secret": client_secret,
        "redirect_uri": redirect_uri,
        "grant_type": "authorization_code"
    }
    data = urllib.parse.urlencode(params).encode("utf-8")
    req = urllib.request.Request(
        url,
        data=data,
        headers={"Content-Type": "application/x-www-form-urlencoded"},
        method="POST"
    )
    with urllib.request.urlopen(req) as response:
        res_data = json.loads(response.read().decode("utf-8"))

    if "expires_in" in res_data:
        res_data["expires_at"] = time.time() + int(res_data["expires_in"])
    return res_data

def refresh_google_token(client_id, client_secret, refresh_token):
    url = "https://oauth2.googleapis.com/token"
    params = {
        "client_id": client_id,
        "client_secret": client_secret,
        "refresh_token": refresh_token,
        "grant_type": "refresh_token"
    }
    data = urllib.parse.urlencode(params).encode("utf-8")
    req = urllib.request.Request(
        url,
        data=data,
        headers={"Content-Type": "application/x-www-form-urlencoded"},
        method="POST"
    )
    with urllib.request.urlopen(req) as response:
        res_data = json.loads(response.read().decode("utf-8"))

    if "expires_in" in res_data:
        res_data["expires_at"] = time.time() + int(res_data["expires_in"])
    if "refresh_token" not in res_data:
        res_data["refresh_token"] = refresh_token
    return res_data

def get_google_access_token(client_id, client_secret, token_path, port):
    tokens = {}
    if os.path.exists(token_path):
        try:
            with open(token_path, "r", encoding="utf-8") as f:
                tokens = json.load(f)
        except Exception as e:
            print(f"Warning: Failed to load Google token cache: {e}")

    # Re-use non-expired access token
    if tokens.get("access_token") and tokens.get("expires_at", 0) > time.time() + 60:
        return tokens["access_token"]

    # Refresh expired access token
    if tokens.get("refresh_token"):
        if not client_id or not client_secret:
            print("Error: Google credentials (client_id/client_secret) are missing. Cannot refresh token.")
            print("Please verify that 'google_credentials.json' or 'client_secrets.json' is present in your base directory.")
            return None
        print("Google access token expired. Refreshing using refresh token...")
        try:
            new_tokens = refresh_google_token(client_id, client_secret, tokens["refresh_token"])
            with open(token_path, "w", encoding="utf-8") as f:
                json.dump(new_tokens, f, indent=2)
            return new_tokens["access_token"]
        except Exception as e:
            print(f"Warning: Failed to refresh Google token: {e}. Falling back to full authorization flow.")

    # Run full loopback OAuth2 auth server
    if not client_id or not client_secret:
        print("Error: Google credentials (client_id/client_secret) are missing. Cannot authenticate with Google.")
        print("Please verify that 'google_credentials.json' or 'client_secrets.json' is present in your base directory.")
        return None

    redirect_uri = f"http://localhost:{port}/"
    auth_url = (
            "https://accounts.google.com/o/oauth2/v2/auth?"
            + urllib.parse.urlencode({
        "client_id": client_id,
        "redirect_uri": redirect_uri,
        "response_type": "code",
        "scope": "https://www.googleapis.com/auth/indexing",
        "access_type": "offline",
        "prompt": "consent"
    })
    )

    print("\n" + "="*80)
    print("GOOGLE INDEXING API AUTHORIZATION REQUIRED")
    print("="*80)
    print("Please open the following link in your web browser to log in and authorize the app:")
    print(f"\n  {auth_url}\n")
    print(f"Waiting for authorization on local callback server (port {port})...")

    global auth_code
    auth_code = None

    server_address = ("", port)
    try:
        httpd = HTTPServer(server_address, OAuthCallbackHandler)
    except Exception as e:
        print(f"Error: Failed to start local server on port {port}: {e}")
        print("Please verify that the port is not in use, or configure another port using --google-port")
        return None

    while auth_code is None:
        httpd.handle_request()

    httpd.server_close()
    print("Authorization code captured successfully!")

    try:
        new_tokens = exchange_code_for_tokens(client_id, client_secret, auth_code, redirect_uri)
        with open(token_path, "w", encoding="utf-8") as f:
            json.dump(new_tokens, f, indent=2)
        print("Google tokens cached successfully.")
        return new_tokens["access_token"]
    except Exception as e:
        print(f"Error: Failed to exchange authorization code: {e}")
        return None

def submit_to_google(url, access_token):
    endpoint = "https://indexing.googleapis.com/v3/urlNotifications:publish"
    payload = {
        "url": url,
        "type": "URL_UPDATED"
    }
    payload_json = json.dumps(payload).encode("utf-8")
    req = urllib.request.Request(
        endpoint,
        data=payload_json,
        headers={
            "Content-Type": "application/json; charset=utf-8",
            "Authorization": f"Bearer {access_token}"
        },
        method="POST"
    )
    try:
        with urllib.request.urlopen(req) as response:
            status_code = response.getcode()
            response_body = response.read().decode("utf-8")
        return status_code, response_body, None
    except urllib.error.HTTPError as e:
        error_body = e.read().decode("utf-8")
        return e.code, error_body, e
    except Exception as e:
        return None, None, e

# --- Main Executable Flow ---

def main():
    parser = argparse.ArgumentParser(description="Submit new/modified URLs to IndexNow (Bing) and Google Indexing API.")
    parser.add_argument("--sitemap", default=DEFAULT_SITEMAP, help=f"Path to the sitemap XML file (default: {DEFAULT_SITEMAP})")
    parser.add_argument("--docs", default=DOCS_DIR, help=f"Docs/Static site directory where key file is hosted (default: {DOCS_DIR})")
    parser.add_argument("--indexnow-history", default=HISTORY_FILE_INDEXNOW, help=f"Path to IndexNow history JSON file (default: {HISTORY_FILE_INDEXNOW})")
    parser.add_argument("--google-history", default=HISTORY_FILE_GOOGLE, help=f"Path to Google history JSON file (default: {HISTORY_FILE_GOOGLE})")
    parser.add_argument("--google-token", default=GOOGLE_TOKEN_FILE, help=f"Path to Google token cache JSON file (default: {GOOGLE_TOKEN_FILE})")
    parser.add_argument("--endpoint", default=INDEXNOW_ENDPOINT, help=f"IndexNow API endpoint (default: {INDEXNOW_ENDPOINT})")
    parser.add_argument("--host", help="Website host name (e.g. www.enggnotes.com). If omitted, auto-detected from CNAME or sitemap URLs.")
    parser.add_argument("--key", help="Specify a custom IndexNow key. If omitted, will search or generate in the docs directory.")
    parser.add_argument("--dry-run", action="store_true", help="Simulate submission without making API calls or modifying files.")
    parser.add_argument("--force", action="store_true", help="Submit all URLs from the sitemap, ignoring submission history.")
    parser.add_argument("--clear-history", action="store_true", help="Clear local history cache files and exit.")
    parser.add_argument("--skip-indexnow", action="store_true", help="Skip submission to IndexNow (submits by default).")
    parser.add_argument("--skip-google", action="store_true", help="Skip submission to Google Indexing API (submits by default).")
    parser.add_argument("--google-port", type=int, default=8080, help="Port to run the local temporary redirect server for Google OAuth2 (default: 8080).")

    args = parser.parse_args()

    # Handle clear history
    if args.clear_history:
        for history_file in (args.indexnow_history, args.google_history):
            if os.path.exists(history_file):
                if args.dry_run:
                    print(f"[Dry Run] Would delete history file {history_file}")
                else:
                    try:
                        os.remove(history_file)
                        print(f"Deleted history file {history_file}")
                    except Exception as e:
                        print(f"Error: Failed to delete history file {history_file}: {e}")
            else:
                print(f"No history file found to delete at {history_file}.")
        return

    # 1. Parse sitemap
    urls = parse_sitemap(args.sitemap)
    if not urls:
        print("No URLs found in sitemap. Exiting.")
        return
    print(f"Found {len(urls)} total URLs in sitemap {args.sitemap}")

    # 2. Determine host
    host = args.host
    if not host:
        host = extract_host(urls, cname_path=os.path.join(args.docs, "CNAME"))
    if not host:
        print("Error: Could not determine host name. Please specify it using --host <domain>")
        return
    print(f"Target host: {host}")

    # --- IndexNow Submission ---
    if not args.skip_indexnow:
        print("\n" + "="*50)
        print("1. INDEXNOW (BING) SUBMISSION")
        print("="*50)

        # Determine/Generate Key
        key = args.key
        key_file_path = None
        if not key:
            key, key_file_path = get_existing_key(args.docs)
            if key:
                print(f"Using existing key: {key} (found at {key_file_path})")
            else:
                key, key_file_path = generate_and_save_key(args.docs, dry_run=args.dry_run)
        else:
            print(f"Using command-line specified key: {key}")

        key_location = f"https://{host}/{os.path.basename(key_file_path)}" if key_file_path else f"https://{host}/{key}.txt"
        print(f"Key location URL: {key_location}")

        # Filter new URLs for IndexNow
        history_indexnow = set() if args.force else load_history(args.indexnow_history)
        new_indexnow_urls = [url for url in urls if url not in history_indexnow]

        if not new_indexnow_urls:
            print("No new URLs to submit to IndexNow. All URLs are present in history.")
        else:
            print(f"Identified {len(new_indexnow_urls)} new URL(s) to submit to IndexNow:")
            for url in new_indexnow_urls:
                print(f"  - {url}")

            payload = {
                "host": host,
                "key": key,
                "keyLocation": key_location,
                "urlList": new_indexnow_urls
            }

            payload_json = json.dumps(payload, indent=2).encode("utf-8")

            if args.dry_run:
                print("\n--- Dry Run IndexNow POST Request Details ---")
                print(f"Endpoint: {args.endpoint}")
                print("Payload:")
                print(json.dumps(payload, indent=2))
                print("--------------------------------------------")
                print("[Dry Run] IndexNow simulation completed. No request sent.")
            else:
                print(f"\nSending POST request to {args.endpoint}...")
                req = urllib.request.Request(
                    args.endpoint,
                    data=payload_json,
                    headers={"Content-Type": "application/json; charset=utf-8"},
                    method="POST"
                )
                try:
                    with urllib.request.urlopen(req) as response:
                        status_code = response.getcode()
                        response_body = response.read().decode("utf-8")
                    print(f"Response status: {status_code}")
                    if response_body:
                        print(f"Response body: {response_body}")
                    if status_code in (200, 202):
                        print("IndexNow submission successful!")
                        save_history(args.indexnow_history, new_indexnow_urls)
                        print(f"Updated IndexNow history file {args.indexnow_history}.")
                    else:
                        print(f"Warning: IndexNow returned unexpected status code {status_code}")
                except urllib.error.HTTPError as e:
                    status_code = e.code
                    error_body = e.read().decode("utf-8")
                    print(f"Error: IndexNow request failed with status code {status_code}")
                    print(f"Error body: {error_body}")
                    reasons = {
                        400: "Bad Request (Invalid format)",
                        403: "Forbidden (Invalid key or key verification failed)",
                        422: "Unprocessable Entity (URLs do not belong to the host, or key does not match protocol schema)",
                        429: "Too Many Requests (Rate limit exceeded / potential spam)"
                    }
                    if status_code in reasons:
                        print(f"Reason: {reasons[status_code]}")
                except urllib.error.URLError as e:
                    print(f"Error: Network request failed: {e.reason}")
                except Exception as e:
                    print(f"Error: An unexpected error occurred: {e}")
    else:
        print("\nIndexNow submission skipped via --skip-indexnow.")

    # --- Google Indexing Submission ---
    if not args.skip_google:
        print("\n" + "="*50)
        print("2. GOOGLE INDEXING SUBMISSION")
        print("="*50)

        # Filter new URLs for Google
        history_google = set() if args.force else load_history(args.google_history)
        new_google_urls = [url for url in urls if url not in history_google]

        if not new_google_urls:
            print("No new URLs to submit to Google Indexing. All URLs are present in history.")
        else:
            print(f"Identified {len(new_google_urls)} new URL(s) to submit to Google Indexing:")
            for url in new_google_urls:
                print(f"  - {url}")

            if args.dry_run:
                print("\n--- Dry Run Google Indexing API Details ---")
                print("Endpoint: https://indexing.googleapis.com/v3/urlNotifications:publish")
                print("URLs to submit (sequential POST requests):")
                for url in new_google_urls:
                    print(f"  POST -> {url} (Type: URL_UPDATED)")
                print("--------------------------------------------")
                print("[Dry Run] Google Indexing simulation completed. No requests sent.")
            else:
                # Get Access Token
                print("Resolving Google API authentication...")
                google_client_id, google_client_secret = load_google_credentials(BASE_CACHE_DIR)
                access_token = get_google_access_token(
                    client_id=google_client_id,
                    client_secret=google_client_secret,
                    token_path=args.google_token,
                    port=args.google_port
                )

                if not access_token:
                    print("Error: Could not obtain Google Access Token. Skipping Google Indexing.")
                else:
                    print(f"\nSubmitting {len(new_google_urls)} URL(s) to Google Indexing API...")
                    google_success_count = 0
                    successfully_submitted_urls = []

                    for i, url in enumerate(new_google_urls, 1):
                        print(f"  [{i}/{len(new_google_urls)}] Submitting {url} ... ", end="", flush=True)
                        status_code, body, error = submit_to_google(url, access_token)
                        if error:
                            print(f"Failed (HTTP {status_code or 'Error'}: {error})")
                            if body:
                                print(f"    Details: {body.strip()}")
                        else:
                            print("Ok")
                            google_success_count += 1
                            successfully_submitted_urls.append(url)

                    print(f"\nGoogle Indexing: Successfully submitted {google_success_count}/{len(new_google_urls)} URL(s).")

                    if successfully_submitted_urls:
                        save_history(args.google_history, successfully_submitted_urls)
                        print(f"Updated Google history file {args.google_history}.")
    else:
        print("\nGoogle Indexing submission skipped via --skip-google.")

if __name__ == "__main__":
    main()
