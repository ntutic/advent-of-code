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
        for (int year = 15; year <= 23; year++) {
            for (int day = 1; day <= 25; day++) {
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
