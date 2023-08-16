package ca.tutic.aoc.year19.days;

import ca.tutic.aoc.common.wires.PointSet;
import ca.tutic.aoc.year19.Day2019;

public class Day03 extends Day2019{
    private String inputFile;

    public Day03() {
        super(3);
        inputFile = "day03.txt";
    }

    public Day03(String file) {
        super(3);
        inputFile = file;
    }

    public Object getPart1() {
        String resource = getResourceString(inputFile);
        String[] inputs = resource.split(System.lineSeparator());
        PointSet points1 = new PointSet();
        PointSet points2 = new PointSet();
        points1.instructions(inputs[0]);
        points2.instructions(inputs[1]);
        points1.intersect(points2);
        return points1.findClosest(0, 0);
    }  

    public Object getPart2() {
        String resource = getResourceString(inputFile);
        String[] inputs = resource.split(System.lineSeparator());
        PointSet points1 = new PointSet();
        PointSet points2 = new PointSet();
        points1.instructions(inputs[0]);
        points2.instructions(inputs[1]);
        points1.intersect(points2);
        return points1.findShortest();
    }  
}

