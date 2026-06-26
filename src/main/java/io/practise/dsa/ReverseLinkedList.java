package io.practise.dsa;

public class ReverseLinkedList {

    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val) { this.val = val; }
    }

    // Optimized - Iterative O(n)
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }

    public static void main(String[] args) {
        ReverseLinkedList solver = new ReverseLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        System.out.println("--- Reverse Linked List Demonstration ---");
        System.out.print("Original List: ");
        printList(head);

        ListNode reversed = solver.reverseList(head);
        System.out.print("Reversed List: ");
        printList(reversed);
    }

    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }
}
