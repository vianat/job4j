package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestTaskTest {
    @Test
    public void check2ArrayMerge() {
        TestTask matrix = new TestTask();
        int[] aaa = {1, 3};
        int[] bbb = {2, 4};
        int[] expected = {1, 2, 3, 4};
        int[] result = matrix.merge2array(aaa, bbb);
        assertThat(result, is(expected));
    }
    @Test
    public void checkArrayMerge() {
        TestTask matrix = new TestTask();
        int[] aaa = {1, 3, 5, 8, 1};
        int[] bbb = {2, 4, 7, 6, 0};
        int[] expected = {1, 2, 3, 4, 5, 7, 6, 8, 0, 1};
        int[] result = matrix.merge2array(aaa, bbb);
        assertThat(result, is(expected));
    }
}

