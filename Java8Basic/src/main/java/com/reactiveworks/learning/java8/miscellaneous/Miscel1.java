package com.reactiveworks.learning.java8.miscellaneous;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Miscel1 {
public static void testStreamFuntion(){
	List<Integer>values=Arrays.asList(1,2,3,5,6,7,4,8,10);
	//Defining Predicate
	Predicate<Integer>isGreateThan3=p->p>3;
	//Defining function
	//Function is taking two arguments one is Integer, and other one is Predicate.It is defined so that we are 
	//restricted to one number which is use to create predicate.So now here pivot is the arbitrary value for which 
	//we can create user defined predicate.
	Function<Integer,Predicate<Integer>>greatThan=pivot->number->number>pivot;
	final Stream<Integer>temp=values.stream().filter(greatThan.apply(6)).filter(e->e%2==0).map(p->p*2);
	System.out.println(temp.findFirst());
}
public static void main(String[] args) {
	testStreamFuntion();
}
}
