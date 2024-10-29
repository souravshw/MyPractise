package io.practise;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//If a class implements serializable then all its sub classes will also be serializable. Let's see the example given below:
class SuperclassPerson implements Serializable {

    int id;
    String name;

    SuperclassPerson(int id, String name) {
        this.id = id;
        this.name = name;

    }

}

class SubclassStudent extends SuperclassPerson {
    String course;
    int fee;

    public SubclassStudent(int id, String name, String course, int fee) {
        super(id, name);
        this.course = course;
        this.fee = fee;
    }
}

public class Serialiseisa {
    public static void main(String args[]) throws Exception {
        SubclassStudent s1 = new SubclassStudent(211, "ravi", "Done", 300);

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