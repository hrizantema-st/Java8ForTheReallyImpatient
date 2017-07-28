package java8ex2;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Task1_10 {
	/*
	 * 10. Write a call to reduce that can be used to compute the average of a
	 * Stream<Double>. Why can’t you simply compute the sum and divide by
	 * count()?
	 */
	
	public static void main(String[] args) {
		DoubleStream stream = DoubleStream.of(new Double(1), new Double(2), new Double(4));
		/*stream.reduce(0,(x , y) -> {return x + y/)*/
		
	/*	
		IntSummaryStatistics summary = words.collect(
				Collectors.summarizingInt(String::length));
				double averageWordLength = summary.getAverage();
				double maxWordLength = summary.getMax();*/
	}
}
