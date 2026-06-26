package io.practise.dsa;

public class DetectCycleLinkedList {

    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val) { this.val = val; }
    }

    // Optimized - Floyd's Cycle Detection - O(n)
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        DetectCycleLinkedList solver = new DetectCycleLinkedList();
        ListNode head = new ListNode(3);
        ListNode cycleNode = new ListNode(2);
        head.next = cycleNode;
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = cycleNode; // Cycle created

        System.out.println("--- Detect Cycle in Linked List Demonstration ---");
        System.out.println("Floyd's Tortoise and Hare algorithm maps fast pointer and slow pointer.");
        System.out.println("Has Cycle: " + solver.hasCycle(head));
    }
}
