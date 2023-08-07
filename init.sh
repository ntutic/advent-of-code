#!/bin/bash

year="$1"
day="$2"
zpDay=$(printf "%02d" $day)

# Check if year and day are provided
if [ -z "$year" ] || [ -z "$day" ]; then
  echo "Usage: ./create_aoc_day.sh <year> <day>"
  exit 1
fi

# Create the directories and files
mkdir -p src/main/java/ca/tutic/aoc/year${year}/days
mkdir -p src/test/java/ca/tutic/aoc/year${year}/days

main_file="src/main/java/ca/tutic/aoc/year${year}/days/Day${zpDay}.java"
test_file="src/test/java/ca/tutic/aoc/year${year}/days/Day${zpDay}Test.java"
input_file="src/main/resources/year${year}/day${zpDay}.txt"

if [ -f "$main_file" ] || [ -f "$test_file" ] || [ -f "$input_file" ]; then 
    exit 1 
fi

echo "package ca.tutic.aoc.year${year}.days;

import ca.tutic.aoc.year${year}.Day20${year};


public class Day${zpDay} extends Day20${year}{
    private String inputFile;

    public Day${zpDay}() {
        super(${day});
        inputFile = \"day${zpDay}.txt\";
    }

    public String getPart1() {
        return \"INCOMPLETE\";
    }  

    public String getPart2() {
        return \"INCOMPLETE\";
    }
}
" > $main_file

echo "package ca.tutic.aoc.year${year}.days;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day${zpDay}Test {
    Day${zpDay} day = new Day${zpDay}();

    @Test
    public void dayTest() {
        //assertEquals(day.getPart1(), \"\");
        //assertEquals(day.getPart2(), \"\");
    }
}" > $test_file

echo "" > $input_file