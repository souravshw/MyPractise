package io.practise.myPractice;
/*
 * @author Sourav Sanu Shaw
 * Bubble Sort
 * Demonstration of Bubble sort
 */

public class BubbleSort {
	public static void main(String[] args) {

		ArraysClass as = new ArraysClass();
		as.initializeArray(10);

		as.insert(3);
		as.insert(1);
		as.insert(14);
		as.insert(7);
		as.insert(5);
		as.insert(8);
		as.insert(19);
		as.insert(21);
		as.insert(16);
		as.insert(36);

		as.display();
		for (int out = as.getNElem() - 1; out > 1; out--) {
			for (int in = 0; in < out; in++) {
				if (as.getIndElement(in) > as.getIndElement(in + 1))
					as.swap(in, in + 1);
			}
		}

		as.display();
	}
}