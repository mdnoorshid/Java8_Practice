package com.reactiveworks.learning.functionalinterface;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * An Interface that contains exactly one abstract method is known as functional interface.
 * It can have any number of default, static methods but can contain only one abstract method. 
 * It can also declare methods of object class.
 *
 *A functional interface can extends to other interface only when that does not have any abstract method.
 */

@FunctionalInterface
interface Sayable{
	void say(String message); //Abstract Method
	
	//It can contain any number of method of Object Class
	int hashCode();
	String toString();
	boolean equals(Object obj);
}

public class FunctionalInterfaceEx implements Sayable {
     static Logger logger=Logger.getLogger(FunctionalInterface.class);
	@Override
	public void say(String message) {
		logger.debug(message);
	}
	public static void main(String[] args) {
		BasicConfigurator.configure();
	    FunctionalInterfaceEx functionalInterfaceEx=new FunctionalInterfaceEx();
	    functionalInterfaceEx.say("====This is functional Interface===");
	}

}
