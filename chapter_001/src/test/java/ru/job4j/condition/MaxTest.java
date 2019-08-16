package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenLeftLessThenRight() {
        Max max = new Max();
        int result = max.max(0, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenLeftMoreThenRight() {
        Max max = new Max();
        int result = max.max(2, 0);
        assertThat(result, is(2));
    }
    @Test
    public void whenLeftEqualRight() {
        Max max = new Max();
        int result = max.max(2, 2);
        assertThat(result, is(2));
    }

}