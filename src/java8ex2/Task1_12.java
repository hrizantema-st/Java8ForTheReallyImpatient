package java8ex2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Task1_12 {
	/*
	 * 12. Count all short words in a parallel Stream<String>, as described in
	 * Section 2.13, “Parallel Streams,” on page 40, by updating an array of
	 * AtomicInteger. Use the atomic getAndIncrement method to safely increment
	 * each counter.
	 */

	public static void main(String[] args) {
		String contents = null;
		try {
			contents = new String(Files.readAllBytes(Paths.get("resources\\alice.txt")), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

		AtomicInteger[] shortWords = new AtomicInteger[12];
		// Arrays.fill(shortWords, new AtomicInteger(0));
		for (int i = 0; i < 12; i++) {
			shortWords[i] = new AtomicInteger(0);
		}
		
		words.parallelStream().forEach(word -> {
			if (word.length() < 12) {
				shortWords[word.length()].getAndIncrement();
			}
		});
		
		System.out.println(Arrays.toString(shortWords));
	}
}
