package io.practise.myPractice;

public class ReverseList {


    public static void main(String[] args) {
        Data o1, o2, o3, o4, o5;
        o1 = new Data();
        o2 = new Data();
        o3 = new Data();
        o4 = new Data();
        o5 = new Data();

        o1.setValue(1);
        o1.setData(o2);
        o2.setValue(2);
        o2.setData(o3);
        o3.setValue(3);
        o3.setData(o4);
        o4.setValue(4);
        o4.setData(o5);
        o5.setValue(5);
        o5.setData(null);


        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o3);
        System.out.println(o4);
        System.out.println(o5);

        Data before = o1;
        Data after = before.getData();
        int counter = 0;

        while (after.getData() != null) {
            Data temp = after.getData();
            after = after.getData();
            temp.setData(before);

            ++counter;
        }
        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o3);
        System.out.println(o4);
        System.out.println(o5);


//reversal logic
        while (counter > 0) {
            after = before.getData();
            before = after.getData();
            --counter;
        }
        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o3);
        System.out.println(o4);
        System.out.println(o5);

    }
}

class Data {
    int value;
    Data data;

    public Data() {

    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Data{" +
                "value=" + value +
                ", data=" + data +
                '}';
    }
}
