package com.softgroup.dsa.interview.leetcode;
import java.util.*;

public class BasicCalculatorIV {
    public static void main(String[] args) {
        String expression = "e + 8 - a + 5";
        List<String> evalvars = Arrays.asList("e");
        List<Integer> evalints = Arrays.asList(1);
        
        List<String> result = basicCalculatorIV(expression, evalvars, evalints);
        System.out.println(result);
    }

    public static List<String> basicCalculatorIV(String expression, List<String> evalvars, List<Integer> evalints) {
        Map<String, Integer> evalMap = new HashMap<>();
        for (int i = 0; i < evalvars.size(); i++) {
            evalMap.put(evalvars.get(i), evalints.get(i));
        }

        return parse(expression).evaluate(evalMap).toList();
    }

    private static Node parse(String expression) {
        List<Node> nodes = new ArrayList<>();
        int i = 0, n = expression.length();
        while (i < n) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                int j = i;
                while (j < n && Character.isDigit(expression.charAt(j))) {
                    j++;
                }
                nodes.add(new Node(Integer.parseInt(expression.substring(i, j))));
                i = j;
            } else if (Character.isLetter(c)) {
                int j = i;
                while (j < n && Character.isLetter(expression.charAt(j))) {
                    j++;
                }
                nodes.add(new Node(expression.substring(i, j)));
                i = j;
            } else if (c == '+' || c == '-') {
                nodes.add(new Node(c));
                i++;
            } else if (c == ' ') {
                i++;
            }
        }

        Deque<Node> stack = new ArrayDeque<>();
        for (Node node : nodes) {
            if (!stack.isEmpty() && (node.operator == '+' || node.operator == '-')) {
                Node left = stack.pollLast();
                node.left = left;
                stack.add(node);
            } else {
                stack.add(node);
            }
        }

        Node root = null;
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            if (root == null) {
                root = node;
            } else {
                node.right = root;
                root = node;
            }
        }

        return root;
    }

    static class Node {
        String var;
        int coef;
        char operator;
        Node left, right;

        Node(String var) {
            this.var = var;
        }

        Node(int coef) {
            this.coef = coef;
        }

        Node(char operator) {
            this.operator = operator;
        }

        Node evaluate(Map<String, Integer> evalMap) {
            if (operator == 0) {
                if (var != null) {
                    if (evalMap.containsKey(var)) {
                        return new Node(evalMap.get(var));
                    }
                    return this;
                }
                return this;
            }

            Node leftEval = left.evaluate(evalMap);
            Node rightEval = right.evaluate(evalMap);

            if (operator == '+') {
                return leftEval.add(rightEval);
            } else {
                return leftEval.subtract(rightEval);
            }
        }

        Node add(Node other) {
            if (var != null && var.equals(other.var)) {
                return new Node(var).setCoef(coef + other.coef);
            }
            return new Node('+').setLeft(this).setRight(other);
        }

        Node subtract(Node other) {
            if (var != null && var.equals(other.var)) {
                return new Node(var).setCoef(coef - other.coef);
            }
            return new Node('-').setLeft(this).setRight(other);
        }

        Node setCoef(int coef) {
            this.coef = coef;
            return this;
        }

        Node setLeft(Node left) {
            this.left = left;
            return this;
        }

        Node setRight(Node right) {
            this.right = right;
            return this;
        }

        List<String> toList() {
            if (operator == 0) {
                if (var != null) {
                    return Collections.singletonList(var + (coef == 1 ? "" : coef));
                }
                return Collections.singletonList(String.valueOf(coef));
            }

            List<String> result = new ArrayList<>();
            if (left != null) {
                result.addAll(left.toList());
            }
            if (right != null) {
                if (operator == '-') {
                    result.add("-");
                }
                result.addAll(right.toList());
            }

            return result;
        }
    }
}
