package com.softgroup.dsa.interview;
import java.util.Arrays;
import java.util.Comparator;

public class MaximizeTips {
    static class Order {
        int a; // Tip by Rahul
        int b; // Tip by Ankit
        int diff; // Difference a - b

        Order(int a, int b) {
            this.a = a;
            this.b = b;
            this.diff = a - b;
        }
    }

    public static int maximizeTips(int[] a, int[] b, int n, int x, int y) {
        Order[] orders = new Order[n];
        for (int i = 0; i < n; i++) {
            orders[i] = new Order(a[i], b[i]);
        }

        // Sort orders based on the absolute difference in descending order
        Arrays.sort(orders, (o1, o2) -> Integer.compare(Math.abs(o2.diff), Math.abs(o1.diff)));

        int totalTips = 0;
        int rahulOrders = 0;
        int ankitOrders = 0;

        for (Order order : orders) {
            if (order.diff > 0) {
                // Prefer Rahul if possible
                if (rahulOrders < x) {
                    totalTips += order.a;
                    rahulOrders++;
                } else {
                    totalTips += order.b;
                    ankitOrders++;
                }
            } else {
                // Prefer Ankit if possible
                if (ankitOrders < y) {
                    totalTips += order.b;
                    ankitOrders++;
                } else {
                    totalTips += order.a;
                    rahulOrders++;
                }
            }
        }

        return totalTips;
    }

    public static void main(String[] args) {
        int[] a = {8, 7, 5, 9};
        int[] b = {6, 4, 8, 7};
        int n = 4;
        int x = 2;
        int y = 2;

        int maxTips = maximizeTips(a, b, n, x, y);
        System.out.println("Maximum possible tips: " + maxTips);
    }
}
