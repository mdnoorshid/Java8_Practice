package com.reactiveworks.learning.functionalinterface;

import java.util.function.Predicate;

public class IntegerPredicate {
/**
 * Represents a predicate (Boolean-valued function) of one argument.
 */
//Defining using using anonymous Inner Class	
public static Predicate<Integer>positiveIntegerPredicate=new Predicate<Integer>() {
	@Override
	public boolean test(Integer i) {
		return i>0;
	}
	
};

//Defining using lambda(For negative values)
public static Predicate<Integer>negativeIntegerPredicate=p->p<0;

//Return specific number
public static Predicate<Integer> getSpecifiedNumber(Integer arg){
     /*  return new Predicate<Integer>() {
		@Override
		public boolean test(Integer i) {
			return i==arg;
		}
	};*/
	return b->b==arg;
}

}
