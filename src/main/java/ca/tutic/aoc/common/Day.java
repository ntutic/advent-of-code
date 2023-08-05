package ca.tutic.aoc.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public abstract class Day {
    public int year;
    public int day;
    public abstract String getPart1();
    public abstract String getPart2();

    public Day(int year, int day) {
        this.year = year;
        this.day = day;
    }

    public void printDay() {
        System.out.printf("Day %d%n", day);
        System.out.printf("Part 1: %s%n", getPart1());
        System.out.printf("Part 2: %s%n%n", getPart2());
    }

    public BufferedReader getResourceReader(String path) {
        return new BufferedReader(
            new InputStreamReader(
                Day.class.getResourceAsStream(path),
                StandardCharsets.UTF_8
            )
        );
    }

    public String getResourceString(BufferedReader buffer) {
        StringBuilder builder = new StringBuilder();
        try {
            while (buffer.ready()) {
                builder.append(String.format("%s%n", buffer.readLine()));
            }
        } catch (IOException e) {
            return "";
        }
        return builder.toString().strip();
    }
}
