package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        //String[] input = {"a", "a", "b", "c", "d", "c", "d", "e", "a"};
        String[] input = {"a", "a", "b", "c"};
        String[] expected = {"a", "b", "c"};
        //String[] expected = {"a", "b", "c", "d", "e"};
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] result = duplicate.remove(input);
        assertThat(result, is(expected));
    }
}
