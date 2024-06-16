package com.softgroup.dsa.interview.leetcode;
import java.util.Scanner;
import java.util.Random;

class DungeonGame {
    private static final int DUNGEON_SIZE = 5;
    private static final char EMPTY = '.';
    private static final char PLAYER = 'P';
    private static final char MONSTER = 'M';
    private static final char TREASURE = 'T';
    
    private char[][] dungeon;
    private int playerX;
    private int playerY;
    private boolean gameRunning;

    public DungeonGame() {
        dungeon = new char[DUNGEON_SIZE][DUNGEON_SIZE];
        for (int i = 0; i < DUNGEON_SIZE; i++) {
            for (int j = 0; j < DUNGEON_SIZE; j++) {
                dungeon[i][j] = EMPTY;
            }
        }
        playerX = 0;
        playerY = 0;
        dungeon[playerX][playerY] = PLAYER;
        placeMonstersAndTreasures();
        gameRunning = true;
    }

    private void placeMonstersAndTreasures() {
        Random rand = new Random();
        // Place monsters
        for (int i = 0; i < 3; i++) {
            int x, y;
            do {
                x = rand.nextInt(DUNGEON_SIZE);
                y = rand.nextInt(DUNGEON_SIZE);
            } while (dungeon[x][y] != EMPTY);
            dungeon[x][y] = MONSTER;
        }
        // Place treasures
        for (int i = 0; i < 2; i++) {
            int x, y;
            do {
                x = rand.nextInt(DUNGEON_SIZE);
                y = rand.nextInt(DUNGEON_SIZE);
            } while (dungeon[x][y] != EMPTY);
            dungeon[x][y] = TREASURE;
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (gameRunning) {
            printDungeon();
            System.out.print("Enter move (w/a/s/d): ");
            char move = scanner.nextLine().charAt(0);
            movePlayer(move);
        }
        scanner.close();
    }

    private void printDungeon() {
        for (int i = 0; i < DUNGEON_SIZE; i++) {
            for (int j = 0; j < DUNGEON_SIZE; j++) {
                System.out.print(dungeon[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void movePlayer(char move) {
        int newX = playerX;
        int newY = playerY;

        switch (move) {
            case 'w': newX--; break;
            case 's': newX++; break;
            case 'a': newY--; break;
            case 'd': newY++; break;
            default: System.out.println("Invalid move."); return;
        }

        if (newX < 0 || newY < 0 || newX >= DUNGEON_SIZE || newY >= DUNGEON_SIZE) {
            System.out.println("You hit a wall!");
            return;
        }

        if (dungeon[newX][newY] == MONSTER) {
            System.out.println("You encountered a monster! Game Over.");
            gameRunning = false;
        } else if (dungeon[newX][newY] == TREASURE) {
            System.out.println("You found a treasure! You Win!");
            gameRunning = false;
        } else {
            dungeon[playerX][playerY] = EMPTY;
            playerX = newX;
            playerY = newY;
            dungeon[playerX][playerY] = PLAYER;
        }
    }

    public static void main(String[] args) {
        DungeonGame game = new DungeonGame();
        game.start();
    }
}
