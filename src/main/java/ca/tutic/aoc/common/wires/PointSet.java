package ca.tutic.aoc.common.wires;

import java.util.Set;
import java.util.HashSet;

public class PointSet {
    private Set<Point> points = new HashSet<>();
    private Point cursor = new Point(0, 0);
    
    public PointSet() {}

    public Set<Point> getPoints() {
        return points;
    }

    public Point getPoint(Point other) {
        for (Point point: points) {
            if (point.equals(other)) {
                return point;
            }
        }
        return null;
    }

    public boolean read(int x, int y) {
        return points.contains(new Point(x, y));
    }

    public void write(int x, int y) {
        write(x, y, 0);
    }

    public void write(int x, int y, int steps) {
        points.add(new Point(x, y, steps));
    }

    public void trace(String input) {
        int dX = 0;
        int dY = 0;
        switch(input.substring(0, 1)) {
            case "U" -> dY = -1;
            case "D" -> dY = 1;
            case "L" -> dX = -1;
            case "R" -> dX = 1;
        }
        dX *= Integer.parseInt(input.substring(1));
        dY *= Integer.parseInt(input.substring(1));    
        int x, y;
        for (int iX = 0; iX <= Math.abs(dX); iX++) {
            x = (dX >= 0 ? iX : iX * -1);
            for (int iY = 0; iY <= Math.abs(dY); iY++) {
                y = (dY >= 0 ? iY : iY * -1);
                if (x != 0 || y != 0) {
                    write(
                        cursor.getX() + x, 
                        cursor.getY() + y,
                        cursor.getSteps() + 1
                    );
                    cursor.incrementSteps();
                }   
            }
        }
        cursor = new Point(
            cursor.getX() + dX, 
            cursor.getY() + dY, 
            cursor.getSteps()
        );
    }

    public void instructions(String inputs) {
        instructions(inputs.split(","));
    }


    public void instructions(String[] inputs) {
        for (String input: inputs) {
            trace(input);
        }
    }
    
    public void intersect(PointSet other) {
        points.retainAll(other.getPoints());
        for (Point point: points) {
            point.setSteps(
                point.getSteps() + other.getPoint(point).getSteps()
            );
        }
    }
    
    public int findClosest(int targetX, int targetY) {
        int min = Integer.MAX_VALUE;
        int dist;
        for (Point point: points) {
            dist = point.taxiDistance(targetX, targetY);
            if (dist < min) {
                min = dist;
            }
        }
        return min;
    }

    public int findShortest() {
        int min = Integer.MAX_VALUE;
        int dist;
        for (Point point: points) {
            dist = point.getSteps();
            if (dist < min) {
                min = dist;
            }
        }
        return min;
    }    
}
