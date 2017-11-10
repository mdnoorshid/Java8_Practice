package com.reactiveworks.learning.functionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicatePersonEx {

	public List<Person> getPersons() {
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("Md Noorshid", 20, "Male"));
		personList.add(new Person("Raja D", 27, "Male"));
		personList.add(new Person("Mukku", 21, "Male"));
		personList.add(new Person("Joydeep Paul", 35, "Male"));
		personList.add(new Person("Vijay Maddi", 39, "Male"));
		personList.add(new Person("Shruti", 19, "Female"));
		return personList;
	}

	public List<Person> getFilteredList(List<Person> personList, Predicate<Person> personPredicate) {
		List<Person> filteredPersonList = new ArrayList<Person>();
		for (Person p : personList) {
			if (personPredicate.test(p)) {
				filteredPersonList.add(p);
			}
		}
		return filteredPersonList;
	}

public static void main(String[] args) {
	List<Person>personList=new PredicatePersonEx().getPersons();
	List<Person>filteredSexPersons=new PredicatePersonEx().getFilteredList(personList, PersonPredicate.sexPredicate);
	//filteredSexPersons.forEach(System.out::println);
	List<Person>filteredAgePersons=new PredicatePersonEx().getFilteredList(personList, PersonPredicate.agePredicate);
	//filteredAgePersons.forEach(System.out::println);
	
	//Filtered Specific Object
	List<Person>filteredSpecificPerson=new PredicatePersonEx().getFilteredList(personList,PersonPredicate.getSpecificPersonObj("Md Noorshid"));
	filteredSpecificPerson.forEach(System.out::print);
	
}

}
