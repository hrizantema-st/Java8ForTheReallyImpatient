package java8ex2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Task1_3 {
	/*
	 * 3. Measure the difference when counting long words with a parallelStream
	 * instead of a stream. Call System.currentTimeMillis before and after the
	 * call, and print the difference. Switch to a larger document (such as War
	 * and Peace) if you have a fast computer.
	 */
	public static void main(String[] args) {
		
		
		String contents = null;
		try {
			contents = new String(Files.readAllBytes(Paths.get("resources\\war_and_peace.txt")), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		
		long paralelStartTime = System.currentTimeMillis();
		words.parallelStream().filter(word -> word.length() < 12).count();
		long paralelEndTime = System.currentTimeMillis();
		long timeOfparalelExecution = paralelEndTime - paralelStartTime;
		System.out.println(timeOfparalelExecution);
		
		long serialStartTime = System.currentTimeMillis();
		words.stream().filter(word -> word.length() < 12).count();
		long serialEndTime = System.currentTimeMillis();
		long timeOfserialExecution = serialEndTime - serialStartTime;
		System.out.println(timeOfserialExecution);
		
		System.out.println("Difference: " + (timeOfserialExecution - timeOfparalelExecution));
		
	}
}
