package com.reactiveworks.learning.java8.miscellaneous;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Misc2 {
	static Logger logger = Logger.getLogger(Misc2.class);

	public static int totalValues(List<Integer> numbers, Predicate<Integer> selector) {
		return numbers.stream().filter(selector).reduce(0, Math::addExact);
	}

	public static void main(String[] args) {
		BasicConfigurator.configure();
		List<Integer> values = Arrays.asList(1, 2, 3, 5, 6, 7, 4, 8, 10);
		// SUM of all numbers
		Integer sumOfAllNumbers = totalValues(values, e -> true);
		logger.debug("sumOfAllNumbers:: " + sumOfAllNumbers);
		// SUM of all even numbers in the list
		Integer sumOfEven = totalValues(values, e -> e % 2 == 0);
		logger.debug("sumOfEven:: " + sumOfEven);
		    //Mixing of Object Composition and Function Composition
	}
}
