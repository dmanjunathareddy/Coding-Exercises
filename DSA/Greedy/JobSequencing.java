package com.softgroup.dsa.greedy;

import java.util.*;

class Job {
	char id;
	int deadline, profit;

	Job(char id, int deadline, int profit) {
		this.id = id;
		this.deadline = deadline;
		this.profit = profit;
	}
}

public class JobSequencing {

	public static int[] scheduleJobs(List<Job> jobs, int numJobs) {
		// Sort jobs based on profit (highest to lowest)
		jobs.sort((a, b) -> b.profit - a.profit);

		// Array to keep track of scheduled jobs
		boolean[] schedule = new boolean[numJobs];
		char[] jobIds = new char[numJobs];
		Arrays.fill(schedule, false);

		int totalProfit = 0;

		// Iterate through each job in sorted order
		for (Job job : jobs) {
			// Find a free time slot for this job (latest possible)
			for (int j = Math.min(numJobs - 1, job.deadline - 1); j >= 0; j--) {
				if (!schedule[j]) {
					// Schedule the job
					schedule[j] = true;
					jobIds[j] = job.id;
					totalProfit += job.profit;
					break;
				}
			}
		}

		// Print scheduled jobs and total profit
		System.out.print("Scheduled jobs: ");
		for (char jobId : jobIds) {
			if (jobId != '\0') {
				System.out.print(jobId + " ");
			}
		}
		System.out.println("\nTotal profit: " + totalProfit);

		return new int[] { totalProfit };
	}

	public static void main(String[] args) {
		List<Job> jobs = new ArrayList<>();
		jobs.add(new Job('A', 2, 100));
		jobs.add(new Job('B', 1, 19));
		jobs.add(new Job('C', 2, 27));
		jobs.add(new Job('D', 1, 25));
		jobs.add(new Job('E', 3, 15));

		// Number of time slots (this is equivalent to the number of jobs, but in
		// real-life problems,
		// this would be determined by the overall time constraints available)
		int numJobs = 3;

		scheduleJobs(jobs, numJobs);
	}
}
