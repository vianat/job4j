package ru.job4j.condition;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
public class Point {
    private int x;
    private int y;
    private int z;

    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }
    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public void info() {
        System.out.println(String.format("Point[%s, %s]", this.x, this.y));
    }
    public double distance(Point that) {
        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2));
    }
    public static double distance3d(Point that, Point that2) {
        double aa = sqrt(   pow((that2.x - that.x), 2) +
                            pow((that2.y - that.y), 2) +
                            pow((that2.z - that.z), 2) );
        return aa;
    }
//    public static void main(String[] args) {
//        Point first = new Point(0, 0, 0);
//        Point second = new Point(5, 5, 5);
//        double result = Point.distance3d(first, second);
//        System.out.println(result);
//    }
}