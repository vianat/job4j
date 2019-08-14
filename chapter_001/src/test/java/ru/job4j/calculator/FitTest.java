package ru.job4j.calculator;

import org.junit.Assert;
import org.junit.Test;

public class FitTest {

    @Test
    public void calculateManWeight() {
        int in = 180;
        int expected = 92;
        double out = Fit.manWeight(in);
        Assert.assertEquals(expected, out, 1);
    }

    @Test
    public void calculateWomenWeight() {
        int in = 189;
        int expected = 91;
        double out = Fit.womanWeight(in);
        Assert.assertEquals(expected, out, 1);
    }
}
