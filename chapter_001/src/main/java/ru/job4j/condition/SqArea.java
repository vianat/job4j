package ru.job4j.condition;

public class SqArea {
    public static double square(double p, double k) {
        double h = p / (2 * (k + 1));
        double w = k * h;
        double s = w * h;
        return s;
    }

    public static void main(String[] args) {
        double result = square(6, 2);
        System.out.println(" p = 6, k = 2, s = 1, real = " + result);
    }
}
