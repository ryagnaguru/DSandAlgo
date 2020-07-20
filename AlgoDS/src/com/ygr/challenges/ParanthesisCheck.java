package com.ygr.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

/**
 * Given an expression string exp. Examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
 * For example, the program should print 'balanced' for exp = “[()]{}{[()()]()}” and 'not balanced' for exp = “[(])”
 * <p>
 * Input:
 * The first line of input contains an integer T denoting the number of test cases.  Each test case consists of a string of expression, in a separate line.
 * <p>
 * Output:
 * Print 'balanced' without quotes if the pair of parenthesis is balanced else print 'not balanced' in a separate line.
 * <p>
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ |s| ≤ 105
 * <p>
 * Example:
 * Input:
 * 3
 * {([])}
 * ()
 * ([]
 * <p>
 * Output:
 * balanced
 * balanced
 * not balanced
 */
public class ParanthesisCheck {

    public static void main(String[] args) {
        Stack<Character> paranthesis = new Stack<>();
        String input = "{([{()}]]";

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '{' ||
                    input.charAt(i) == '(' ||
                    input.charAt(i) == '[') {
                paranthesis.push(input.charAt(i));
            } else {
                if (paranthesis.isEmpty()) {
                    System.out.println("Unbalanaced");
                    return;
                }

                Character popValue = paranthesis.pop();
                if (input.charAt(i) == '}' && popValue != '{') {
                    System.out.println("Unbalanaced");
                    return;
                }
                if (input.charAt(i) == ')' && popValue != '(') {
                    System.out.println("Unbalanaced");
                    return;
                }
                if (input.charAt(i) == ']' && popValue != '[') {
                    System.out.println("Unbalanaced");
                    return;
                }
            }
        }

        if (paranthesis.isEmpty()) {
            System.out.println("Balanced");
            return;
        }
        System.out.println("Unbalanced");

    }
}
