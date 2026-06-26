package io.practise.dsa;

import java.util.*;

public class DesignHitCounter {

    public static class HitCounter {
        private Queue<Integer> queue = new LinkedList<>();

        public void hit(int timestamp) {
            queue.offer(timestamp);
        }

        public int getHits(int timestamp) {
            while (!queue.isEmpty() && timestamp - queue.peek() >= 300) {
                queue.poll();
            }
            return queue.size();
        }
    }

    public static void main(String[] args) {
        HitCounter counter = new HitCounter();
        System.out.println("--- Design Hit Counter Demonstration ---");
        counter.hit(1);
        counter.hit(2);
        counter.hit(3);
        System.out.println("Hits at timestamp 4: " + counter.getHits(4)); // 3
        System.out.println("Hits at timestamp 300: " + counter.getHits(300)); // 3
        System.out.println("Hits at timestamp 301: " + counter.getHits(301)); // 2 (hit at 1 expired)
    }
}
