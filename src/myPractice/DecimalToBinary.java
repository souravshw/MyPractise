package myPractice;
public class DecimalToBinary {

	public static String convertToBinary(int num) {
		String binary = "";
		while (num > 0) {
			if (num % 2 == 0) {
				binary = binary.concat("0");
				num /= 2;
			} else {
				--num;
				binary = binary.concat("1");
				num /= 2;
			}
		}
		return binary;
	}

	public static void main(String[] args) {
		int num = 127;
		String bin = convertToBinary(num);
		System.out.println(bin);
	}
}