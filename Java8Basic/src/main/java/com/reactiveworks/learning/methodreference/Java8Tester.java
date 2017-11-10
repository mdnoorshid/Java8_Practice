package com.reactiveworks.learning.methodreference;

import java.util.Arrays;
import java.util.List;

public class Java8Tester {
public static void main(String[] args) {
	List<String>names=Arrays.asList("Md Noorshid","Raja D","Joydeep Paul","Dileepa");
	names.forEach(System.out::println);
}
}
