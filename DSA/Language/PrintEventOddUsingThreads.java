package com.softgroup.dsa.interview;

public class PrintEventOddUsingThreads {
	private static int n = 10;
	private static boolean isEventurn = true;

	private static Object lock = new Object();

	public static void main(String[] args) {

		Thread evenThread = new Thread(new EvenPrinter());
		Thread oddThread = new Thread(new OddPrinter());

		evenThread.start();
		oddThread.start();
	}

	static class OddPrinter implements Runnable {

		@Override
		public void run() {
			for (int i = 1; i <= n; i += 2) {
				synchronized (lock) {
					while (!isEventurn) {
						try {
							lock.wait();
						} catch (Exception e) {
							e.printStackTrace();

						}
					}
					System.out.println(Thread.currentThread().getName() + ": " + i);
					isEventurn = true;
					lock.notify();
				}
			}

		}
	}

	static class EvenPrinter implements Runnable {

		@Override
		public void run() {
			for (int i = 2; i <= n; i += 2) {
				synchronized (lock) {
					while (isEventurn) {
						try {
							lock.wait();
						} catch (Exception e) {
							e.printStackTrace();

						}
					}
					System.out.println(Thread.currentThread().getName() + ": " + i);
					isEventurn = false;
					lock.notify();
				}
			}

		}
	}
}
