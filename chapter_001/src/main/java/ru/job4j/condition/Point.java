package ru.job4j.condition;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
public class Point {
    private int x;
    private int y;
    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }
    public void info() {
        System.out.println(String.format("Point[%s, %s]", this.x, this.y));
    }
    public double distance(Point that) {
        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2));
    }
    public static void main(String[] args) {
        Point first = new Point(1, 1);
        Point second = new Point(5, 5);

        double result = first.distance(second);
        System.out.println("result (1, 1) to (5, 5) " + result);
    }
}