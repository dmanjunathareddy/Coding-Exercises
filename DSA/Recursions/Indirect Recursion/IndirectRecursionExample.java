package com.softgroup.dsa.recursion;

public class IndirectRecursionExample {
    public static void function1(int n) {
        if (n > 0) {
            System.out.println("Function 1: " + n);
            function2(n - 1); // Indirect recursion: calls function2
        }
    }

    public static void function2(int n) {
        if (n > 0) {
            System.out.println("Function 2: " + n);
            function1(n / 2); // Indirect recursion: calls function1
        }
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println("Starting indirect recursion with num = " + num);
        function1(num);
    }
}
