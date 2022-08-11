package com.waiyanhtet.collect;

import java.util.Arrays;
import java.util.List;

public class Product {

	private int price;
	private String name;

	public Product(int price, String name) {
		super();
		this.price = price;
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static List<Product> getProductList() {
		return Arrays.asList(
				new Product(23, "potatoes"),
				new Product(14, "orange"),
				new Product(19, "lemon"),
				new Product(25, "bread"),
				new Product(13, "sugar"));
	}

}
