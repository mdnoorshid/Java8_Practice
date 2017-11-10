package com.reactiveworks.learning.methodreference;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

interface Sayable{
	void say();
}
public class StaticRef {
	static Logger logger=Logger.getLogger(StaticRef.class);
public static void saySomeThing(){
	logger.debug("Say Something.....");
}
public static void main(String[] args) {
	BasicConfigurator.configure();
   //Referring static method
	   //Let define with lambda
	Sayable sayable1=()->saySomeThing();
	sayable1.say();
	 //Now turning lambda it into method Reference
	Sayable sayable2=StaticRef::saySomeThing;
	sayable2.say();
	
}
}
