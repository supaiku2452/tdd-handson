package com.supaiku2452.tdd.handson.fizzbuzz;

public class FizzBuzz {
    public String exec(int num) {
        if ( num == 2 ) {
            return "2";
        } else if ( num % 3 == 0 ) {
            return "Fizz";
        } else if ( num % 5 == 0 ) {
            return "Buzz";
        }

        return String.valueOf(num);
    }
}
