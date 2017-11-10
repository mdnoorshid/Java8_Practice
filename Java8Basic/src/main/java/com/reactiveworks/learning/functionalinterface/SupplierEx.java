package com.reactiveworks.learning.functionalinterface;

import java.util.function.Supplier;

/*java.util.function.Supplier is a functional interface in java 8. 
Supplier can be assigned in lambda expression.
Supplier can be passed as an argument to different methods in java 8.
Supplier has a functional method get(). 
Supplier and Consumer can be used to implement producer and consumer. 
In our example we will describe how to create and use Supplier in our programming. */
public class SupplierEx {
public static void main(String[] args) {
Supplier<String>supplier=()->{
	    String[] teamArr={"Md Noorshid","Raja D","Joydeep Paul","Roopa Devi"};
	    int i=(int) (Math.random()*2+1);
		return teamArr[i];
	};
	for(int i=0;i<=1000000000;i++){
	System.out.println(supplier.get());
	if(supplier.get().equalsIgnoreCase("Md Noorshid")){
		System.out.println("Md Noorshid found at:: "+i);
		break;
	}
	}
}
	
	
	
}
