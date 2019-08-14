package ru.job4j.condition;

public class SqArea {
    public static double square(double p, double k) {
        double width = Math.sqrt(k*k);
        double length = p / 2 - width;

        //System.out.println("length " + length);
        //System.out.println("width " + width);

        return length * width;
    }

    public static void main(String[] args) {
        double result = square(6, 2);
        System.out.println(" p = 6, k = 2, s = 1, real = " + result);

    }
}
