package java8ex3;

import java.util.Comparator;

public class Task_7 {
	/*
	 * 7. Write a method that generates a Comparator<String> that can be normal
	 * or reversed, case-sensitive or case-insensitive, space-sensitive or
	 * space-insensitive, or any combination thereof. Your method should return
	 * a lambda expression.
	 */

	public Comparator<String> generateComparator() {
		return ((String str1, String str2) -> {return str1.compareTo(str2);});
	}
	
	public static void main(String[] args) {

	}
}
