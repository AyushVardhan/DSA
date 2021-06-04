package com.stack;

import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        System.out.println(infixToPostfix("a+b"));
    }

    private static int getPrecedence(char ch) {
        switch (ch) {
            case '-':
            case '+':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    private static String infixToPostfix(String exp) {
        String result = "";
        Stack<Character> stack = new Stack<>();

        for (char ch : exp.toCharArray()) {
            if (Character.isLetterOrDigit(ch))
                result += ch;
            else if (ch == '(')
                stack.push(ch);
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop();

                stack.pop();
            } else {
                while (!stack.isEmpty() && getPrecedence(ch) <= getPrecedence(stack.peek()))
                    result += stack.pop();

                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') return "Invalid Exp";
            result += stack.pop();
        }
        return result;
    }
}
