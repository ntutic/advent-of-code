package ca.tutic.aoc.common;

public class Opcodes {
    public enum Opcode {
        ADDITION(1),
        MULTIPLICATION(2),
        INPUT(3),
        OUTPUT(4),
        GOTO_IF_TRUE(5),
        GOTO_IF_FALSE(6),
        IS_LESS_THAN(7),
        ARE_EQUAL(8),
        TERMINATE(99);

        private final int code;

        Opcode(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }

    public static Opcode getOpcode(int code) throws IllegalArgumentException {
        for (Opcode oc: Opcode.values()) {
            if (code == oc.getCode()) {
                return oc;
            }
        }
        throw new IllegalArgumentException("Invalid opcode: " + code);
    }

}
