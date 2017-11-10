package com.reactiveworks.learning.defaultmethod;

import org.apache.log4j.BasicConfigurator;

public class Customer {
public static void main(String[] args) {
	BasicConfigurator.configure();
	Mobile microsoftWin=new Mobile();
	microsoftWin.insertSIM(new AirtelSIM());
}
}
