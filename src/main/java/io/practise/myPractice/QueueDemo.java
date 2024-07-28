package io.practise.myPractice;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {

  public static void main(String[] args) {
    ArrayListDemo Ob = new ArrayListDemo();
    Ob.addList();
    Queue q = new LinkedList(Ob.getArrList());
    PriorityQueue pq = new PriorityQueue(q);
    System.out.println(pq + " " + pq.size());

    while (!pq.isEmpty()) {
      System.out.println(pq.poll());
    }
  }
}