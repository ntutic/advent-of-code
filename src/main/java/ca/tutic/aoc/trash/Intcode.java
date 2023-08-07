package ca.tutic.aoc.trash;

import java.util.ArrayList;
import java.util.Arrays;

public class Intcode {
    ArrayList<Command> program = new ArrayList<Command>();

    public Intcode(String input) {
        int[] codes = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < codes.length / 4; i++) {
            program.add(new Command(Arrays.copyOfRange(codes, i * 4, i * 4 + 4)));
        }
    }

    public int run() {
        int opcode;
        for (Command command: program) {
            opcode = command.getOpcode();
            switch (opcode) {
                case 1: add(command.getInputs(), command.getTarget()); break;
                case 2: multiply(command.getInputs(), command.getTarget()); break;
                case 99: return getPosition(0);
            }
        }
        return getPosition(0);
    }

    public void printProgram() {
        for (Command command: program) {
            command.print();
        }
        System.out.println();
    }

    public int getPosition(int position) {
        return program.get(position / 4).getValue(position % 4);
    }

    public void putPosition(int position, int value) {
        program.get(position / 4).putValue(position % 4, value);
    }

    public void add(int[] inputs, int position) {
        putPosition(position, getPosition(inputs[0]) + getPosition(inputs[1]));
    }

    public void multiply(int[] inputs, int position) {
        putPosition(position, getPosition(inputs[0]) * getPosition(inputs[1]));
    }    

    private class Command {
        private int[] code;

        public Command(int[] code) {
            this.code = code;
        }

        public int getValue(int index) {
            return code[index];
        }

        public void putValue(int index, int value) {
            code[index] = value;
        }

        public int getOpcode() {
            return code[0];
        }

        public int[] getInputs() {
            return Arrays.copyOfRange(code, 1, 3);
        }

        public int getTarget() {
            return code[3];
        }

        public void print() {
            System.out.printf("%d, %d, %d, %d%n", code[0], code[1], code[2], code[3]);
            //System.out.printf("%4s%4s%4s%4s%n", code);
        }
    }

}
