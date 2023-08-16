package ca.tutic.aoc;

import java.lang.reflect.InvocationTargetException;

import ca.tutic.aoc.common.Day;

/**
 * Hello world!
 *
 */
public class Run 
{
    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException
    {
        int yearStart, yearEnd, dayStart, dayEnd;
        if (args.length == 2) {
            yearStart = Integer.parseInt(args[0]);
            yearEnd = Integer.parseInt(args[0]);
            dayStart = Integer.parseInt(args[1]);
            dayEnd = Integer.parseInt(args[1]);
        } else { 
            yearStart = 15;
            yearEnd = 23;
            dayStart = 1;
            dayEnd = 25;
        }
        for (int year = yearStart; year <= yearEnd; year++) {
            for (int day = dayStart; day <= dayEnd; day++) {
                try {
                    Day problem = (Day) Class
                        .forName(String.format("ca.tutic.aoc.year%d.days.Day%02d", year, day))
                        .getDeclaredConstructor()
                        .newInstance();
                    if (day == 1) {
                        System.out.printf("Year 20%d %n%n", year);
                    }
                    problem.printDay();
                } catch (ClassNotFoundException e) {}
            }
        } 
    }
}
