package com.softgroup.dsa.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class SnakeAndLadder {
    private static final int WINNING_POSITION = 100;
    private static final Map<Integer, Integer> snakes = new HashMap<>();
    private static final Map<Integer, Integer> ladders = new HashMap<>();

    static {
        // Snakes
        snakes.put(16, 6);
        snakes.put(47, 26);
        snakes.put(49, 11);
        snakes.put(56, 53);
        snakes.put(62, 19);
        snakes.put(64, 60);
        snakes.put(87, 24);
        snakes.put(93, 73);
        snakes.put(95, 75);
        snakes.put(98, 78);

        // Ladders
        ladders.put(1, 38);
        ladders.put(4, 14);
        ladders.put(9, 31);
        ladders.put(21, 42);
        ladders.put(28, 84);
        ladders.put(36, 44);
        ladders.put(51, 67);
        ladders.put(71, 91);
        ladders.put(80, 100);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Snake and Ladder Game!");

        int player1Position = 0;
        int player2Position = 0;
        boolean player1Turn = true;

        while (true) {
            int currentPlayerPosition = player1Turn ? player1Position : player2Position;
            System.out.println((player1Turn ? "Player 1" : "Player 2") + "'s turn, press enter to roll the dice.");
            scanner.nextLine();

            int diceValue = rollDice();
            System.out.println("You rolled a " + diceValue);

            currentPlayerPosition += diceValue;
            currentPlayerPosition = applySnakesAndLadders(currentPlayerPosition);

            if (currentPlayerPosition > WINNING_POSITION) {
                currentPlayerPosition -= diceValue;
            }

            if (player1Turn) {
                player1Position = currentPlayerPosition;
            } else {
                player2Position = currentPlayerPosition;
            }

            System.out.println((player1Turn ? "Player 1" : "Player 2") + "'s position is " + currentPlayerPosition);

            if (currentPlayerPosition == WINNING_POSITION) {
                System.out.println((player1Turn ? "Player 1" : "Player 2") + " wins!");
                break;
            }

            player1Turn = !player1Turn;
        }
        scanner.close();
    }

    private static int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    private static int applySnakesAndLadders(int position) {
        if (snakes.containsKey(position)) {
            System.out.println("Oh no! You encountered a snake!");
            return snakes.get(position);
        } else if (ladders.containsKey(position)) {
            System.out.println("Hooray! You found a ladder!");
            return ladders.get(position);
        } else {
            return position;
        }
    }
}
