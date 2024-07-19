package io.practise.Enums_Example;

enum Season {
    WINTER, SPRING, SUMMER, FALL
}

class EnumOutsideClass {

    public static void main(String[] args) {
        Season s = Season.WINTER;
        System.out.println(s);
    }
}
