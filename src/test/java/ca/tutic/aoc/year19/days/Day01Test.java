package ca.tutic.aoc.year19.days;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day01Test {
    Day01 day = new Day01();

    @Test
    public void dayTest() {
        assertEquals(day.getPart1(), "3339288");
        assertEquals(day.getPart2(), "5006064");
    }
}
