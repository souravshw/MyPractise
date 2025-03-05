package io.practise.map;

import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class Test3 {
    public static void main(String[] args) {
        java.util.List<A> list = new java.util.ArrayList<A>();
        list.add(new B());
        list.add(new C());
        for (A a : list) {
            a.x();
            //a.y();
        }

        Drink one = new Drink();
        Drink two = new Drink();
        one.name= "Coffee";
        two.name= "Tea";

        TreeSet set = new TreeSet();

        set.add(one);
        set.add(two);

        System.out.println(set.size());

        set.stream().forEach(System.out::println);
    }

    public static int sum(List list) {
        int sum = 0;

        for (Iterator iter = list.iterator(); iter.hasNext(); ) {
            int i = ((Integer)iter.next()).intValue();
            sum += i;
        }
        return sum;
    }
}

interface A { void x(); }
class B implements A { public void x() {} public void y() {} }
class C extends B { public void x() {} }

class Drink implements Comparable {
    public String name;
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                '}';
    }
}
