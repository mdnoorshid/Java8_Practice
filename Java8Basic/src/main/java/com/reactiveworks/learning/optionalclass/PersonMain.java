package com.reactiveworks.learning.optionalclass;

import java.util.Optional;

import org.apache.log4j.Logger;

public class PersonMain {
         static Logger logger=Logger.getLogger(PersonMain.class);
	public String getInsuranceName(Optional<Person>person){
		return person.flatMap(Person::getCar)
				     .flatMap(Car::getInsurance)
				     .map(Insurance::getName).orElse("Unknown");
 	}
      public static void main(String[] args) {
		Optional<Person>person =Optional.ofNullable(new Person());
		String result=new PersonMain().getInsuranceName(person);
	    logger.debug("result----> "+result);
	}
}
