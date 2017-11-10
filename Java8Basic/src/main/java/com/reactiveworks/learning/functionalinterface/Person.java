package com.reactiveworks.learning.functionalinterface;

public class Person {
String name;
long age;
String sex;

public Person(String name, long age, String sex) {
	super();
	this.name = name;
	this.age = age;
	this.sex = sex;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getAge() {
	return age;
}
public void setAge(long age) {
	this.age = age;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
@Override
public String toString() {
	return "[name=" + name + ", age=" + age + ", sex=" + sex + "]";
}



}
