package io.practise.myPractice;

public class Cartridge {

    public static void main(String args[]) {
        color<T> name = new color<T>(new T(), " Blue");
        name.toString();
    }
}

@SuppressWarnings("hiding")
class color<T> {
    private T o;
    private String rang;

    public color(T obj, String str) {
        this.o = obj;
        this.rang = str;
    }
}

class T {
    @Override
    public String toString() {
        return "My Name is T and i am not a Terrorist.";
    }
}
