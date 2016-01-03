package Serialisation_Examples;

/*
Serialization in java is a mechanism of writing the state of an object into a byte stream.

It is mainly used in Hibernate, RMI, JPA, EJB, JMS technologies.

The reverse operation of serialization is called deserialization.
*/
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable {
	int id;
	String name;

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
}

// Serializable is a marker interface (has no body).
// It is just used to "mark" java classes which support a certain capability.
// It must be implemented by the class whose object you want to persist.
// Let's see the example given below:
public class Serialize {
	public static void main(String args[]) throws Exception {
		Student s1 = new Student(211, "ravi");

		// The ObjectOutputStream class is used to write primitive data types
		// and Java objects to an OutputStream.
		// Only objects that support the java.io.Serializable interface can be
		// written to streams.
		FileOutputStream fout = new FileOutputStream("C:\\Users\\Sanu\\Desktop\\serialise.ser");
		ObjectOutputStream out = new ObjectOutputStream(fout);
		// public final void writeObject(Object obj) throws IOException
		// {}-writes the specified object to the ObjectOutputStream.
		out.writeObject(s1);
		// public void flush() throws IOException {}-flushes the current output
		// stream.
		out.flush();
		// public void close() throws IOException {}-closes the current output
		// stream.
		out.close();
		System.out.println("success");
	}
}
