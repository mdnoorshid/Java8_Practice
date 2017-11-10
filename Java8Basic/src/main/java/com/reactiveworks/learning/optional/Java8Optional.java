package com.reactiveworks.learning.optional;

import java.util.Optional;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Java8Optional {
	static Logger logger=Logger.getLogger(Java8Optional.class);
public Integer sum(Optional<Integer>a,Optional<Integer>b){
	//Optional.isPresent -checks the value is present or not
	logger.debug("First parameter is present:: "+a.isPresent());
	logger.debug("Second parameter is present:: "+b.isPresent());
	
	//Optional.orElse - returns the value if present otherwise returns
    //the default value passed.
	Integer value1=a.orElse(new Integer(0));
	
	//Optional.get- gets the value, value should be present
	Integer value2=b.get();
	return value1+value2;
}
public static void main(String[] args) {
	BasicConfigurator.configure();
	Java8Optional java8Optional=new Java8Optional();
	Integer value1=null;
	Integer value2=new Integer(10);
	//Optional.ofNullable -allows passed parameter to be null
	Optional<Integer>a=Optional.ofNullable(value1);
	//Optional.of -throws NullPointerException if passed parameter is null
	Optional<Integer>b=Optional.of(value2);
	logger.debug(java8Optional.sum(a, b));
}
}
