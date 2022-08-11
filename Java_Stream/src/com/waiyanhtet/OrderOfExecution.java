package com.waiyanhtet;

import java.util.stream.Stream;

public class OrderOfExecution {

	public static void main(String[] args) {
		Stream<String> subStringStream1 = Stream.of("abcdg", "deweg", "jkeli")
				.map(s -> {
					System.out.println("map method was called");
					return s.substring(2, 4);
				})
				.map(s -> {
					System.out.println("map upper case method was called");
					return s.toUpperCase();
				})
				.sorted((String s1, String s2) -> {
					System.out.println("sorted method was called");
					return s1.compareTo(s2);
				})
				.skip(1);
		subStringStream1.forEach(s -> System.out.println(s));
		
		System.out.println("\nOrder : ");
		Stream<String> subStringStream2 = Stream.of("abcdg", "deweg", "jkeli")
				.map(s -> {
					System.out.println("map method was called");
					return s.substring(2, 4);
				})
				.map(s -> {
					System.out.println("map upper case method was called");
					return s.toUpperCase();
				})
				.skip(1)
				.sorted((String s1, String s2) -> {
					System.out.println("sorted method was called");
					return s1.compareTo(s2);
				});
		subStringStream2.forEach(s -> System.out.println(s));
		
		System.out.println("\nOrder : ");
		Stream<String> subStringStream3 = Stream.of("abcdg", "deweg", "jkeli")
				.skip(1)
				.map(s -> {
					System.out.println("map method was called");
					return s.substring(2, 4);
				})
				.map(s -> {
					System.out.println("map upper case method was called");
					return s.toUpperCase();
				})
				.sorted((String s1, String s2) -> {
					System.out.println("sorted method was called");
					return s1.compareTo(s2);
				});
		subStringStream3.forEach(s -> System.out.println(s));
		
	}
}
