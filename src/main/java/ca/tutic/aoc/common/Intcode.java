package ca.tutic.aoc.common;

import ca.tutic.aoc.common.Opcodes;
import ca.tutic.aoc.common.Opcodes.Opcode.*;


import java.lang.UnsupportedOperationException;
import java.util.Arrays;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;
import org.d2ab.function.IntBiPredicate;

public class Intcode {
    int[] program;
    int input;
    int diagnostic = 0;

    public Intcode(String program) {
        this(program, 0);
    }

    public Intcode(String program, int input) {
        this.program = Arrays.stream(program.split(","))
                             .mapToInt(Integer::parseInt)
                             .toArray();
        this.input = input;
    }
    
    public void initialize(int noun, int verb) {
        program[1] = noun;
        program[2] = verb;
    }

    public int run() throws UnsupportedOperationException{
        int i = 0;
        int[] modes;
        Opcodes.Opcode opcode;
        while (i < program.length) {
            opcode = Opcodes.getOpcode(program[i] % 100);
            modes = getModes(program[i]);
            switch (opcode) {
                case ADDITION:
                    binaryOperation(modes, i + 1, (a, b) -> a + b);
                    i += 4;
                    break;
                case MULTIPLICATION:
                    binaryOperation(modes, i + 1, (a, b) -> a * b);
                    i += 4;     
                    break;      
                case INPUT:
                    setValue(i + 1, input);
                    i += 2;
                    break;       
                case OUTPUT:
                    diagnostic = getValue(modes, i + 1);
                    i += 2;
                    break; 
                case GOTO_IF_TRUE:
                    i = gotoIf(modes, i, (x) -> x != 0);
                    break;
                case GOTO_IF_FALSE:
                    i = gotoIf(modes, i, (x) -> x == 0);
                    break;
                case IS_LESS_THAN:
                    compare(modes, i, (x, y) -> x < y);
                    i += 4;
                    break;
                case ARE_EQUAL:
                    compare(modes, i, (x, y) -> x == y);
                    i += 4;
                    break;                
                case TERMINATE: 
                    return (diagnostic == 0 ? program[0] : diagnostic);
            }
        }
        throw new UnsupportedOperationException("Invalid program: no termination opcode found.");
    }

    public int[] getModes(int instruction) {
        int modes[] = new int[3];
        instruction /= 100;for (int i = 0; i < 3; i++) {
            modes[i] = instruction % 10;
            instruction /= 10;
        }
        return modes;
    }

    public void setValue(int index, int value) {
        program[program[index]] = value;
    }

    public int getValue(int[] modes, int index) {
        return getValues(modes, index)[0];
    }

    public int[] getValues(int[] modes, int... indexes) {
        int[] values = new int[indexes.length];
        for (int i = 0; i < values.length; i++) {
            if (modes[i] == 0) {
                values[i] = program[program[indexes[i]]];
            } else if (modes[i] == 1) {
                values[i] = program[indexes[i]];
            }
        }
        return values;
    }

    public void binaryOperation(int[] modes, int index, IntBinaryOperator operator) {
        int[] values = getValues(modes, index, index + 1);
        setValue(index + 2, operator.applyAsInt(values[0], values[1]));
    }

    public int gotoIf(int[] modes, int index, IntPredicate predicate) {
        int[] values = getValues(modes, index + 1, index + 2);
        if (predicate.test(values[0])) {
            return values[1];
        } else {
            return index + 3;
        }
    }

    public void compare(int[] modes, int index, IntBiPredicate predicate) {
        int[] values = getValues(modes, index + 1, index + 2);
        if (predicate.test(values[0], values[1])) {
            setValue(index + 3, 1);
        } else {
            setValue(index + 3, 0);
        }
    }
}
