package ca.tutic.aoc.year19.days;

import ca.tutic.aoc.common.universe.Universe;
import ca.tutic.aoc.year19.Day2019;


public class Day06 extends Day2019{
    private String inputFile;
    private Universe universe;

    public Day06() {
        super(6);
        inputFile = "day06.txt";
        universe = new Universe("COM");
        for (String line: getResourceReader(inputFile).lines().toList()) {
            String parent = line.split("\\)")[0];
            String child = line.split("\\)")[1];
            universe.createOrbit(parent, child);
        }
    }

    public Object getPart1() {
        return universe.countOrbits();
    }  

    public Object getPart2() {
        return universe.orbitalTransfer("YOU", "SAN");
    }
}

