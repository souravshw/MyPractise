package Exception_Examples;

import java.io.IOException;

class OverridenClass {
	
	/*If the superclass method does not declare an exception If the superclass
	 * method does not declare an exception, subclass overridden method cannot
	 * declare the checked exception but it can declare unchecked exception. If
	 * the superclass method declares an exception If the superclass method
	 * declares an exception, subclass overridden method can declare same,
	 * subclass exception or no exception but cannot declare parent exception. 
	 */

	OverridenClass msg() throws Exception {
		System.out.println("parent");
		return this;
	}
}

public class OverridingExample extends OverridenClass {
	OverridingExample msg() throws IOException {
		System.out.println("TestExceptionChild");
		return this;
	}

	public static void main(String args[]) {
		OverridenClass p = new OverridingExample();
		try {
			p.msg();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}