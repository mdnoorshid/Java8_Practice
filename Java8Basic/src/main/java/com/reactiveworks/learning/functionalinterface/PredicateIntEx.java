package com.reactiveworks.learning.functionalinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateIntEx {
  
	public static void main(String[] args) {
		List<Integer>numbers=Arrays.asList(-1,-2,-3,-4,-5,-6,-7,1,2,3,4,5,6,7,8);
	
		//Filtering Positive integers
		List<Integer>positiveFilteredNumbers=getFilteredNumbers(numbers, IntegerPredicate.positiveIntegerPredicate);
		//filteredNumbers.forEach(p->System.out.println(p)); //Printing using lambda
		//positiveFilteredNumbers.forEach(System.out::println);     //Printing using method reference
		
		//Filtering Negative integer
		List<Integer>negativeFilteredNumbers=getFilteredNumbers(numbers, IntegerPredicate.negativeIntegerPredicate);
		//negativeFilteredNumbers.forEach(System.out::print);
		
		//Get Specific number
		List<Integer>specificNumber=getFilteredNumbers(numbers,IntegerPredicate.getSpecifiedNumber(8));
		specificNumber.forEach(System.out::println);
		
		
	}
	public static List<Integer>getFilteredNumbers(List<Integer>numbers,Predicate<Integer>integerPredicate){
	    List<Integer>filteredNumbers=new ArrayList<Integer>();
		for(Integer i:numbers){
			if(integerPredicate.test(i)){
				filteredNumbers.add(i);
			}
		}
		return filteredNumbers;
		
	}
	
}
