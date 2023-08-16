package ca.tutic.aoc.year19.days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ca.tutic.aoc.common.intcode.Processor;
import ca.tutic.aoc.year19.Day2019;


public class Day07 extends Day2019{
    private String inputFile;

    public Day07() {
        super(7);
        inputFile = "day07test.txt";
    }

    public Object getPart1() {
        Processor code = new Processor(getResourceString(inputFile), true);
        int result;
        int max = 0;
        int[] phases;
        code.run(new int[]{1, 0, 4, 3, 2});
        List<int[]> permutations = getUniquePermutations(new int[]{0, 1, 2, 3, 4});
        return max;
    }  

    public Object getPart2() {
        return "INCOMPLETE";
    }

    public static List<int[]> getUniquePermutations(int[] perm) {
        List<int[]> perms = new ArrayList<>();
        perms.add(Arrays.copyOf(perm, perm.length));

        int i = 0;
        for (int j = 1; j < perm.length; j++) {
            swap(perm, i, j);
            perms.add(Arrays.copyOf(perm, perm.length));
            swap(perm, i, j);

        }
        
        return perms;
    }

    public static int[] swap(int[] arr, int i, int j) {
        int holder = arr[i];
        arr[i] = arr[j];
        arr[j] = holder;
        return arr;
    }
}



