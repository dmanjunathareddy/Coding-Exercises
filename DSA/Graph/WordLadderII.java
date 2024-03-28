package com.softgroup.dsa.graph;

import java.util.*;

public class WordLadderII {
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> result = new ArrayList<>();
		Set<String> wordSet = new HashSet<>(wordList);
		if (!wordSet.contains(endWord))
			return result;

		Map<String, List<String>> graph = new HashMap<>();
		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		visited.add(beginWord);

		boolean found = false;
		while (!queue.isEmpty()) {
			int size = queue.size();
			Set<String> tempVisited = new HashSet<>();
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
						if (wordSet.contains(newWord)) {
							if (!visited.contains(newWord)) {
								tempVisited.add(newWord);
								queue.offer(newWord);
							}
							if (!graph.containsKey(newWord)) {
								graph.put(newWord, new ArrayList<>());
							}
							graph.get(newWord).add(currentWord);
							if (newWord.equals(endWord)) {
								found = true;
							}
						}
					}
					wordArray[j] = originalChar;
				}
			}
			visited.addAll(tempVisited);
			if (found)
				break;
		}
		if (!found)
			return result;

		List<String> path = new ArrayList<>();
		path.add(beginWord);
		dfs(result, path, graph, endWord, beginWord);

		return result;
	}

	private void dfs(List<List<String>> result, List<String> path, Map<String, List<String>> graph, String endWord,
			String currentWord) {
		if (currentWord.equals(endWord)) {
			result.add(new ArrayList<>(path));
			return;
		}
		if (!graph.containsKey(currentWord))
			return;

		for (String nextWord : graph.get(currentWord)) {
			path.add(nextWord);
			dfs(result, path, graph, endWord, nextWord);
			path.remove(path.size() - 1);
		}
	}

	public static void main(String[] args) {
		WordLadderII wordLadderII = new WordLadderII();
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
		List<List<String>> ladders = wordLadderII.findLadders(beginWord, endWord, wordList);
		System.out.println("Word ladders from " + beginWord + " to " + endWord + ":");
		for (List<String> ladder : ladders) {
			System.out.println(ladder);
		}
	}
}
