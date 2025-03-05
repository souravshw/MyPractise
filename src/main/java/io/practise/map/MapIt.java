package io.practise.map;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

class KeyMaster {
    public int i;

    public static int count = 0;

    public KeyMaster(int i) {
        ++count;
        this.i = i;
    }

    public boolean equals(Object o) {
        return i == ((KeyMaster) o).i;
    }

    public int hashCode() {
        return i;
    }
}

public class MapIt implements ABC, XYZ {
    public static void main(String[] args) throws IOException {

        Files.readAllLines(Path.of(""));


        Set<KeyMaster> set = new HashSet<KeyMaster>();
        KeyMaster k1 = new KeyMaster(1);
        KeyMaster k2 = new KeyMaster(2);
        set.add(k1);
        set.add(k1);
        set.add(k2);
        set.add(k2);
        System.out.print(set.size() + ":");
        k2.i = 1;
        System.out.print(set.size() + ":");
        set.remove(k1);
        System.out.print(set.size() + ":");
        set.remove(k2);
        System.out.print(set.size());
    }


    @Override
    public void abc() {

    }

    @Override
    public void stop() {
        ABC.super.stop();
    }

    @Override
    public void test() {

    }
}

interface ABC {
    void abc() ;

    default void stop() {
        System.out.println("hello");
    }
}

interface XYZ {
    void test() ;

    default void stop() {
        System.out.println("world");
    }
}