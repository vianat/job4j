package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CounterTest {
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        int start = 0;
        int finish = 10;
        int expected = 30;
        int s = Counter.add(start, finish);
        assertThat(s, is(expected));
    }
}