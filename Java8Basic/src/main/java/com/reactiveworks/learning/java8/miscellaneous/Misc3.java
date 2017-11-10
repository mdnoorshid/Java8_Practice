package com.reactiveworks.learning.java8.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Misc3 {
public List<String>getUnique(){
	String[] arrayOfWords={"GoodBye","World"};
	Stream<String>streamOfWords=Arrays.stream(arrayOfWords);
	List<String>uniqueCharactersList=streamOfWords.map(w->w.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
	return uniqueCharactersList;
}
public static void main(String[] args) {
	List<String>finalResult=new Misc3().getUnique();
	System.out.println("finalResult:: "+finalResult);
	String test="GoodBye";
	String[] testarr=test.split("");
    for(String s:testarr){
    	System.out.print(s);
    }
    System.out.println();
    System.out.println(testarr.length);
	
}
}
