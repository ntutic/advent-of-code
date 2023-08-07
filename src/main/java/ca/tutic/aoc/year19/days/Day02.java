package ca.tutic.aoc.year19.days;

import ca.tutic.aoc.common.Intcode;
import ca.tutic.aoc.year19.Day2019;

public class Day02 extends Day2019{

    public Day02() {
        super(2);
    }

    public String getPart1() {
        Intcode code = new Intcode(getResourceString("day02.txt"));
        code.initialize(12, 2);
        return String.valueOf(code.run());
    }  

    public String getPart2() {
        Intcode code;
        for (int noun = 0; noun < 100; noun++) {
            for (int verb = 0; verb < 100; verb++) {
                code = new Intcode(getResourceString("day02.txt"));
                code.initialize(noun, verb);
                if (code.run() == 19690720) {
                    return String.valueOf(100 * noun + verb);
                }            
            }
        }
        return "INCOMPLETE";
    }
}

