package io.practise.InnerClass;

public class LocalInner {
    // A class i.e. created inside a method is called local inner class in java.
    // If you want to invoke the methods of local inner class, you must
    // instantiate this class inside the method.
    private int data = 30;// instance variable

    public static void main(String args[]) {
        LocalInner obj = new LocalInner();
        obj.display();
    }

    void display() {
        class Local {
            void msg() {
                System.out.println(data);
            }
        }
        Local l = new Local();
        l.msg();
    }
}