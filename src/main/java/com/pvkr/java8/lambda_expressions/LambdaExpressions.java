package com.pvkr.java8.lambda_expressions;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.pvkr.java8.domain.Person;
import com.pvkr.java8.util.Utility;

/**
 * @author vipothamse
 * @see <a href=
 *      "https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html">REFERENCE
 *      DOC</a>
 *
 *      <p>
 *      1. Lambda expressions let you express instances of single-method classes
 *      more compactly
 *      <p>
 *      2. A functional interface is any interface that contains only one
 *      abstract method. (A functional interface may contain one or more default
 *      methods or static methods.) Because a functional interface contains only
 *      one abstract method, you can omit the name of that method when you
 *      implement it. To do this, instead of using an anonymous class
 *      expression, you use a lambda expression
 *      <p>
 *      3.
 * 
 */
public class LambdaExpressions {
	public static void main(String[] args) {
		LambdaExpressions lambdaExp = new LambdaExpressions();
		System.out.println(
				"*****************************************SCENARIO STARTS****************************************");
		lambdaExp.searchCriteriaWithLambdaExpres();
		System.out.println(
				"*****************************************SCENARIO ENDS****************************************");
		System.out.println();
		System.out.println(
				"*****************************************SCENARIO STARTS****************************************");
		lambdaExp.searchCriteriaWithLambdaExpresAndPredicate();
		System.out.println(
				"*****************************************SCENARIO ENDS****************************************");
		System.out.println();
		System.out.println(
				"*****************************************SCENARIO STARTS****************************************");
		lambdaExp.callProcessPersons();
		System.out.println(
				"*****************************************SCENARIO ENDS****************************************");
		System.out.println();
		System.out.println(
				"*****************************************SCENARIO STARTS****************************************");
		lambdaExp.callProcessPersonsWithFunction();
		System.out.println(
				"*****************************************SCENARIO ENDS****************************************");
		System.out.println();
		System.out.println(
				"*****************************************SCENARIO STARTS****************************************");
		lambdaExp.callProcessElements();
		System.out.println(
				"*****************************************SCENARIO ENDS****************************************");
		System.out.println();
		System.out.println(
				"*****************************************SCENARIO STARTS****************************************");
		lambdaExp.usingAggregateOperationsThatAcceptLambda();
		System.out.println(
				"*****************************************SCENARIO ENDS****************************************");

	}

	private void searchCriteriaWithLambdaExpres() {
		List<Person> list = Utility.getPersonsList();
		printPersons(list, (Person p) -> p.getGender() == Person.Sex.MALE && p.getAge() >= 30 && p.getAge() <= 34);
	}

	private void searchCriteriaWithLambdaExpresAndPredicate() {
		List<Person> list = Utility.getPersonsList();
		printPersonsWithPredicate(list,
				(Person p) -> p.getGender() == Person.Sex.FEMALE && p.getAge() >= 30 && p.getAge() <= 34);
	}

	public static void printPersons(List<Person> roster, CheckPerson tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}

	public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}

	private void callProcessPersons() {
		List<Person> list = Utility.getPersonsList();
		processPersons(list, p -> p.getGender() == Person.Sex.FEMALE && p.getAge() >= 30 && p.getAge() <= 34,
				p -> p.printPerson());
	}

	public static void processPersons(List<Person> roster, Predicate<Person> tester, Consumer<Person> block) {
		for (Person p : roster) {
			if (tester.test(p)) {
				block.accept(p);
			}
		}
	}

	private void callProcessPersonsWithFunction() {
		List<Person> list = Utility.getPersonsList();
		processPersonsWithFunction(list, p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 30 && p.getAge() <= 35,
				p -> p.getEmailAddress(), email -> System.out.println(email));
	}

	public static void processPersonsWithFunction(List<Person> roster, Predicate<Person> tester,
			Function<Person, String> mapper, Consumer<String> block) {
		for (Person p : roster) {
			if (tester.test(p)) {
				String data = mapper.apply(p);
				block.accept(data);
			}
		}
	}

	private void callProcessElements() {
		List<Person> list = Utility.getPersonsList();
		processPersonsWithFunction(list, p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 29 && p.getAge() <= 35,
				p -> p.getEmailAddress(), email -> System.out.println(email));
	}

	/**
	 * @param roster
	 * @param tester
	 * @param mapper
	 * @param block
	 * 
	 *            Applying Generics more extensively, modified
	 *            processPersonsWithFunction
	 */
	public static <X, Y> void processElements(List<X> roster, Predicate<X> tester, Function<X, Y> mapper,
			Consumer<Y> block) {
		for (X p : roster) {
			if (tester.test(p)) {
				Y data = mapper.apply(p);
				block.accept(data);
			}
		}
	}

	private void usingAggregateOperationsThatAcceptLambda() {
		List<Person> list = Utility.getPersonsList();
		list.stream().filter(p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 29 && p.getAge() <= 35)
				.map(p -> p.getEmailAddress()).forEach(email -> System.out.println(email));
	}
}
