package ca.tutic.aoc.year19.days;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day03Test {
    Day03 day = new Day03("day03test.txt");

    @Test
    public void dayTest() {
        assertEquals(day.getPart1(), "159");
        assertEquals(day.getPart2(), "610");
    }
}
