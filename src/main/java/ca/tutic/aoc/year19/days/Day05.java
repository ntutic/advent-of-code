package ca.tutic.aoc.year19.days;

import ca.tutic.aoc.common.Intcode;
import ca.tutic.aoc.year19.Day2019;


public class Day05 extends Day2019{
    private String inputFile;

    public Day05() {
        super(5);
        inputFile = "day05.txt";
    }

    public String getPart1() {
        Intcode code = new Intcode(getResourceString(inputFile), 1);
        return String.valueOf(code.run());
    }  

    public String getPart2() {
        Intcode code = new Intcode(getResourceString(inputFile), 5);
        return String.valueOf(code.run());
    }  
}

