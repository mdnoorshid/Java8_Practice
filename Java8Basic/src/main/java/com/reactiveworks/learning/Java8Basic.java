package com.reactiveworks.learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Java8Basic {
	static Logger logger=Logger.getLogger(Java8Basic.class);
  public static void main(String[] args) {
	  BasicConfigurator.configure();
	List<String>names1=new ArrayList<String>();
	names1.add("Md Noorshid");
	names1.add("Raja");
	names1.add("Paul");
	names1.add("Dileep");
	names1.add("Vijay");
	
	List<String>names2=new ArrayList<String>();
	names2.add("Md Noorshid");
	names2.add("Raja");
	names2.add("Paul");
	names2.add("Dileep");
	names2.add("Vijay");
	
	Java8Basic java8Basic=new Java8Basic();
	logger.debug("Comparing Using Java7......");
	java8Basic.compareWithJava7(names1);
	logger.debug(names1);
	logger.debug("Comparing Using Java8......");
	java8Basic.compareWithJava8(names2);
	logger.debug(names2);
	
	
	
}
private void compareWithJava8(List<String> names) {
	Collections.sort(names,(s1,s2)->s1.compareTo(s2));
}
private void compareWithJava7(List<String> names1) {
   Collections.sort(names1,new Comparator<String>() {

	public int compare(String s1, String s2) {
		return s1.compareTo(s2);
	}
});	
}	
	

}
