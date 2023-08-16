package ca.tutic.aoc.common.wires;

import java.util.Objects;

public class Point {
    private int x;
    private int y;
    private int steps;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.steps = 0;
    }

    public Point(int x, int y, int steps) {
        this.x = x;
        this.y = y;
        this.steps = steps;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public void incrementSteps() {
        this.steps++;
    }

    public int taxiDistance(int x, int y) {
        return taxiDistance(new Point(x, y));
    }

    public int taxiDistance(Point other) {
        return Math.abs(other.getX() - x) + Math.abs(other.getY() - y);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (getClass() != other.getClass()) return false;
        Point otherPoint = (Point) other;
        return x == otherPoint.getX() && y == otherPoint.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }   
}
