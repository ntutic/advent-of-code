package ca.tutic.aoc.year19.days;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day02Test {
    Day02 day = new Day02();

    @Test
    public void dayTest() {
        assertEquals(day.getPart1(), "3101844");
        assertEquals(day.getPart2(), "8478");
    }
}
