package io.practise.accolite;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


import java.io.InputStreamReader;


public class LinkAnalyzer {

    // --- Configuration ---
    private static final String CSV_FILE_PATH = "C:\\Users\\SouravSanuShaw\\Downloads\\Merged_Links.csv";; // Input CSV file with URLs
    private static final String SPAM_LINKS_FILE_PATH = "spam_links.txt"; // Output file for spam links
    private static final String NEGATIVE_KEYWORD = "Negative"; // Keyword to check for "Allowed" status
    private static final int CONNECTION_TIMEOUT_MS = 5000; // 5 seconds for connection timeout
    private static final int READ_TIMEOUT_MS = 10000;      // 10 seconds for read timeout

    public static void main(String[] args) {
        System.out.println("Starting Link Analysis...");

        List<String> urlsToProcess = new ArrayList<>();
        List<String> spamLinks = new ArrayList<>();

        // Step 1: Extract all links from the CSV file
        System.out.println("Reading URLs from: " + CSV_FILE_PATH);
        try {
            urlsToProcess = readUrlsFromCsv(CSV_FILE_PATH);
            System.out.println("Found " + urlsToProcess.size() + " URLs to process.");
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
            System.err.println("Please ensure '" + CSV_FILE_PATH + "' exists and is accessible.");
            return; // Exit if CSV cannot be read
        }

        // Step 2 & 3: Visit each link and analyze its content
        System.out.println("\nVisiting and analyzing each link...");
        for (String urlString : urlsToProcess) {
            System.out.print("Processing: " + urlString + " -> ");
            try {
                String pageContent = fetchUrlContent(urlString);

                // Simulate XPath check by searching for the keyword
                // IMPORTANT: Without external HTML parsing libraries, true XPath for HTML is not possible.
                // This approach relies on the 'ALLOWED_KEYWORD' being present in the raw HTML content.
                if (pageContent != null && !pageContent.contains(NEGATIVE_KEYWORD)) {
                    System.out.println("Status: Positive");
                } else {
                    System.out.println("Status: SPAM (Keyword '" + NEGATIVE_KEYWORD + "'found)");
                    spamLinks.add(urlString);
                }
            } catch (IOException e) {
                System.err.println("Error visiting or reading content from " + urlString + ": " + e.getMessage());
                spamLinks.add(urlString); // Consider links that cause errors as spam for safety
            }
        }

        // Step 4: Save the spam links to a new file
        System.out.println("\nSaving spam links to: " + SPAM_LINKS_FILE_PATH);
        try {
            writeLinksToFile(SPAM_LINKS_FILE_PATH, spamLinks);
            System.out.println("Successfully saved " + spamLinks.size() + " spam links.");
        } catch (IOException e) {
            System.err.println("Error writing spam links to file: " + e.getMessage());
        }

        System.out.println("\nLink Analysis Completed.");
    }

    /**
     * Reads URLs from a CSV file, assuming one URL per line.
     *
     * @param filePath The path to the CSV file.
     * @return A list of URLs.
     * @throws IOException If an I/O error occurs.
     */
    private static List<String> readUrlsFromCsv(String filePath) throws IOException {
        List<String> urls = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Trim whitespace and ensure the line is not empty before adding
                String trimmedLine = line.trim();
                if (!trimmedLine.isEmpty()) {
                    urls.add(trimmedLine);
                }
            }
        }
        return urls;
    }

    /**
     * Fetches the HTML content of a given URL.
     *
     * @param urlString The URL to fetch.
     * @return The content of the web page as a String, or null if an error occurs.
     * @throws IOException If an I/O error occurs during connection or reading.
     */
    private static String fetchUrlContent(String urlString) throws IOException {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(CONNECTION_TIMEOUT_MS); // Set connection timeout
            connection.setReadTimeout(READ_TIMEOUT_MS);         // Set read timeout
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36"); // Good practice to set User-Agent

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    StringBuilder content = new StringBuilder();
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        content.append(inputLine);
                    }
                    return content.toString();
                }
            } else {
                // Log non-200 responses
                System.err.println("HTTP GET request failed for " + urlString + ". Response Code: " + responseCode);
                return null;
            }
        } finally {
            if (connection != null) {
                connection.disconnect(); // Always close the connection
            }
        }
    }

    /**
     * Writes a list of links to a specified file, one link per line.
     *
     * @param filePath The path to the output file.
     * @param links    The list of links to write.
     * @throws IOException If an I/O error occurs.
     */
    private static void writeLinksToFile(String filePath, List<String> links) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String link : links) {
                bw.write(link);
                bw.newLine();
            }
        }
    }
}
