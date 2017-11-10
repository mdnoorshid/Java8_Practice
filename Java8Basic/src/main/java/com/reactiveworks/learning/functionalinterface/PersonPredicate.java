package com.reactiveworks.learning.functionalinterface;

import java.util.function.Predicate;

public class PersonPredicate {

//Defining predicate based on Sex of Person
public static Predicate<Person>sexPredicate=p->p.sex.equalsIgnoreCase("male");

//Defining predicate for age
public static Predicate<Person>agePredicate=p->p.getAge()>30;

//Get Person Object for Specific name

public static Predicate<Person> getSpecificPersonObj(String name){
	return p->p.getName().equalsIgnoreCase(name);
}
	
	
	
	
}
