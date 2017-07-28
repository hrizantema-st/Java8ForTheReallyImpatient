package java8ex2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1_2 {
	/*
	 * 2. Verify that asking for the first five long words does not call the
	 * filter method once the fifth long word has been found. Simply log each
	 * method call.
	 */
	public static void main(String[] args) {
		String contents = null;
		try {
			contents = new String(Files.readAllBytes(Paths.get("resources\\alice.txt")), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

		Stream<String> firstFiveLongWords = words.stream().filter(word -> word.length() < 12)
				.peek(e -> System.out.println("Fetching " + e)).limit(5);
		List<String> res = firstFiveLongWords.collect(Collectors.toList());
		System.out.println(res.size());
	}
}
