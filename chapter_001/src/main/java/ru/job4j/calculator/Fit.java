package ru.job4j.calculator;

public class Fit {

    public static double manWeight(int height) {
        return (height-100) * 1.15;
    }

    public static double womanWeight(double height) {
        return (height-110) * 1.15;
    }

    public static void main(String[] args) {
        double man = manWeight(180);
        double woman = womanWeight(189);
        System.out.println("Man 187 is " + man + ".kg weight");
        System.out.println("Woman 189 is " + woman + ".kg weight");
    }

}