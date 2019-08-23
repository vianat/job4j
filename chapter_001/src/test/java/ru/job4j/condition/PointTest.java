package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void checkDistance() {
        int x1 = 1;
        int y1 = 2;
        int x2 = 3;
        int y2 = 4;
        int expected = 2;
        double out = Point.distance(x1, y1, x2, y2);
        Assert.assertEquals(expected, out, 1);
    }
}
