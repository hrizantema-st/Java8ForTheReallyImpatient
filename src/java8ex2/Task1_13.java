package java8ex2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Task1_13 {
	/*
	 * 13. Repeat the preceding exercise, but filter out the short strings and
	 * use the collect method with Collectors.groupingBy and
	 * Collectors.counting.
	 */

	public static void main(String[] args) {
		String contents = null;
		try {
			contents = new String(Files.readAllBytes(Paths.get("resources\\alice.txt")), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		Map<Integer, List<String>> res = words.parallelStream().filter(word -> word.length() < 12).collect(Collectors.groupingBy(String::length));
		for (Entry<Integer, List<String>> entry : res.entrySet()) {
		    Integer key = entry.getKey();
		    List<String> value = entry.getValue();
		    System.out.println("Number of symbols: " + key);
		    System.out.println("Words: " + value.size());
		    System.out.println("-----------");
		}
	
	}
	

}
