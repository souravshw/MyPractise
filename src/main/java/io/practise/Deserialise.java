package io.practise;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

//Deserialization is the process of reconstructing the object from the serialized state.It is the reverse operation of serialization.
public class Deserialise {
  public static void main(String[] args) throws Exception {
    //public ObjectInputStream(InputStream in) throws IOException {}-creates an ObjectInputStream that reads from the specified InputStream.
    ObjectInputStream in = new ObjectInputStream(new FileInputStream("E:/serialise.txt"));
    Student s = (Student) in.readObject();
    System.out.println(s.id + " " + s.name);

    in.close();
  }
}
