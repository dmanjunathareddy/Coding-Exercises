package com.softgroup.dsa.array;

public class ReverseInteger {
    public static int reverse(int num) {
        int reversedNum = 0;
        
        while (num != 0) {
            int digit = num % 10;
            reversedNum = reversedNum * 10 + digit;
            num /= 10;
        }
        
        return reversedNum;
    }
    
    public static void main(String[] args) {
        int num = 12345;
        System.out.println("Reverse of " + num + " is " + reverse(num));
    }
}
