package com.pvkr.java8.method_references;

@FunctionalInterface
interface IntNumPredicate {
	boolean check(IntNumChecker m, int n);
}

/**
 * @author vipothamse <p> Parameter Method Reference This type is the most abstract
 *         one between all these four types. In this case, instead of using a
 *         specific object, you can use the name of the class. Therefore, the
 *         first parameter of the functional interface matches the invoking
 *         object. This is why we call it the parameter method reference. Rest
 *         parameters match the parameters (if any) that are specified by the
 *         method. The following example reimplements the previous example by
 *         using the parameter method reference. First, we will look at a
 *         functional interface, IntNumPredicate, with a single abstract method
 *         called check(). The check()'s first parameter is of the
 *         typeIntNumChecker that will be used to accept the object being
 *         operated upon, and the second parameter takes an int value. This
 *         allows us to create a method reference to the instance
 *         methodisBigger() that can be used with any IntNumChecker objects (e.g
 *         checker 1 and check 2).
 *
 */
public class IntNumChecker {
	final private int num;

	public IntNumChecker(int num) {
		this.num = num;
	}

	// check if num is bigger than the input value n
	boolean isBigger(int n) {
		return num > n;
	}

	public static void main(String[] args) {
		IntNumChecker checker1 = new IntNumChecker(10);
		int numToCompare = 9;
		IntNumPredicate p = IntNumChecker::isBigger;
		boolean result = p.check(checker1, 9);
		if (result) {
			System.out.println(checker1.num + " is bigger than " + numToCompare);
		} else {
			System.out.println(checker1.num + " is smaller  " + numToCompare);
		}
		// second object of IntNumChecker
		IntNumChecker checker2 = new IntNumChecker(8);
		result = p.check(checker2, 9);
		if (result) {
			System.out.println(checker2.num + " is bigger than " + numToCompare);
		} else {
			System.out.println(checker2.num + " is smaller " + numToCompare);
		}
	}
}