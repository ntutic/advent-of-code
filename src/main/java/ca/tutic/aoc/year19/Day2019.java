package ca.tutic.aoc.year19;

import ca.tutic.aoc.common.Day;

import java.io.BufferedReader;


public abstract class Day2019 extends Day {
    public abstract Object getPart1();
    public abstract Object getPart2();

    public Day2019(int day) {
        super(2019, day);
    }

    @Override
    public BufferedReader getResourceReader(String fileName) {
        return super.getResourceReader("/year19/" + fileName);
    }
    
    public String getResourceString(String fileName) {
        return super.getResourceString(getResourceReader(fileName));
    }
}
