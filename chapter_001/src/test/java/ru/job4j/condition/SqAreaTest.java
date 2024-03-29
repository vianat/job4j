package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SqAreaTest {

    @Test
    public void whenp4k1s1() {
        int k = 1;
        int p = 4;
        double expected = 1;
        double s = SqArea.square(p, k);
        assertThat(s, is(expected));
    }
    @Test
    public void whenp6k2s2() {
        int k = 2;
        int p = 6;
        double expected = 2;
        double s = SqArea.square(p, k);
        assertThat(s, is(expected));
    }
}
