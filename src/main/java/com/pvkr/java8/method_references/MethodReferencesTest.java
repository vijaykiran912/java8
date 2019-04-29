package com.pvkr.java8.method_references;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.BiFunction;
import java.util.function.Function;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.pvkr.java8.domain.Computer;
import com.pvkr.java8.domain.MacbookPro;

public class MethodReferencesTest {

	@Test
	public void a_Super_Method_of_a_Particular_Object() {
		/*Requires an functional interface to hold the method reference and apply abstract method on the functional interface
		to create the object*/
		InterfaceComputer c = MacbookPro::new;
		Computer macBookPro = c.create();

		// Calling sub class method, which in turn calls super class method
		assertEquals(76.66666666666667d, macBookPro.calculateValue(100d));

	}

	/**
	 * Requires an functional interface to hold the method reference and apply
	 * abstract method on the func interface to create the object
	 */
	@Test
	public void create_a_New_Instance() {
		InterfaceComputer c = MacbookPro::new;
		Computer macBookPro = c.create();

		Assert.assertThat(macBookPro, instanceOf(MacbookPro.class));
		Assert.assertThat(macBookPro, instanceOf(Computer.class));
	}

	@Test
	public void one_parameter_in_a_constructor() {
		Function<String, Computer> computerGernerator = MacbookPro::new;
		Computer _1_Constr_Object = computerGernerator.apply("White");

		assertEquals(_1_Constr_Object, new MacbookPro("White"));
	}

	@Test
	public void two_parameters_in_a_constructor() {
		BiFunction<String, Integer, Computer> computerGernerator = MacbookPro::new;
		Computer _2_Constr_Object = computerGernerator.apply("White", 2013);

		assertEquals(_2_Constr_Object, new MacbookPro("White", 2013));
	}

	/**
	 * If parameters are three or more you have to define a new Functional interface
	 */
	@Test
	public void three_parameters_in_a_constructor() {
		TriFunction<String, Integer, Double, Computer> computerGernerator = MacbookPro::new;
		Computer _2_Constr_Object = computerGernerator.apply("White", 2013, 100d);

		assertEquals(_2_Constr_Object, new MacbookPro("White", 2013, 100d));
	}

	@Test
	public void usage_of_and_then_in_tri_function() {
		TriFunction<String, Integer, Double, MacbookPro> computerGernerator = MacbookPro::new;
		
		TriFunction<String, Integer, Double, Double> computerGernerator1 = computerGernerator.andThen((computer) -> computer.getPrice());
		System.out.println(computerGernerator1.apply("White", 2013, 100d));
	}

}
