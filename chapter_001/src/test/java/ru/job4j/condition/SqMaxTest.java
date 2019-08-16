package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SqMaxTest {

    @Test
    public void test() {
        int first = 1;
        int second = 1;
        int third = 3;
        int forth = 1;
        int expected = 3;
        int s = SqMax.max(first, second, third, forth);
        assertThat(s, is(expected));
    }

}
