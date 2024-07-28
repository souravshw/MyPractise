package io.practise.myPractice;

/*
 *@author Sourav Sanu Shaw
 * Insertion Sort
 * Demonstration of Insertion sort
 */
public class InsertionSort {

  public static void main(String[] args) {

    ArraysClass ac = new ArraysClass();
    ac.initializeArray(10);

    ac.insert(3);
    ac.insert(1);
    ac.insert(14);
    ac.insert(7);
    ac.insert(5);
    ac.insert(8);
    ac.insert(19);
    ac.insert(21);
    ac.insert(16);
    ac.insert(36);

    ac.display();

    int out, in;
    double temp;
    for (out = 1; out < ac.getNElem(); out++) {
      temp = ac.getIndElement(out);
      in = out;
      while (in > 0 && ac.getIndElement(in - 1) > temp) {
        ac.swap(in - 1, in);
        in--;
      }

      ac.insertAtIndex(in, temp);
    }

    ac.display();
  }
}