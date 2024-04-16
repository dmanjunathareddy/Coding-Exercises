package com.softgroup.dsa.queue;

public class CelebrityProblem {

	// Function to find the celebrity in a party
	public static int findCelebrity(int[][] knows) {
		int n = knows.length;

		// Step 1: Identify a potential celebrity
		int potentialCelebrity = 0;
		for (int i = 1; i < n; i++) {
			// If potentialCelebrity knows i, then i may be the celebrity
			if (knows[potentialCelebrity][i] == 1) {
				potentialCelebrity = i;
			}
		}

		// Step 2: Verify the potential celebrity
		for (int i = 0; i < n; i++) {
			// Verify that the potential celebrity knows no one else
			if (knows[potentialCelebrity][i] == 1) {
				return -1; // potential celebrity knows someone else
			}
			// Verify that everyone else knows the potential celebrity
			if (i != potentialCelebrity && knows[i][potentialCelebrity] == 0) {
				return -1; // someone does not know the potential celebrity
			}
		}

		return potentialCelebrity; // Return the index of the celebrity
	}

	// Example usage
	public static void main(String[] args) {
		// Sample knows matrix where person i knows person j if knows[i][j] == 1
		int[][] knows = { { 0, 1, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 0 } };

		// Find the celebrity
		int celebrityIndex = findCelebrity(knows);
		if (celebrityIndex == -1) {
			System.out.println("No celebrity found in the party.");
		} else {
			System.out.println("Celebrity found at index: " + celebrityIndex);
		}
	}
}
