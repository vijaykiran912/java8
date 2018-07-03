package com.pvkr.java8.lambda_expressions;

import java.util.ArrayList;
import java.util.List;

public class Utility {

	public static List<Person> getPersonsList() {
		List<Person> list = new ArrayList<Person>();

		Person person_1 = new Person("Vijay", 29, Person.Sex.MALE, "vijaykiran.912@gmail.com");
		Person person_2 = new Person("Raghu", 30, Person.Sex.MALE, "raghurudhraraju@gmail.com");
		Person person_3 = new Person("Andria", 34, Person.Sex.FEMALE, "andrea@gmail.com");
		Person person_4 = new Person("Elizibeth", 32, Person.Sex.FEMALE, "elizibeth.9@gmail.com");

		list.add(person_1);
		list.add(person_2);
		list.add(person_3);
		list.add(person_4);

		return list;
	}
}
