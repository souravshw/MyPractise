package advancedClassDesign;

public class StringEqulals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "sourav";
		String s2 = new String(s1);

		if (s1 == s2)
			System.out.println("s1 == s2");
		if (s1.equals(s2))
			System.out.println("s1.equals(s2)");

	}

}
