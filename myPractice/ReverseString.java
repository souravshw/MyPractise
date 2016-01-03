package myPractice;
public class ReverseString {

	public static String makeRev(String str, int length) {
		if (length == 0)
			return str;
		String rev = str.substring(length - 1) + makeRev(str.substring(0, length - 1), length - 1);
		return rev;
	}

	public static void main(String[] args) {
		String str = "Sourav";
		String newStr = makeRev(str, str.length());
		System.out.println(newStr);
	}
}