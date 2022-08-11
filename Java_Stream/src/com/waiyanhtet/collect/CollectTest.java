package com.waiyanhtet.collect;

import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectTest {

	public static void main(String[] args) {
		List<Product> products = Product.getProductList();
		
		var list = products.stream()
				.map(Product::getName)
				.collect(Collectors.joining(",","[","]"));
		System.out.println("List : " + list);
		
		//no need map
		//SummingInt
		double summing = products.stream().collect(Collectors.summingInt(Product::getPrice));
		System.out.println("Total : " + summing);

		
		//AveragingInt
		double average = products.stream().collect(Collectors.averagingInt(Product::getPrice));
		System.out.println("Average : " + average);
		
		
		//SummarizingInt
		IntSummaryStatistics data = products.stream()
				.collect(Collectors.summarizingInt(Product::getPrice));
		System.out.println(data);
		
		int max = products.stream()
				.collect(Collectors.summarizingInt(Product::getPrice)).getMax();
		System.out.println("Max : " + max);
		
		int min = products.stream()
				.collect(Collectors.summarizingInt(Product::getPrice)).getMin();
		System.out.println("Min : " + min);
		
		long countFromsummary = products.stream()
				.collect(Collectors.summarizingInt(Product::getPrice)).getCount();
		System.out.println("Count : " + countFromsummary);
		
		double averageFromSummary = products.stream()
				.collect(Collectors.summarizingInt(Product::getPrice)).getAverage();
		System.out.println("Average : " + averageFromSummary);
		
		long totalFromSummary = products.stream()
				.collect(Collectors.summarizingInt(Product::getPrice)).getSum();
		System.out.println("Total : " + totalFromSummary);
		
		//GroupingBy
		var groupByPrice = products.stream()
				.collect(Collectors.groupingBy(Product::getPrice));
		System.out.println(groupByPrice);
		
		var groupByPartition = products.stream()
				.collect(Collectors.partitioningBy(p -> p.getPrice() > 20));
		System.out.println(groupByPartition.get(true).size());
		System.out.println(groupByPartition.get(false).size());
		
		Set<Product> unmodifiableSet = products.stream()
				  .collect(Collectors.collectingAndThen(Collectors.toSet(),
				  Collections::unmodifiableSet));
		System.out.println(unmodifiableSet);
		
		//Parallel Stream
		Stream<Product> streamCollection = products.parallelStream();
		var res = streamCollection
					.map(p -> p.getPrice() * 12)
					.anyMatch(price -> price > 50);
		
		System.out.println(res);

	}
}
