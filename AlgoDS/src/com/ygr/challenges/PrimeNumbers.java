package com.ygr.challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find the maximum digit occurred in a range of prime numbers
 * Eg: Range ( 21 -40) –>Prime numbers are 23,29,31,37,39
 * ( 2 occurs 2 times, 3 occurs 4 times, 1 and 7 occur 1 time and 9 occurs 2 times ->Answer is 3)
 */
public class PrimeNumbers {

    public static void main(String[] args) {
        int start = 21;
        start = start % 2 == 0 ? start + 1 : start;
        int end = 40;
        end = end % 2 == 0 ? end - 1 : end;

        List<Integer> primeList = new ArrayList<>();
        Map<Integer, Integer> primeFrequency = new HashMap<>();
        for (int i = start; i <= end; i = i + 2) {
            boolean found = true;
            for (int j = 2; (j * j) <= i; j++) {
                if (i % j == 0) {
                    found = false;
                    break;
                }
            }
            if (found) {
                primeList.add(i);
            }
        }
        if (!primeList.isEmpty()) {
            primeList.forEach((val) -> {
                int mod = val % 10;
                if (primeFrequency.containsKey(mod)) {
                    primeFrequency.put(mod, primeFrequency.get(mod) + 1);
                } else {
                    primeFrequency.put(mod, 1);
                }
            });
        }
        System.out.println(primeFrequency);
    }
}
