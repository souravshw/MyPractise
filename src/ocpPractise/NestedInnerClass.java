/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocpPractise;

/**
 *
 * @author sanu
 */
public class NestedInnerClass {

    private int a = 1;

    class B {

        private int b = 2;

        class C extends B {

            private int c = 3;

            class D extends C {

                private int d = 4;

                public void printAll() {
                    System.out.println("Inside the inner Most Class");
                    System.out.println(this.d);
                    System.out.println(C.this.c);
                    System.out.println(B.this.b);
                    System.out.println(NestedInnerClass.this.a);
                }
            }
        }
    }

    public static void main(String[] args) {
        NestedInnerClass nic = new NestedInnerClass();

        System.out.println(nic.a);

        B b = nic.new B();
        System.out.println(b.b);

        B.C c = b.new C(); //It will not work because the visibilily of C in entirely inside B; To make it visible we will have to import that class.
        System.out.println(c.c);

        B.C.D d = c.new D();
        System.out.println(d.d);

        d.printAll();

    }
}
