package advancedClassDesign;

public class Book {

	private int ISBN;
	private String author, title;
	private int pageCount;

	public int hashCode() {
		return ISBN;
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Book)) {
			return false;
		}
		Book other = (Book) obj;
		return this.ISBN == other.ISBN;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
