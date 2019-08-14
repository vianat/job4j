package ru.job4j.converter;

import org.junit.Assert;
import org.junit.Test;

public class ConverterTest {

    @Test
    public void rubleToEuro() {
        int in = 140;
        int expected = 2;
        int out = Converter.rubleToEuro(in);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void rubleToDollar() {
        int in = 180;
        int expected = 3;
        int out = Converter.rubleToDollar(in);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void DollarFromRub() {
        int in = 1;
        int expected = 60;
        int out = Converter.dollarToRub(in);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void EuroFromRub() {
        int in = 1;
        int expected = 70;
        int out = Converter.euroToRub(in);
        Assert.assertEquals(expected, out);
    }
}
