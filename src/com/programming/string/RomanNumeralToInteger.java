package com.programming.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RomanNumeralToInteger {
    public static void main(String[] args) {
        System.out.println(solve("XVI"));
    }

    private static int solve(String numeral) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int intVal = 0, i = 0;
        char[] chars = numeral.toCharArray();

        Stack<Integer> stack = new Stack<>();

        while (i < chars.length) {
            if (stack.isEmpty() || romanMap.get(chars[i]) < romanMap.get(chars[i-1])) {
                stack.push(romanMap.get(chars[i++]));

            } else if (romanMap.get(chars[i]).equals(stack.peek())){

                int val = stack.peek();
                int sum = stack.pop();
                while (i < chars.length && romanMap.get(chars[i]) == val){
                    sum += romanMap.get(chars[i++]);
                }
                stack.push(sum);

            } else if (romanMap.get(chars[i]) > romanMap.get(chars[i-1])) {
                int val = stack.pop();
                stack.push(val * -1);
                stack.push(romanMap.get(chars[i++]));
            }
        }

        while (!stack.isEmpty()) {
            intVal += stack.pop();
        }

        return intVal;
    }
}
