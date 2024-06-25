package com.softgroup.dsa.interview;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface IBankAccountOperation {
	void deposit(double d);

	void withdraw(double d);

	double processOperation(String message);
}

class BankOperations implements IBankAccountOperation {
	private double balance;

	public BankOperations() {
		this.balance = 0;
	}

	@Override
	public void deposit(double amount) {
		this.balance += amount;
	}

	@Override
	public void withdraw(double amount) {
		if (this.balance >= amount) {
			this.balance -= amount;
		} else {
			System.out.println("Insufficeent balance. Withdrawal canceled.");
		}
	}

	@Override
	public double processOperation(String message) {
		Map<String, Runnable> actions = new HashMap<>();
		actions.put("see", () -> System.out.println("Balance: " + this.balance));
		actions.put("show", actions.get("see"));
		actions.put("deposit", () -> {
			String[] parts = message.split("\\s+");
			if (parts.length < 2) {
				return;
			}
			try {
				double amount = Double.parseDouble(parts[1]);
				deposit(amount);
				System.out.println((int) this.balance);
			} catch (NumberFormatException e) {
			}
		});
		actions.put("put", actions.get("deposit"));
		actions.put("invest", actions.get("deposit"));
		actions.put("transfer", actions.get("deposit"));
		actions.put("withdraw", () -> {
			String[] parts = message.split("\\s+");
			if (parts.length < 2) {
				System.out.println("Invalid withdrawal request.");
				return;
			}
			try {
				double amount = Double.parseDouble(parts[1]);
				withdraw(amount);
				System.out.println((int) this.balance);
			} catch (NumberFormatException e) {
			}
		});
		actions.put("pull", actions.get("withdraw"));

		String[] words = message.toLowerCase().split("\\s+");
		for (String word : words) {
			Runnable action = actions.get(word);
			if (action != null) {
				action.run();
				break; // Exit after the first action is executed
			}
		}

		return this.balance;
	}

}

//Create the BankOperations class by implementing the IBankAccountOperation interface
public class BankOperationsMain {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		int n = Integer.parseInt(br.readLine());
		List<String> inputs = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			inputs.add(br.readLine());
		}
		BankOperations opt = new BankOperations();
		for (String item : inputs) {
			pw.println((int) opt.processOperation(item));
		}
		pw.flush();
		pw.close();
	}
}