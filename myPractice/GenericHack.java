package myPractice;

public class GenericHack {

	public static void main(String[] args) {
		 	}

}
class Printer
{

	public <T> void printArray(T[] arr) {
		for(T t : arr){
			System.out.println(t.toString());
		}
	}
  
 
}