package com.supaiku2452.tdd.handson.fizzbuzz;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {

    @Test
    public void test1toOne() {
        String actual = new FizzBuzz().exec(1);
        assertEquals("1", actual);
    }

    @Test
    public void test2toTwo() {
        String actual = new FizzBuzz().exec(2);
        assertEquals("2", actual);
    }
}
