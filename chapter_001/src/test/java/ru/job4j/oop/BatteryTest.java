package ru.job4j.oop;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class BatteryTest {
    @Test
    public void firstBat55Second10() {
        Battery first = new Battery(55);
        Battery second = new Battery(10);
        int result = first.exchange(second);
        assertThat(result, is(65));
    }
    @Test
    public void firstBat0Second10() {
        Battery first = new Battery(0);
        Battery second = new Battery(10);
        int result = first.exchange(second);
        assertThat(result, is(10));
    }
    @Test
    public void firstBatMinus10Second10() {
        Battery first = new Battery(-10);
        Battery second = new Battery(10);
        int result = first.exchange(second);
        assertThat(result, is(0));
    }
}

