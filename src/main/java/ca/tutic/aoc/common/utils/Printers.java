package ca.tutic.aoc.common.utils;

public class Printers {
    public static void printArray(int[] array, int index) {
        StringBuilder buildArray = new StringBuilder();
        StringBuilder buildIndex = new StringBuilder();
        StringBuilder buildIndexes = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            int padArray = String.valueOf(i).length() - String.valueOf(array[i]).length() + 1;   
            int padIndexes = String.valueOf(array[i]).length() - String.valueOf(i).length() + 1; 
            padArray = (padArray <= 0 ? 1 : padArray);    
            padIndexes = (padIndexes <= 0 ? 1 : padIndexes);
            buildArray.append(
                String.format("%-" + padArray + "s", array[i])
            );
            buildIndexes.append(
                String.format("%-" + padIndexes + "s", i)
            );

            if (i == index){
                int padIndex = buildIndexes.toString().stripTrailing().length();
                padIndex = (padIndex <= 0 ? 1 : padIndex);
                buildIndex.append(
                    String.format("%" + padIndex + "s", index)
                );
            }
            

            if (i < array.length - 1) {
                buildArray.append(", ");
                buildIndexes.append(", ");
            }
        }
        System.out.printf("%n  %s%n", buildIndex.toString());
        System.out.printf("  %s%n", buildIndexes.toString());
        System.out.printf("[ %s ]%n", buildArray.toString());
    }
}
