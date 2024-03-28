package com.softgroup.dsa.graph;

import java.util.*;

public class WordLadder {
	public List<String> ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordSet = new HashSet<>(wordList);
		if (!wordSet.contains(endWord))
			return new ArrayList<>();

		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);

		Set<String> visited = new HashSet<>();
		visited.add(beginWord);

		Map<String, String> parentMap = new HashMap<>();

		boolean found = false;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String currentWord = queue.poll();
				char[] wordArray = currentWord.toCharArray();

				for (int j = 0; j < wordArray.length; j++) {
					char originalChar = wordArray[j];
					for (char c = 'a'; c <= 'z'; c++) {
						if (wordArray[j] == c)
							continue;

						wordArray[j] = c;
						String newWord = String.valueOf(wordArray);

						if (newWord.equals(endWord)) {
							parentMap.put(endWord, currentWord);
							found = true;
							break;
						}

						if (wordSet.contains(newWord) && !visited.contains(newWord)) {
							visited.add(newWord);
							queue.offer(newWord);
							parentMap.put(newWord, currentWord);
						}
					}
					wordArray[j] = originalChar;
				}
				if (found)
					break;
			}
			if (found)
				break;
		}

		List<String> ladder = new ArrayList<>();
		if (found) {
			String currentWord = endWord;
			while (currentWord != null) {
				ladder.add(currentWord);
				currentWord = parentMap.get(currentWord);
			}
			Collections.reverse(ladder);
		}

		return ladder;
	}

	public static void main(String[] args) {
		WordLadder wordLadder = new WordLadder();
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
		List<String> ladder = wordLadder.ladderLength(beginWord, endWord, wordList);
		if (!ladder.isEmpty()) {
			System.out.println("Word ladder from " + beginWord + " to " + endWord + ": " + ladder);
		} else {
			System.out.println("No ladder exists from " + beginWord + " to " + endWord);
		}
	}
}
