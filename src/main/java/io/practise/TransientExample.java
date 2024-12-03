package io.practise;

import java.io.*;

public class TransientExample {

    public static void main(String args[]) throws Exception {
        TStudent s1 = new TStudent(211, "ravi");

        // The ObjectOutputStream class is used to write primitive data types
        // and Java objects to an OutputStream.
        // Only objects that support the java.io.Serializable interface can be
        // written to streams.
        FileOutputStream fout = new FileOutputStream("E:/transient.txt");
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

        System.out.println("success to write :\n ");

        // public ObjectInputStream(InputStream in) throws IOException
        // {}-creates an ObjectInputStream that reads from the specified
        // InputStream.
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(
                "E:/transient.txt"));
        TStudent s = (TStudent) in.readObject();
        System.out.println(s.id + " " + s.name);

        in.close();

    }
}

class TStudent implements Serializable {
    transient int id = -7;
    String name = "KALHONAJHOO";

    public TStudent(int id, String name) {
        this.id = id;
        this.name = name;
    }
}