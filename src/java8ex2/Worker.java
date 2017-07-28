package java8ex2;

import java.util.List;

public class Worker extends Thread {
	private int start;
	private int end;
	private long count;
	private List<String> words;

	public Worker(final int start, final int end, final List<String> words) {
		this.words = words;
		this.start = start;
		this.end = Math.min(end, words.size());
		count = 0;
	}

	public void run() {
		this.count = currentCount(start, end, words);
	}

	public long getCount() {
		return this.count;
	}

	public static int currentCount(final int start, final int end, final List<String> words) {
		int currentCount = 0;
		for (int i = start; i < end; i++) {
			if (words.get(i).length() > 12)
				currentCount++;
		}
		return currentCount;
	}

	public static int serialCount(List<String> words) {
		return currentCount(0, words.size(), words);
	}

	public static int parallelCount(List<String> words) {
		int numberOfCores = Runtime.getRuntime().availableProcessors();
		int sizeOfChunk = (int) Math.ceil(words.size() * 1.0 / numberOfCores);

		Worker[] counts = new Worker[numberOfCores];

		for (int i = 0; i < numberOfCores; i++) {
			counts[i] = new Worker(i * sizeOfChunk, (i + 1) * sizeOfChunk, words);
			counts[i].start();
		}

		try {
			for (Worker c : counts) {
				c.join();
			}
		} catch (InterruptedException e) {
		}

		int totalCount = 0;

		for (Worker c : counts) {
			totalCount += c.getCount();
		}

		return totalCount;
	}

}
