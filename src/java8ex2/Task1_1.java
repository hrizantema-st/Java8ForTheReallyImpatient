package java8ex2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Task1_1 {
	/*
	 * 1. Write a parallel version of the for loop in Section 2.1, “From
	 * Iteration to Stream Operations,” on page 22. Obtain the number of
	 * processors. Make that many separate threads, each working on a segment of
	 * the list, and total up the results as they come in. (You don’t want the
	 * threads to update a single counter. Why?)
	 */

	public static void main(String[] args) {
		String contents = null;
		try {
			contents = new String(Files.readAllBytes(Paths.get("resources\\alice.txt")), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		
		long start = System.currentTimeMillis();

	    Worker.serialCount(words);

	    System.out.println("Time of serial execution: " + (System.currentTimeMillis() - start)); 

	    start = System.currentTimeMillis();

	    Worker.parallelCount(words);

	    System.out.println("Parallel: " + (System.currentTimeMillis() - start)); 

	}

}
