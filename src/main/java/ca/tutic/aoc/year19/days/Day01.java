package ca.tutic.aoc.year19.days;

import ca.tutic.aoc.year19.Day2019;


public class Day01 extends Day2019{

    public Day01() {
        super(1);
    }

    public Object getPart1() {
        return super.getResourceReader("day01.txt")
                    .lines()
                    .mapToInt(Integer::parseInt)
                    .reduce(0, (total, x) -> total + fuel(x));
    }  

    public Object getPart2() {
        return super.getResourceReader("day01.txt")
                    .lines()
                    .mapToInt(Integer::parseInt)
                    .reduce(0, (total, x) -> total + recursiveFuel(x));
    }

    public int fuel(int mass) {
        int fuel = mass / 3 - 2;
        return fuel < 0 ? 0 : fuel;
    }

    public int recursiveFuel(int mass) {
        return recursiveFuel(0, mass);
    }

    public int recursiveFuel(int cumulative, int mass) {
        int incremental = fuel(mass);
        cumulative += incremental;

        if (incremental > 0) {
            return recursiveFuel(cumulative, incremental);
        } 

        return cumulative;
    }
}
