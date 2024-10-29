package io.practise.Enums_Example;

class EnumInClass {
    public static void main(String[] args) {
        Season s = Season.WINTER;// enum type is required to access WINTER
        System.out.println(s);
    }

    enum Season {
        WINTER, SPRING, SUMMER, FALL;
    }// semicolon(;) is optional here
}
