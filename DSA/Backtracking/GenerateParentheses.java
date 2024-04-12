package com.softgroup.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> results = new ArrayList<>();
		backtrack(results, "", n, n);
		return results;
	}

	private void backtrack(List<String> results, String current, int open, int close) {
		if (open == 0 && close == 0) {
			results.add(current);
			return;
		}

		if (open > 0) {
			backtrack(results, current + "(", open - 1, close);
		}

		if (close > open) {
			backtrack(results, current + ")", open, close - 1);
		}
	}

	public static void main(String[] args) {
		GenerateParentheses generateParentheses = new GenerateParentheses();
		int n = 3;
		List<String> results = generateParentheses.generateParenthesis(n);
		for (String str : results) {
			System.out.println(str);
		}
	}
}
