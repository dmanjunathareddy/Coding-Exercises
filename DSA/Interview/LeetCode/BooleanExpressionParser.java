package com.softgroup.dsa.interview.leetcode.top150;
import java.util.*;

public class BooleanExpressionParser {
    // Token types
    enum TokenType { LITERAL, OPERATOR, PARENTHESIS }

    // Token class
    static class Token {
        TokenType type;
        String value;

        Token(TokenType type, String value) {
            this.type = type;
            this.value = value;
        }
    }

    // Tokenizer function
    private static List<Token> tokenize(String expression) {
        List<Token> tokens = new ArrayList<>();
        int n = expression.length();
        for (int i = 0; i < n; i++) {
            char c = expression.charAt(i);
            if (c == ' ') continue;
            if (c == 't' || c == 'f') {
                String literal = c == 't' ? "true" : "false";
                tokens.add(new Token(TokenType.LITERAL, literal));
            } else if (c == '!' || c == '&' || c == '|') {
                tokens.add(new Token(TokenType.OPERATOR, String.valueOf(c)));
            } else if (c == '(' || c == ')') {
                tokens.add(new Token(TokenType.PARENTHESIS, String.valueOf(c)));
            }
        }
        return tokens;
    }

    // Parser and evaluator functions
    private static int index;

    private static boolean parseExpression(List<Token> tokens) {
        return parseOr(tokens);
    }

    private static boolean parseOr(List<Token> tokens) {
        boolean result = parseAnd(tokens);
        while (index < tokens.size() && tokens.get(index).type == TokenType.OPERATOR && tokens.get(index).value.equals("|")) {
            index++;
            result = result || parseAnd(tokens);
        }
        return result;
    }

    private static boolean parseAnd(List<Token> tokens) {
        boolean result = parseNot(tokens);
        while (index < tokens.size() && tokens.get(index).type == TokenType.OPERATOR && tokens.get(index).value.equals("&")) {
            index++;
            result = result && parseNot(tokens);
        }
        return result;
    }

    private static boolean parseNot(List<Token> tokens) {
        if (index < tokens.size() && tokens.get(index).type == TokenType.OPERATOR && tokens.get(index).value.equals("!")) {
            index++;
            return !parsePrimary(tokens);
        }
        return parsePrimary(tokens);
    }

    private static boolean parsePrimary(List<Token> tokens) {
        if (index < tokens.size() && tokens.get(index).type == TokenType.PARENTHESIS && tokens.get(index).value.equals("(")) {
            index++;
            boolean result = parseExpression(tokens);
            if (index < tokens.size() && tokens.get(index).type == TokenType.PARENTHESIS && tokens.get(index).value.equals(")")) {
                index++;
            } else {
                throw new IllegalArgumentException("Unmatched parentheses");
            }
            return result;
        }
        if (index < tokens.size() && tokens.get(index).type == TokenType.LITERAL) {
            String literal = tokens.get(index).value;
            index++;
            return literal.equals("true");
        }
        throw new IllegalArgumentException("Unexpected token: " + tokens.get(index).value);
    }

    // Main function to parse and evaluate the expression
    public static boolean parseBooleanExpression(String expression) {
        List<Token> tokens = tokenize(expression);
        index = 0;
        return parseExpression(tokens);
    }

    // Testing the implementation
    public static void main(String[] args) {
        String expression1 = "true | false & !false";
        String expression2 = "(true & false) | !false";
        String expression3 = "true & (false | true)";
        String expression4 = "!((true & false) | (!false & true))";

        System.out.println("Expression: " + expression1 + " = " + parseBooleanExpression(expression1)); // Output: true
        System.out.println("Expression: " + expression2 + " = " + parseBooleanExpression(expression2)); // Output: true
        System.out.println("Expression: " + expression3 + " = " + parseBooleanExpression(expression3)); // Output: true
        System.out.println("Expression: " + expression4 + " = " + parseBooleanExpression(expression4)); // Output: false
    }
}
