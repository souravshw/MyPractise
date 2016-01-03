package myPractice;
/*
 *@author Sourav Sanu Shaw
 * Selection Sort
 * Demonstration of selection sort
 */
public class SelectionSort {

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

		int in, out;
		double min;
		ac.display();
		for (out = 0; out < ac.getNElem() - 1; out++) {
			min = ac.getIndElement(out);
			for (in = out + 1; in < ac.getNElem(); in++) {
				if (ac.getIndElement(in) < min)
					ac.swap(in, out);
			}
		}
		ac.display();
	}

}
