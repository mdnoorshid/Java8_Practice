package com.reactiveworks.learning.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

/*Stream represents a sequence of objects from a source,
which supports aggregate operations.*/
public class StreamEx {

	public static List<Product> gerProducts() {
		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product(1, "HP Laptop", 25000f));
		productList.add(new Product(2, "Dell Laptop", 30000f));
		productList.add(new Product(3, "Lenevo Laptop", 28000f));
		productList.add(new Product(4, "Sony Laptop", 28000f));
		productList.add(new Product(5, "Apple Laptop", 90000f));
		return productList;
	}

	public static void main(String[] args) {
		List<Product> prodList = gerProducts();
		streamManipulation(prodList);

	}

	public static void streamManipulation(List<Product> prodList) {
		List<Product> filteredListGetObj = prodList.stream().filter(p -> p.getPrice() > 26000)
				.collect(Collectors.toList());
		System.out.println("filteredListGetObj----> " + filteredListGetObj);
		List<String> filteredListAnotherListObj = prodList.stream().filter(p -> p.getPrice() > 26000)
				.map(p -> p.getName()).collect(Collectors.toList());
     	System.out.println("filteredListAnotherListObj----> " + filteredListAnotherListObj);

		// Number of Objects
		long count = prodList.stream().filter(p -> p.getPrice() < 26000).count();
	 	System.out.println("count----> " + count);

		prodList.stream().filter(p -> p.getPrice() > 26000).forEach(product -> System.out.println(product.name));

		// Calculating Price
		Float totalPrice = prodList.stream().map(product -> product.price).reduce(0.0f, (sum, price) -> sum + price);
	 	System.out.println("Total Price----> " + totalPrice);

		// Using Collectors method to sum the price
		double totalPrice2 = prodList.stream().collect(Collectors.summingDouble(product -> product.price));
	 	System.out.println("Total Price2----> " + totalPrice2);

		// Converting List into Map
		Map<Integer, String> brandMap = prodList.stream().collect(Collectors.toMap(p -> p.id, p -> p.name));
	    System.out.println("brandMap----> " + brandMap);

		// Method Reference In Stream
		List<String> filteredListUsingMethodRef = prodList.stream().filter(p -> p.getPrice() > 26000)
				.map(Product::getName).collect(Collectors.toList());
		System.out.println("filteredListUsingMethodRef:: " + filteredListUsingMethodRef);
		
		
		List<String>streamEx=Arrays.asList("Md Noorshid","Raja D","Joydeep Paul","Vijay Maddi");
		Stream<String>stream=streamEx.stream();
		stream.forEach(System.out::println);
		//stream.forEach(System.out::println);//Through Exception as java.lang.IllegalStateException: stream has already been operated upon or closed
		                                    //because stream can be consumed  only once
	
	/*	List<Product> productList = new ArrayList<Product>();
		productList.add(new Product(1, "HP Laptop", 25000f));
		productList.add(new Product(2, "Dell Laptop", 30000f));
		productList.add(new Product(3, "Lenevo Laptop", 28000f));
		productList.add(new Product(4, "Sony Laptop", 28000f));
		productList.add(new Product(5, "Apple Laptop", 90000f));
		long count=productList.stream().filter(p->p.getPrice()>28000).distinct().limit(3).count();
		System.out.println(count);*/
		
		List<String>itemList=Arrays.asList("NoteBook","Pen","Book","Eraser","Pencil","NoteBook");
        List  countItem=itemList.stream().filter(p->p.startsWith("N")).distinct().collect(Collectors.toList());
        System.out.println("countItem::: "+countItem);		
		
        List<Integer>wordsLength=itemList.stream().map(String::length).collect(Collectors.toList());
        System.out.println("wordsLength:: "+wordsLength);
         	
        List<Integer>wordsLength2=itemList.stream().map(l->l.length()).collect(Collectors.toList());
        System.out.println("wordsLength2:: "+wordsLength2);
		
	}
}
