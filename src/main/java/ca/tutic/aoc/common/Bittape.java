package ca.tutic.aoc.common;

import java.util.BitSet;

public class Bittape {
    private BitSet[] grid;
    private int side;
    private int cursor;

    public Bittape() { 
        this(1000); 
    }

    public Bittape(int side) {
        this.side = side;
        grid = new BitSet[side];
        for (int i = 0; i < side; i++) {
            grid[i] = new BitSet(side);
        }
        cursor = getPosition(0, 0);
    }

    public Bittape(BitSet tape) {
        this.tape = (BitSet) tape.clone();
        side = (int) Math.sqrt((double) this.tape.size());
    }

    public BitSet getTape() {
        return tape;
    }

    public int getX(int position) {
        return position % side - side / 2;
    }

    public int getY(int position) {
        return position / side - side / 2;
    }

    public int getPosition(int x, int y) {
        int posX = (side / 2) + x;
        int posY = side * (y + side / 2);
        return posX + posY;
    }

    public boolean read(int position) {
        return tape.get(position);
    }

    public boolean read(int x, int y) {
        return read(getPosition(x, y));
    }

    public void write(int position) {
        tape.set(position);
    }

    public void write(int x, int y) {
        write(getPosition(x, y));
    }

    public Bitmap intersect(Bitmap other) {
        BitSet tape = (BitSet) getTape().clone();
        tape.and(other.getTape());
        return new Bitmap(tape);
    }
    
    public int findClosest(int targetX, int targetY) {
        int min = 0;
        int dist;
        for (int i = tape.nextSetBit(0); i != -1; i = tape.nextSetBit(i + 1)) {
            dist = distance(targetX, targetY, getX(i), getY(i));
            if (dist < min || min == 0) {
                min = dist;
            }
        }
        return min;
    }

    public int distance(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
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
        
        int x = getX(cursor);
        int y = getY(cursor);

        if (dX != 0) {
            tape.set(
                getPosition(x + (dX < 0 ? dX : 0), y),
                getPosition(x + (dX > 0 ? dX : 0), y)
            );
        } else if (dY != 0) {
            int direction = (dY >= 0 ? 1 : -1);
            for (int i = 1; i <= Math.abs(dY); i++) {
                tape.set(
                    getPosition(x, y + i * direction)
                );
            }
        }
        cursor = getPosition(x + dX, y + dY);
    }
}
