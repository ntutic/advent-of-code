package ca.tutic.aoc.year19.days;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day05Test {
    Day05 day = new Day05();

    @Test
    public void dayTest() {
        assertEquals(day.getPart1().toString(), "14522484");
        assertEquals(day.getPart2().toString(), "4655956");
    }
}
