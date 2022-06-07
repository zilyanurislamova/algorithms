package com.leetcode.fizz.buzz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(fizzBuzz(5).toArray()));
    }
    public static List<String> fizzBuzz(int n) {
        String fizz = "Fizz";
        String buzz = "Buzz";
        List<String> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                answer.add(fizz + buzz);
            else if (i % 3 == 0)
                answer.add(fizz);
            else if (i % 5 == 0)
                answer.add(buzz);
            else
                answer.add(String.valueOf(i));
        }
        return answer;
    }
}
