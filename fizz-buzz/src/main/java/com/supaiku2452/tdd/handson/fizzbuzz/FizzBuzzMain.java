package com.supaiku2452.tdd.handson.fizzbuzz;

import java.util.stream.IntStream;

public class FizzBuzzMain {

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        IntStream.rangeClosed(1, 100).forEach(num -> System.out.println(fizzBuzz.exec(num)));
    }
}
