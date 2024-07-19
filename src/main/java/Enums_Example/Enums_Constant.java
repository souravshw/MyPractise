package Enums_Example;

enum Season4 {
    WINTER(5, 8), SPRING(10, 9), SUMMER(15, 6), FALL(20, 2);
    int value1, value2;

    private Season4(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }
}

class Enums_Constant {

    public static void main(String args[]) {

        for (Season4 s : Season4.values()) {
            System.out.println(s + " " + s.value1 + " " + s.value2);
        }

        Season4 s1 = Season4.WINTER;
        System.out.println(s1 + " " + s1.value1 + " " + s1.value2);

    }
}
