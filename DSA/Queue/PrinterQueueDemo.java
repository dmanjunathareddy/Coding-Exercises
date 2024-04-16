package com.softgroup.dsa.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

class PrintJob {
	private String jobId; // Identifier for the print job
	private int priority; // Priority of the print job

	public PrintJob(String jobId, int priority) {
		this.jobId = jobId;
		this.priority = priority;
	}

	public String getJobId() {
		return jobId;
	}

	public int getPriority() {
		return priority;
	}

	@Override
	public String toString() {
		return "PrintJob{" + "jobId='" + jobId + '\'' + ", priority=" + priority + '}';
	}
}

class PrinterQueue {
	private PriorityQueue<PrintJob> queue;

	// Constructor initializes the priority queue with a comparator for job priority
	public PrinterQueue() {
		queue = new PriorityQueue<>(new Comparator<PrintJob>() {
			@Override
			public int compare(PrintJob j1, PrintJob j2) {
				// Compare by priority, higher priority first
				return Integer.compare(j2.getPriority(), j1.getPriority());
			}
		});
	}

	// Enqueue a new print job into the queue
	public void enqueue(PrintJob job) {
		queue.add(job);
		System.out.println("Enqueued: " + job);
	}

	// Dequeue the highest priority print job from the queue
	public PrintJob dequeue() {
		PrintJob job = queue.poll();
		if (job != null) {
			System.out.println("Dequeued: " + job);
		} else {
			System.out.println("No jobs in the queue.");
		}
		return job;
	}

	// Check if the queue is empty
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	// Peek the next job without removing it from the queue
	public PrintJob peek() {
		return queue.peek();
	}
}

public class PrinterQueueDemo {
	public static void main(String[] args) {
		// Create a new printer queue
		PrinterQueue printerQueue = new PrinterQueue();

		// Add print jobs with different priorities
		printerQueue.enqueue(new PrintJob("Job1", 2));
		printerQueue.enqueue(new PrintJob("Job2", 5));
		printerQueue.enqueue(new PrintJob("Job3", 1));
		printerQueue.enqueue(new PrintJob("Job4", 4));
		printerQueue.enqueue(new PrintJob("Job5", 3));

		// Process the jobs according to their priority
		while (!printerQueue.isEmpty()) {
			printerQueue.dequeue();
		}
	}
}
