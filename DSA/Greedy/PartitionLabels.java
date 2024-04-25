package com.softgroup.dsa.greedy;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
	public static List<Integer> partitionLabels(String S) {
		int[] lastIndexes = new int[26];
		for (int i = 0; i < S.length(); i++) {
			lastIndexes[S.charAt(i) - 'a'] = i;
		}

		List<Integer> partitions = new ArrayList<>();
		int start = 0, end = 0;

		for (int i = 0; i < S.length(); i++) {
			end = Math.max(end, lastIndexes[S.charAt(i) - 'a']);
			if (i == end) {
				partitions.add(end - start + 1);
				start = end + 1;
			}
		}

		return partitions;
	}

	public static void main(String[] args) {
		String S = "ababcbacadefegdehijhklij";
		List<Integer> result = partitionLabels(S);
		System.out.println("Sizes of the partitioned labels: " + result);
	}
}
