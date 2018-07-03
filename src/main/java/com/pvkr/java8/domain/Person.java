package com.pvkr.java8.domain;

import lombok.Data;

@Data
public class Person {

	public Person(String name, int age, Sex gender, String emailAddress) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.emailAddress = emailAddress;
	}

	public enum Sex {
		MALE, FEMALE
	}

	String name;
	Sex gender;
	String emailAddress;
	int age;

	public void printPerson() {
		System.out.println("Person [name=" + name + ", gender=" + gender + ", emailAddress=" + emailAddress + ", age="
				+ age + "]");
	}

}