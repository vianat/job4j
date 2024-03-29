package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                            .append("  + ")
                            .append(System.lineSeparator())
                            .append(" +++")
                            .append(System.lineSeparator())
                            .append("+++++")
                            .toString()
                )
        );
    }
}
