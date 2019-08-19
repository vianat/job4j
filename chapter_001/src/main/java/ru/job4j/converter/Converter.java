package ru.job4j.converter;

public class Converter {

    public static int rubleToEuro(int value) {
        return value / 70;
    }

    public static int rubleToDollar(int value) {
        return value / 60;
    }

    public static int euroToRub(int value) {
        return value * 70;
    }

    public static int dollarToRub(int value) {
        return value * 60;
    }

    public static void main(String[] args) {
        int[] in = {140, 60, 3, 4};
        int[] expected = {2, 1, 210, 240};

        boolean passed = expected[0] == rubleToEuro(in[0]);
        boolean passed1 = expected[1] == rubleToDollar(in[1]);
        boolean passed2 = expected[2] == euroToRub(in[2]);
        boolean passed3 = expected[3] == dollarToRub(in[3]);

        System.out.println("140 rubles are 2. Test result : " + passed);
        System.out.println("60 rubles are 1. Test result : " + passed1);
        System.out.println("3 euro are 210. Test result : " + passed2);
        System.out.println("4 dollar are 240. Test result : " + passed3);
    }
}