package com.reactiveworks.learning.methodreference;

import java.util.function.BiFunction;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class NonStaticRef {
	static Logger logger = Logger.getLogger(NonStaticRef.class);

	public float addition(int a, float b) {
		return (a + b);
	}

	public static void main(String[] args) {
		BasicConfigurator.configure();
		NonStaticRef nonStaticRef = new NonStaticRef();
		
		//Using  anonymous inner class
		BiFunction<Integer, Float, Float> biFunction = new BiFunction<Integer, Float, Float>() {
			@Override
			public Float apply(Integer t, Float u) {
				return (nonStaticRef.addition(t, u));
			}
		};
		float result = biFunction.apply(21, 30.5f);
		logger.debug("res using  anonymous inner class:: " + result);

		// Using lambda expression
		BiFunction<Integer, Float, Float> adder = (a, b) -> nonStaticRef.addition(a, b);
		float res = adder.apply(20, 30.25f);
		logger.debug("res using lambda:: " + res);
		
		//Using method reference
		BiFunction<Integer, Float, Float> adder2 = nonStaticRef::addition;
		float res2 = adder.apply(30, 20.5f);
		logger.debug("res using method reference:: " + res2);

	}
}
