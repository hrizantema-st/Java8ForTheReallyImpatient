package java8ex3;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task_20 {
	/*
	 * 20. Supply a static method <T, U> List<U> map(List<T>, Function<T, U>).
	 */
	public static <T, U> List<U> map(List<T> list, Function<T, U> function) {
		return list.stream().map(function).collect(Collectors.toList());
	}
}
