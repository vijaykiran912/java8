package com.pvkr.java8._interface;

/**
 * @author vipothamse
 *
 *         <p>
 *         Starting with Java 8, interfaces can have static and default methods
 *         that, despite being declared in an interface, have a defined
 *         behavior.
 *
 */
public interface Vehicle {

	/**
	 * Static Method
	 */
	static String producer() {
		return "N&F Vehicles";
	}

	/**
	 * @return
	 * 
	 * 		default method
	 */
	default String getOverview() {
		return "ATV made by " + producer();
	}

}
