package java8ex2;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task1_6 {
/*6. The characterStream method in Section 2.3, “The filter, map, and flatMap Methods,”
	on page 25, was a bit clumsy, first filling an array list and then turning it
	into a stream. Write a stream-based one-liner instead. One approach is to
	make a stream of integers from 0 to s.length() - 1 and map that with the
	s::charAt method reference. */
	
	public static void main(String[] args) {
		 Stream<Character> ch = characterStream("boat");
		ch.forEach(System.out::println);
	}
	
	public static Stream<Character> characterStream(String s) {
		 return IntStream.range(0, s.length()).mapToObj(s::charAt);
	}
}
