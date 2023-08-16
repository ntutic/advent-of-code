package ca.tutic.aoc.year19.days;

import ca.tutic.aoc.common.intcode.Processor;
import ca.tutic.aoc.year19.Day2019;

public class Day02 extends Day2019{

    public Day02() {
        super(2);
    }

    public Object getPart1() {
        Processor code = new Processor(getResourceString("day02.txt"));
        code.initialize(12, 2);
        return code.run();
    }  

    public Object getPart2() {
        Processor code;
        for (int noun = 0; noun < 100; noun++) {
            for (int verb = 0; verb < 100; verb++) {
                code = new Processor(getResourceString("day02.txt"));
                code.initialize(noun, verb);
                if (code.run() == 19690720) {
                    return 100 * noun + verb;
                }            
            }
        }
        return "INCOMPLETE";
    }
}

