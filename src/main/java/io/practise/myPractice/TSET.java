package io.practise.myPractice;

interface Foo {
    int bar();
}

public class TSET {
    class A implements Foo {

        @Override
        public int bar() {
            return 1;
        }
    }

    public int fubar(Foo foo) {
        return foo.bar();
    }

    public void testFoo() {
        class A implements Foo {
            public int bar() {
                return 2;
            }
        }
        System.out.println(fubar(new A()));
    }

    public static void main(String[] args) {
        new TSET().testFoo();
    }

}