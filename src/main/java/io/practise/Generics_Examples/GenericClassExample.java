package io.practise.Generics_Examples;

public class GenericClassExample<T> {
    T obj;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        GenericClassExample<String> d1 = new GenericClassExample<String>();
        String opt = d1.printDoubleLogic("Hello");
        GenericClassExample<Integer> d2 = new GenericClassExample<Integer>();
        int optint = d2.printDoubleLogic(5);
        System.out.println(opt + " \n" + optint);

    }

    T printDoubleLogic(T t1) {
        if (t1 instanceof Integer) {
            int tempint = ((Integer) t1).intValue();
            tempint = tempint * 2;
            obj = (T) new Integer(tempint);
            return obj;
        }

        String t2 = t1 + " " + t1;
        obj = (T) new String(t2);
        return obj;
    }

}