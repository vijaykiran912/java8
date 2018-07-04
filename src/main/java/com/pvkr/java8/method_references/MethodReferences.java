package com.pvkr.java8.method_references;

import java.util.ArrayList;
import java.util.List;

import com.pvkr.java8.util.User;

/**
 * @author vipothamse
 * 
 *         Implemented examples from http://www.baeldung.com/java-8-new-features
 *
 */
public class MethodReferences {

	private List<String> list = new ArrayList<String>() {

		private static final long serialVersionUID = 8921059402923330562L;

		{
			add("Vijay");
			add("Kiran");
			add("");
			add("PavaniR");
		}
	};

	private List<User> userList = new ArrayList<User>() {

		private static final long serialVersionUID = 8921059402923330562L;

		{
			add(new User("Vijay"));
			add(new User("Kiran"));
			add(new User("Reddy"));
			add(new User("PavaniR"));
		}
	};

	public static void main(String[] args) {
		MethodReferences methodReferences = new MethodReferences();

		methodReferences.referenceToAStaticMethod();
		methodReferences.referenceToInstanceMethod();
		methodReferences.referenceToAnInstanceMethodOfAnObjectOfAParticularType();
	}

	/**
	 * The reference to a static method holds the following syntax:
	 * <p>
	 * <b>ContainingClass::methodName.</b>
	 */
	private void referenceToAStaticMethod() {
		// 1
		boolean matchedLambda = list.stream().anyMatch(u -> User.isRealUser(u));

		// 1
		boolean matched = list.stream().anyMatch(User::isRealUser);

		System.out.println("matchedLamdba: " + matchedLambda);
		System.out.println("matched: " + matched);
	}

	/**
	 * The reference to an instance method holds the following syntax:
	 * <b>containingInstance::methodName.</b>
	 */
	private void referenceToInstanceMethod() {
		User user = new User();
		// 1
		boolean matchedLambda = list.stream().anyMatch(u -> user.isUserReal(u));

		// 1
		boolean matched = list.stream().anyMatch(user::isUserReal);

		System.out.println("matchedLamdba: " + matchedLambda);
		System.out.println("matched: " + matched);

	}

	/**
	 * This reference method takes the following syntax:
	 * <p>
	 * <b>ContainingType::methodName.</b>
	 */
	/**
	 * 
	 */
	private void referenceToAnInstanceMethodOfAnObjectOfAParticularType() {

		long count = list.stream().filter(String::isEmpty).count();
		System.out.println("Count of Real User's: " + count);

		// Arbitrary Object
		long userCount = userList.stream().filter(User::isUserReal).count();
		System.out.println("Count of User Real User's: " + userCount);
	}
}
