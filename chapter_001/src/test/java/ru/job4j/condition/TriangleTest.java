package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;


public class TriangleTest {
    @Test
    public void triangle1_1_3_1_3_3() {
        Triangle triangle = new Triangle(new Point(1, 1), new Point(3, 1), new Point(3, 3));
        double result = triangle.area(triangle);
        double expected = 2;
        assertThat(result, closeTo(expected, 0.1));
    }
    @Test
    public void triangle0_0_10_10_1_5() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(10, 10), new Point(1, 5));
        double result = triangle.area(triangle);
        double expected = 20;
        assertThat(result, closeTo(expected, 0.1));
    }
}
