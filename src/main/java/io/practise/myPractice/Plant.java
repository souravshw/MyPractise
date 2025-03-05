package io.practise.myPractice;

import java.util.HashSet;

public class Plant {

    public static final String FOO = "foo";

    public static void main(String[] args) {

        Plant b = new Plant();
        Sub s = new Sub();

        System.out.print(Plant.FOO);
        System.out.print(Sub.FOO);
        System.out.print(b.FOO);
        System.out.print(s.FOO);
        System.out.print(((Plant) s).FOO);

        test(null);
        new Three();
    }

    public static void test(String str) {
        if (str == null || str.length() == 0) {
            System.out.println("String is empty");
        } else {
            System.out.println("String is not empty");
        }
    }
}

class Sub extends Plant {
    public static final String FOO = "bar";
}

class One {
    public One() {
        System.out.print(1);
    }
}

class Two extends One {
    public Two() {
        System.out.print(2);
    }

    Two debug() {
        return this;
    }
}

class Three extends Two {
    public Three() {
        System.out.print(3);
    }
}


class Uber {
    static int y = 2;

    Uber(int x) {
        this();
        y = y * 2;
    }

    Uber() {
        y++;
    }
}

class Minor extends Uber {
    Minor() {
        super(y);
        y = y + 3;
    }

    public static void main(String[] args) {
        new Minor();
        System.out.println(y);
    }
}


class WrappedString {
    private String s;
    public static final int EASY = 3;

    public WrappedString(String s) {
        this.s = s;
    }

    public WrappedString(){

    }

    public static void main(String[] args) {
        HashSet<Object> hs = new HashSet<>();

        WrappedString ws1 = new WrappedString("aardvark");
        WrappedString ws2 = new WrappedString("aardvark");

        String s1 = new String("aardvark");
        String s2 = new String("aardvark");

        hs.add(ws1);
        hs.add(ws2);
        hs.add(s1);
        hs.add(s2);

        System.out.println(hs.toString());

        int x = 5;
        new WrappedString().doStuff(++x);
    }

  void doStuff(int s) {
      s= s+EASY+ ++s;
      //6 + 3 + 7
      System.out.println("s " + s);

      s += EASY + ++s;
      System.out.println("s " + s);
  }
}
