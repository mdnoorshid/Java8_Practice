package com.reactiveworks.learning.functionalinterface;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerInterfaceEx {
	
public static void showDetails(Map<Integer, String>map,String mapName){
	System.out.println("----------"+mapName+" records------------");
	map.forEach((key,val)->System.out.println(key+" "+val));
}
public static void main(String[] args) {
	Map<Integer,String>map=new HashMap<Integer,String>();
	map.put(100,"Md Noorshid");
	map.put(101,"Raja D");
	map.put(102,"Joydeep Paul");
	map.put(103,"Roopa Devi");
	//Referring Method
	BiConsumer<Map<Integer,String>,String> bicon=BiConsumerInterfaceEx::showDetails;
	bicon.accept(map,"Team");
	
}

}
