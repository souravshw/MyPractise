package io.practise.dsa;

import java.util.*;

public class DesignTwitter {

    public static class Twitter {
        private static int timeStamp = 0;
        
        static class Tweet {
            int id, time;
            Tweet next;
            public Tweet(int id) {
                this.id = id;
                this.time = timeStamp++;
            }
        }
        
        static class User {
            int id;
            Set<Integer> followed;
            Tweet head;
            public User(int id) {
                this.id = id;
                followed = new HashSet<>();
                follow(id); // Follow self
            }
            void follow(int userId) { followed.add(userId); }
            void unfollow(int userId) { if (userId != id) followed.remove(userId); }
            void post(int tweetId) {
                Tweet t = new Tweet(tweetId);
                t.next = head;
                head = t;
            }
        }

        private Map<Integer, User> userMap = new HashMap<>();

        public void postTweet(int userId, int tweetId) {
            userMap.putIfAbsent(userId, new User(userId));
            userMap.get(userId).post(tweetId);
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> res = new ArrayList<>();
            if (!userMap.containsKey(userId)) return res;
            PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);
            for (int uid : userMap.get(userId).followed) {
                Tweet t = userMap.get(uid).head;
                if (t != null) pq.offer(t);
            }
            while (!pq.isEmpty() && res.size() < 10) {
                Tweet t = pq.poll();
                res.add(t.id);
                if (t.next != null) pq.offer(t.next);
            }
            return res;
        }

        public void follow(int followerId, int followeeId) {
            userMap.putIfAbsent(followerId, new User(followerId));
            userMap.putIfAbsent(followeeId, new User(followeeId));
            userMap.get(followerId).follow(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (userMap.containsKey(followerId)) {
                userMap.get(followerId).unfollow(followeeId);
            }
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        System.out.println("--- Design Twitter Demonstration ---");
        twitter.postTweet(1, 5);
        System.out.println("News Feed for User 1: " + twitter.getNewsFeed(1)); // [5]
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println("News Feed for User 1 after following 2: " + twitter.getNewsFeed(1)); // [6, 5]
    }
}
