package com.reactiveworks.learning.methodreference;

import java.util.function.BiFunction;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

class Arithmetic{
	public static int add(int a,int b){
		return a+b;
	}
}
public class BiFunctionRef {
	static Logger logger=Logger.getLogger(BiFunctionRef.class);
public static void main(String[] args) {
BasicConfigurator.configure();
//Using Lambda Expression	
  /**
   * BiFuntion::Represents a function that accepts two arguments and produces a result.
   *            This is the two-arity specialization of Function.
   *            <T>===>First Arguement:: the type of the first argument to the function
   *            <U>===>Second Arguement:: the type of the second argument to the function
   *            <R> the type of the result of the function  
   */
BiFunction<Integer,Integer,Integer>adder=(a,b)->Arithmetic.add(a, b);
int result=adder.apply(10, 20);
logger.debug("result using lambda:: "+result);

//Using Method Reference
BiFunction<Integer,Integer,Integer>adder2=Arithmetic::add;
int result2=adder.apply(20,30);
logger.debug("result using method reference:: "+result2);


}	
}
