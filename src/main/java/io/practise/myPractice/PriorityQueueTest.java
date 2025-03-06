package io.practise.myPractice;

import java.util.PriorityQueue;

public class PriorityQueueTest {

  public static void main(String[] args) {

    PriorityQueue<Message> pq = new PriorityQueue<Message>();

    Message m1 = new Message("m1", 1.04);
    Message m2 = new Message("m2", 0.8);
    Message m3 = new Message("m3", 2.7);

    PriorityQueue<Message> queue = new PriorityQueue<Message>();

    queue.add(m1);
    queue.add(m2);
    queue.add(m3);

    while (!queue.isEmpty()) {
      System.out.println("Remove :" + queue.remove());
    }

  }
}

class Message implements Comparable<Message> {
  String id;
  double priority;

  public Message(String id, double priority) {
    this.id = id;
    this.priority = priority;
  }

  @Override
  public int compareTo(Message temp) {
    if (this.equals(temp))
      return 0;
    else if (this.priority > temp.priority)
      return -1;
    else
      return 1;
  }

  public String toString() {
    return this.id + " " + this.priority;
  }
}
