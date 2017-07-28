package java8ex2;

import java.util.stream.Stream;

public class Task1_7 {
	//1.7 Your manager asks you to write a method public static <T> boolean
	//isFinite(Stream<T> stream). Why isn’t that such a good idea? Go ahead and
	//write it anyway.
	public static <T> boolean isFinite(Stream<T> stream) {
		return stream.count() <= Long.MAX_VALUE;
	}
	
	public static void main(String[] args) {
		Stream<String> finiteStream = Stream.of("a", "b");
        Stream<Double> infiniteStream = Stream.generate(Math::random);

       System.out.println(isFinite(finiteStream));
	}
}
