package io.practise.accolite;

public class LinkedListLoopDetector {

    public static void main(String[] args) {


    }
}


class Node1 {
    String data;
    Node1 nextNode;
    boolean isTraversed;

    Node1(String data, Node1 nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public String getData() {
        return data;
    }

    public Node1 getNextNode() {
        return nextNode;
    }
}
