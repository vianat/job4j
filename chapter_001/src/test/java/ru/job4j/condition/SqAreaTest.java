package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class SqAreaTest {

    @Test
    public void checkDistance() {
        int perimeter = 6;
        int coefficient = 2;

        int expected = 2;

        double out = SqArea.square(perimeter, coefficient);
        Assert.assertEquals(expected, out, 1);
    }

    @Test
    public void checkDistance2() {
        int perimeter = 60;
        int coefficient = 2;

        int expected = 56;

        double out = SqArea.square(perimeter, coefficient);
        Assert.assertEquals(expected, out, 1);
    }

}
