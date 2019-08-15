package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;


public class TriangleTest {
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        Triangle triangle = new Triangle();
        // Вычисляем площадь.
        double result = triangle.area(0, 0, 0, 2, 2, 0);
        System.out.println(result);
        // Задаем ожидаемый результат.
        double expected = 2D;
        assertThat(result, closeTo(expected, 0.1));
    }
}
