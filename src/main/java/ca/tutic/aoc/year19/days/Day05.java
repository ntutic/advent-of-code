package ca.tutic.aoc.year19.days;

import ca.tutic.aoc.common.intcode.Processor;
import ca.tutic.aoc.year19.Day2019;


public class Day05 extends Day2019{
    private String inputFile;

    public Day05() {
        super(5);
        inputFile = "day05.txt";
    }

    public Object getPart1() {
        Processor code = new Processor(getResourceString(inputFile));
        return code.run(1);
    }  

    public Object getPart2() {
        Processor code = new Processor(getResourceString(inputFile));
        return code.run(5);
    }  
}

