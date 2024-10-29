package io.practise.myPractice;

import java.util.HashMap;

public class HashMapDemo {

    public static void main(String[] args) {
        HashMap hm = new HashMap(10);

        hm.put("Sourv", 6);
        hm.put("Sanu", 4);
        hm.put("Shaw", 4);
        hm.put("Sourav", 35);
        hm.put(null, "Sour");
        System.out.println(hm.get(null));

        //TreeMap tm = new TreeMap(hm);
        //tm.put("Jassi", 78);

        System.out.println("HM");
        System.out.println(hm.containsValue(4) + " " + hm.size());
        System.out.println(hm.keySet() + " @@@@@@@@ " + hm);
        System.out.println(hm);
        System.out.println("TM");
        //System.out.println(tm.containsValue(4) + " " + tm.size());
        //System.out.println(tm.keySet() + " @@@@@@@@ " + tm);
        //System.out.println(tm);
    }
}
