package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;


public class TriangleTest {
    @Test
    public void triangle113133() {
        Triangle triangle = new Triangle(new Point(1, 1), new Point(3, 1), new Point(3, 3));
        double result = triangle.area(triangle);
        double expected = 2;
        assertThat(result, closeTo(expected, 0.1));
    }
    @Test
    public void triangle00101015() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(10, 10), new Point(1, 5));
        double result = triangle.area(triangle);
        double expected = 20;
        assertThat(result, closeTo(expected, 0.1));
    }
    @Test
    public void distance3D() {
        Point first = new Point(0, 0, 0);
        Point second = new Point(5, 5, 5);
        double result = first.distance3d(second);
//        Triangle triangle = new Triangle(new Point(0, 0, 0), new Point(5, 5, 5), new Point(5, 0, 0));
//        double result = triangle.distance3d(); //не знаю как через треугольник вызвать
        double expected = 8.66;
        assertThat(result, closeTo(expected, 0.1));
    }
}
