package com.waiyanhtet;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamReduction {

	public static void main(String[] args) {
		int reducedParams1 = Stream.of(1, 2, 3)
				.reduce(10, (a, b) -> a + b);
		System.out.println(reducedParams1);

		System.out.println("\nParallel Stream : ");
		int reducedParams2 = Arrays.asList(1, 2, 3)
				.parallelStream()
				.reduce(10, (a, b) -> a + b, (a, b) -> {
					System.out.println("combiner was called");
					return a + b;
				});
		System.out.println(reducedParams2);

	}
}
