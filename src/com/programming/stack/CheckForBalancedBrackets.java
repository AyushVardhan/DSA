package com.programming.stack;

import java.util.HashMap;
import java.util.Stack;

public class CheckForBalancedBrackets {
    private static HashMap<Character, Character> mappings = new HashMap<>();

    public static void main(String[] args) {

        mappings.put(']', '[');
        mappings.put(')', '(');
        mappings.put('}', '{');

        System.out.println(isBalanced("[])"));
    }

    private static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!mappings.containsKey(ch)) {
                stack.push(ch);
            } else {
                Character topChar = stack.isEmpty() ? '#' : stack.pop();
                if (topChar != mappings.get(ch))
                    return false;
            }
        }

        return stack.isEmpty();
    }
}
