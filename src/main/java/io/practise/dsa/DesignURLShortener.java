package io.practise.dsa;

import java.util.*;

public class DesignURLShortener {

    public static class Codec {
        private Map<String, String> map = new HashMap<>();
        private Map<String, String> reverse = new HashMap<>();
        private String base = "http://short.ly/";
        private int id = 1;

        public String encode(String longUrl) {
            if (reverse.containsKey(longUrl)) return base + reverse.get(longUrl);
            String code = Integer.toString(id++, 36);
            map.put(code, longUrl);
            reverse.put(longUrl, code);
            return base + code;
        }

        public String decode(String shortUrl) {
            String code = shortUrl.replace(base, "");
            return map.getOrDefault(code, "");
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        System.out.println("--- Design URL Shortener Demonstration ---");
        String originalUrl = "https://leetcode.com/problems/design-tinyurl";
        String shortUrl = codec.encode(originalUrl);
        System.out.println("Shortened URL: " + shortUrl);
        System.out.println("Decoded URL: " + codec.decode(shortUrl));
    }
}
