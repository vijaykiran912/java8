package com.pvkr.java8.optional;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

import com.pvkr.java8.custom.annotation.CompilerError;
import com.pvkr.java8.domain.Human;

/**
 * @author vipothamse
 * 
 *         <p>
 * @see <a href=
 *      "https://blog.joda.org/2014/11/optional-in-java-se-8.html">BLOG</a><br>
 *      Optional class is not intended to use as bean properties, use it as
 *      return type.
 * 
 */
public class OptionalTest {

	@Test
	public void startWithOptional() {

		Optional<String> optional = Optional.of("Vijay");
		Optional<String> emptyString = Optional.empty();

		Assert.assertNotNull("Optional is not null", optional);
		Assert.assertThat(optional, instanceOf(Optional.class));
		Assert.assertThat(emptyString, instanceOf(Optional.class));

		Assert.assertTrue("Optional is empty", optional.isPresent());
		Assert.assertFalse(emptyString.isPresent());

	}

	/**
	 * Assigning null reference to Optional throws NullPointerException.<br>
	 * In such cases use Optional.ofNullable()
	 * 
	 */
	@Test
	public void setNullReferenceToOptional() {
		String str = null;

		Optional<String> optionalStr = Optional.ofNullable(str);
		
		assertThrows(NullPointerException.class, () -> Optional.of(str));
		assertFalse(optionalStr.isPresent());
	}

	@CompilerError
	public void declareReferenceAsOptional() {
		Human human = new Human("vijay", "male");
		// Optional<String> nameOptional = human.getName();
	}

}
