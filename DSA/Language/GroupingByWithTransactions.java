package com.softgroup.language.java;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Transaction {
	private String transactionId;
	private String customerId;
	private double amount;

	public Transaction(String transactionId, String customerId, double amount) {
		this.transactionId = transactionId;
		this.customerId = customerId;
		this.amount = amount;
	}

	public String getCustomerId() {
		return customerId;
	}

	public double getAmount() {
		return amount;
	}
}

public class GroupingByWithTransactions {
	public static void main(String[] args) {
		List<Transaction> transactions = Arrays.asList(new Transaction("T1", "C1", 100.0),
				new Transaction("T2", "C2", 150.0), new Transaction("T3", "C1", 200.0),
				new Transaction("T4", "C3", 300.0));

		// Group transactions by customer ID
		Map<String, List<Transaction>> transactionsByCustomer = transactions.stream()
				.collect(Collectors.groupingBy(Transaction::getCustomerId));

		// Filter groups where the total amount exceeds 250
		transactionsByCustomer = transactionsByCustomer.entrySet().stream()
				.filter(entry -> entry.getValue().stream().mapToDouble(Transaction::getAmount).sum() <= 250)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		// Print the groups
		transactionsByCustomer.forEach((customerId, group) -> {
			System.out.println("Customer ID: " + customerId);
			group.forEach(transaction -> System.out.println(
					"  Transaction ID: " + transaction.getCustomerId() + ", Amount: " + transaction.getAmount()));
		});
	}
}
