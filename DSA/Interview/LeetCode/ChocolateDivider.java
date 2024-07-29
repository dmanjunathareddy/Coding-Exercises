package com.softgroup.dsa.interview.leetcode;
public class ChocolateDivider {
    public static void main(String[] args) {
        int totalPieces = 12;  // Total pieces of chocolate
        int numberOfPeople = 3; // Number of people to divide among

        int piecesPerPerson = totalPieces / numberOfPeople;
        int leftoverPieces = totalPieces % numberOfPeople;

        System.out.println("Each person gets " + piecesPerPerson + " pieces.");
        System.out.println("Leftover pieces: " + leftoverPieces);
    }
}
