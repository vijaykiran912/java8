package com.pvkr.java8.method_references;

import java.util.Arrays;
import java.util.List;

public class ArbitraryInstanceMethodReference {
	public static void main(String args[]) {
		final List<Person> people = Arrays.asList(new Person("dan"), new Person("laura"));
		// Method reference
		people.stream().filter(Person::isValidPerson).forEach(Person::printName);

		// Lambda expression
		people.forEach(person -> person.printName());
		// normal
		for (final Person person : people) {
			person.printName();
		}
	}

	private static class Person {
		private String name;

		public Person(final String name) {
			this.name = name;
		}

		public void printName() {
			System.out.println(name);
		}

		public boolean isValidPerson() {
			return this.name.length() == 5;
		}
	}
}