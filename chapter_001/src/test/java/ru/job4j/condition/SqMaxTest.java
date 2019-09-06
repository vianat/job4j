package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest {

    @Test
    public void test() {
        int first = 5;
        int second = 2;
        int third = 8;
        int forth = 1;
        int expected = 8;
        int s = SqMax.max(first, second, third, forth);
        assertThat(s, is(expected));
    }
    @Test
    public void test1() {
        int first = 1;
        int second = 2;
        int third = 3;
        int forth = 4;
        int expected = 4;
        int s = SqMax.max(first, second, third, forth);
        assertThat(s, is(expected));
    }
    @Test
    public void test2() {
        int first = 4;
        int second = 3;
        int third = 2;
        int forth = 1;
        int expected = 4;
        int s = SqMax.max(first, second, third, forth);
        assertThat(s, is(expected));
    }
    @Test
    public void test3() {
        int first = 1;
        int second = 3;
        int third = 1;
        int forth = 5;
        int expected = 5;
        int s = SqMax.max(first, second, third, forth);
        assertThat(s, is(expected));
    }
}
