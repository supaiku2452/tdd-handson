package com.supaiku2452.tdd.handson.fizzbuzz;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {

    @Test
    public void test1toOne() {

        FizzBuzzData[] fizzBuzzDatas = {
                new FizzBuzzData(1, "1"),
                new FizzBuzzData(2, "2"),
                new FizzBuzzData(3, "Fizz"),
                new FizzBuzzData(4, "4"),
                new FizzBuzzData(5, "Buzz")
        };

        for ( FizzBuzzData fizzBuzzData : fizzBuzzDatas ) {
            assertEquals(new FizzBuzz().exec(fizzBuzzData.input), fizzBuzzData.actual);
        }
    }

    private class FizzBuzzData {
        private final int input;
        private final String actual;

        public FizzBuzzData(int input, String actual) {
            this.input = input;
            this.actual = actual;
        }
    }
}
