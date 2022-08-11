package com.waiyanhtet;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamCreation {

	public static void main(String[] args) throws IOException {
		
		Collection<String> collection = Arrays.asList("a","b");
		Stream<String> streamCollection = collection.stream();
		
		String[] str = new String[] {"f","g","h"};
		Stream<String> streamArrayFull = Arrays.stream(str);
		Stream<String> streamArrayPart = Arrays.stream(str, 1, 3);
		
		Stream<String> streamEmpty = Stream.empty();
		
		Stream<String> streamOf = Stream.of("c","d","e");

		Stream<String> streamBuilder = Stream.<String>builder().add("i").add("j").add("k").build();
	
		Stream<String> streamGenerate = Stream.generate(() -> "element" ).limit(10);
		
		Stream<Integer> streamIterate = Stream.iterate(40, n -> n + 2).limit(20);

		IntStream intStream = IntStream.range(1, 3);
		IntStream intStreamWithCharIntStream = "abc".chars();
		
		LongStream longStream = LongStream.rangeClosed(1, 3);
	
		Random random = new Random();
		DoubleStream randIntStream = random.doubles(9,1,9);
		
		randIntStream.forEach(i -> System.out.println(i));
		
		Path path = Paths.get("C://test//test.pdf");
		Stream<String> pathStream = Files.lines(path);
		Stream<String> pathStreamWithCharset = Files.lines(path, Charset.forName("UTF-8"));
		
	}
}
