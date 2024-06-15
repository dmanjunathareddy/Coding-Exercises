package com.softgroup.dsa.interview.leetcode;

class Reader4 {
	// Dummy implementation for read4 API
	// This should be provided by the problem's context
	int read4(char[] buf) {
		// Dummy implementation for illustration purposes
		// Replace with actual implementation or assume this method is provided
		return 0;
	}
}

public class ReadNCharacters extends Reader4 {
	private char[] buffer = new char[4]; // Buffer to store characters from read4
	private int bufferPointer = 0; // Pointer to track current position in the buffer
	private int bufferCount = 0; // Number of characters currently in the buffer

	/**
	 * Reads characters into buf[] up to n characters.
	 * 
	 * @param buf Destination buffer
	 * @param n   Maximum number of characters to read
	 * @return The number of characters read
	 */
	public int read(char[] buf, int n) {
		int totalCharsRead = 0;

		while (totalCharsRead < n) {
			// If buffer is empty, refill it using read4
			if (bufferPointer == 0) {
				bufferCount = read4(buffer);
			}

			// If no more characters to read, break the loop
			if (bufferCount == 0) {
				break;
			}

			// Copy characters from buffer to buf
			while (totalCharsRead < n && bufferPointer < bufferCount) {
				buf[totalCharsRead++] = buffer[bufferPointer++];
			}

			// If bufferPointer has reached bufferCount, reset bufferPointer
			if (bufferPointer == bufferCount) {
				bufferPointer = 0;
			}
		}

		return totalCharsRead;
	}

	public static void main(String[] args) {
		ReadNCharacters readNCharacters = new ReadNCharacters();

		// Example test case
		char[] buf = new char[10];
		int charsRead = readNCharacters.read(buf, 10);
		System.out.println("Number of characters read: " + charsRead);
		System.out.println("Characters read: " + new String(buf, 0, charsRead));
	}
}
