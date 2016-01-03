package myPractice;
/*
 * This Array Class is used for creation arrays in this package or other packages.
 *  This class could display all the elements of the array individually.
 *  It can insert elements in the array and can also returns total no. of elements in the array.
 *  It can also swap the two elements in the array.
 *  
 *  @author Sourav Sanu Shaw
 */
public class ArraysClass {

	private double[] arr;
	private int nElem;

	public void initializeArray(int size) {
		arr = new double[size];
		nElem = 0;
	}

	public void display() {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.print("]\n");
	}

	public void insert(int elem) {
		arr[nElem] = elem;
		nElem++;
	}

	public double[] getArray() {
		return arr;
	}

	public int getNElem() {
		return nElem;
	}

	public double getIndElement(int index) {
		return arr[index];
	}

	public void insertAtIndex(int index, double elem) {
		arr[index] = elem;
	}

	public void swap(int index1, int index2) {
		double temp;
		System.out.println("Swapping " + arr[index1] + " " + arr[index2]);
		temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}