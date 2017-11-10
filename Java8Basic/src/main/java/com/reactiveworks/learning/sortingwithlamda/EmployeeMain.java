package com.reactiveworks.learning.sortingwithlamda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class EmployeeMain {
	static Logger logger = Logger.getLogger(EmployeeMain.class);

	public List<Employee> getEmployees() {
		List<Employee> empList = Arrays.asList(new Employee("Md", "Noorshid", 20), new Employee("Raja", "D", 25),
				new Employee("Vijay", "Maddi", 37), new Employee("Joydeep", "Paul", 35),
				new Employee("Dileep", "A", 30));
		return empList;
	}

	public static void main(String[] args) {
		BasicConfigurator.configure();
		EmployeeMain empmain = new EmployeeMain();
		List<Employee> empList = empmain.getEmployees();

		// Unsorted List
		logger.debug("-------------------Unsorted List---------------");
		logger.debug(empList);

		// Sorting based on age
		logger.debug("-------------------Sorting Based on Age--------------");
		empList.sort((Employee e1, Employee e2) -> e1.getAge() - e2.getAge());
		logger.debug(empList);

		// Sorting based on First Name
		logger.debug("-------------------Sorting Based on First Name--------------");
		empList.sort((Employee e1, Employee e2) -> e1.getFirstName().compareTo(e2.getFirstName()));
		logger.debug(empList);

		// Sorting based on Second Name
		logger.debug("-------------------Sorting Based on Second Name--------------");
		empList.sort((Employee e1, Employee e2) -> e1.getLastName().compareTo(e2.getLastName()));
		logger.debug(empList);
	}

}
