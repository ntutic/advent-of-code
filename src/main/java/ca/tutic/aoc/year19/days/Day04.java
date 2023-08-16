package ca.tutic.aoc.year19.days;
import ca.tutic.aoc.year19.Day2019;

import java.util.stream.IntStream;
import java.util.function.Predicate;


public class Day04 extends Day2019{
    private String inputFile;

    public Day04() {
        super(4);
        inputFile = "day04.txt";
    }

    public Object getPart1() {
        String input = getResourceString(inputFile);
        int from = Integer.parseInt(input.split("-")[0]);
        int to = Integer.parseInt(input.split("-")[1]);

        return IntStream.range(from, to + 1)
                        .reduce(0, (t, x) -> t + validate(x, (y) -> y >= 2));
    }  

    public Object getPart2() {
        String input = getResourceString(inputFile);
        int from = Integer.parseInt(input.split("-")[0]);
        int to = Integer.parseInt(input.split("-")[1]);

        return IntStream.range(from, to + 1)
                        .reduce(0, (t, x) -> t + validate(x, (y) -> y == 2));
    }

    public int validate(int code, Predicate<Integer> consecutiveTest) {
        int[] digits = toDigits(code);
        int found = 0;
        for (int i = 0; i < digits.length; i++) {
            if (i != digits.length - 1 && digits[i] > digits[i + 1]) {
                return 0;
            } else if (
                found == 0 &&
                (i == 0 || digits[i] != digits[i-1]) && 
                consecutiveTest.test(consecutive(digits, i))
            ) {
                found = 1;
            }
        }
        return found;
    }

    public static int[] toDigits(int code) {
        String str = Integer.toString(code);
        int[] digits = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            digits[i] = Character.getNumericValue(str.charAt(i));
        }
        return digits;
    }

    public int consecutive(int[] digits, int n) {
        int count = 1;
        for (int i = n + 1; i < digits.length; i++) {
            if (digits[n] == digits[i]) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}

