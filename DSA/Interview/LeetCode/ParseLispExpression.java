package com.softgroup.dsa.interview.leetcode;
import java.util.*;

public class ParseLispExpression {
    public int evaluate(String expression) {
        return eval(expression, new HashMap<>());
    }

    private int eval(String expression, Map<String, Integer> parentScope) {
        if (Character.isDigit(expression.charAt(0)) || expression.charAt(0) == '-') {
            return Integer.parseInt(expression);
        } else if (expression.charAt(0) != '(') {
            return parentScope.get(expression);
        }

        Map<String, Integer> scope = new HashMap<>(parentScope);
        List<String> tokens = parse(expression.substring(1, expression.length() - 1));
        if (tokens.get(0).equals("let")) {
            for (int i = 1; i < tokens.size() - 1; i += 2) {
                scope.put(tokens.get(i), eval(tokens.get(i + 1), scope));
            }
            return eval(tokens.get(tokens.size() - 1), scope);
        } else if (tokens.get(0).equals("add")) {
            return eval(tokens.get(1), scope) + eval(tokens.get(2), scope);
        } else if (tokens.get(0).equals("mult")) {
            return eval(tokens.get(1), scope) * eval(tokens.get(2), scope);
        }
        throw new IllegalArgumentException("Invalid expression: " + expression);
    }

    private List<String> parse(String expression) {
        List<String> tokens = new ArrayList<>();
        int depth = 0;
        StringBuilder token = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (c == '(') {
                depth++;
            } else if (c == ')') {
                depth--;
            }
            if (c == ' ' && depth == 0) {
                tokens.add(token.toString());
                token.setLength(0);
            } else {
                token.append(c);
            }
        }
        tokens.add(token.toString());
        return tokens;
    }

    public static void main(String[] args) {
        ParseLispExpression parser = new ParseLispExpression();
        System.out.println(parser.evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))")); // 14
        System.out.println(parser.evaluate("(let x 3 x 2 x)")); // 2
        System.out.println(parser.evaluate("(add 1 2)")); // 3
    }
}
