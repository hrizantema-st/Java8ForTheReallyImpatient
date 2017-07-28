package java8ex2;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task1_4 {

	public static void main(String[] args) {
		/*Stream<String> words = Stream.of(new String[] { "lala", "lalala" });
		IntStream intstream = Arrays.stream(new int[] { 1, 2, 3, 4 }, 0, 3);
		intstream.forEach(System.out::println);
		
		Stream<Object> result = words.flatMap(w -> characterStream(w));
		Stream<Character> combined = Stream.concat(
				characterStream("Hello"), characterStream("World"));
		combined.forEach(System.out::println);*/
		
		
		//1.4 Suppose you have an array int[] values = { 1, 4, 9, 16 }. What is
		//Stream.of(values)? How do you get a stream of int instead?
		int[] values = { 1, 4, 9, 16 };
		Stream.of(values).forEach(System.out::println); //stream with one element - array of ints
		IntStream stream = IntStream.of(1,4,9,16); //this is how we get a stream of ints
	}
	
}
