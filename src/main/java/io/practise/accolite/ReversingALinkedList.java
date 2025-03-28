package io.practise.accolite;

public class ReversingALinkedList {

    public static void main(String[] args) {

        Node last = new Node(5);

        Node lastFirst = new Node(4, last);

        Node lastSecond = new Node(3, lastFirst);

        Node lastThird = new Node(2, lastSecond);

        Node head = new Node(1, lastThird);

        traverseLinkedList(head);

        reverseLinkedList(head);

        traverseLinkedList(last);
    }

    private static void reverseLinkedList(Node head) {
        Node previous = null;

        Node current = head;

        while (current != null) {
            Node temp = current.next;

            current.next = previous;

            previous = current;

            current = temp;
        }
    }

    static void traverseLinkedList(Node head) {

        while (head.getNext() != null) {

            System.out.println(head.getVal());

            head = head.getNext();
        }

        if (head != null) {
            System.out.println(head.getVal());
        }
    }
}

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node nextNode) {
        this.val = val;
        this.next = nextNode;
    }

    public int getVal() {
        return val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}