package com.waiyanhtet;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUsage {

	public static void main(String[] args) {
		//Stream<String> stream = Stream.of("a", "b", "bc", "c").filter(e -> e.contains("b"));

		// can cause illegalStateException coz of stream can do one time
		// Optional<String> anyElement = stream.findAny();
		// Optional<String> firstElement = stream.findFirst();

		List<String> list = Stream.of("a", "b", "bc", "c")
				.filter(e -> e.contains("b"))
				.collect(Collectors.toList());
		
		Optional<String> anyElement = list.stream().findAny();
		Optional<String> firstElement = list.stream().findFirst();
		System.out.println(anyElement + " " + firstElement);

		Stream<String> subStringStream = Stream.of("abcdg", "deweg", "jkeli")
				.filter(s -> s.contains("e"))
				.map(s -> s.substring(2, 4))
				.sorted();

		subStringStream.forEach(s -> System.out.println(s));

		Long count = Stream.of("abcde", "deweg", "jkli")
				.skip(1)
				.map(s -> s.substring(2, 4))
				.sorted()
				.count();

		System.out.println(count);
	}
}
