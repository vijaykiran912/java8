package com.pvkr.java8.aggregate_operations.reductions;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

import com.google.common.collect.ImmutableList;
import com.pvkr.java8.domain.Person;
import com.pvkr.java8.util.Utility;

/**
 * @author vipothamse
 * 
 *         <p>
 *         The collect operation takes three arguments:
 *         <p>
 *         supplier: The supplier is a factory function; it constructs new
 *         instances. For the collect operation, it creates instances of the
 *         result container. In this example, it is a new instance of the
 *         Averager class.
 *         <p>
 *         accumulator: The accumulator function incorporates a stream element
 *         into a result container. In this example, it modifies the Averager
 *         result container by incrementing the count variable by one and adding
 *         to the total member variable the value of the stream element, which
 *         is an integer representing the age of a male member.
 *         <p>
 *         combiner: The combiner function takes two result containers and
 *         merges their contents. In this example, it modifies an Averager
 *         result container by incrementing the count variable by the count
 *         member variable of the other Averager instance and adding to the
 *         total member variable the value of the other Averager instance's
 *         total member variable.
 * 
 * @see <br>
 *      1.classification function <br>
 *      2.downstream collector 3.Collectors class
 *      <p>
 *      A pipeline that contains one or more downstream collectors, is called a
 *      multilevel reduction
 * 
 * 
 */
public class Stream_Collect {
	public static void main(String[] args) {

		List<Person> roster = Utility.getPersonsList();

		Averager averageCollect = roster.stream().filter(p -> p.getGender() == Person.Sex.MALE).map(Person::getAge)
				.collect(Averager::new, Averager::accept, Averager::combine);
		// System.out.println("Average age of all persons: " +
		// averageCollect.average());

		Stream_Collect streamCollect = new Stream_Collect();

		streamCollect.fromBaeldung();
	}

	/**
	 * Stream.collect() is one of the Java 8’s Stream API‘s terminal methods. It
	 * allows to perform mutable fold operations (repackaging elements to some data
	 * structures and applying some additional logic, concatenating them, etc.) on
	 * data elements held in a Stream instance.
	 * 
	 * The strategy for this operation is provided via Collector interface
	 * implementation.
	 * 
	 * <p>
	 * <b>URL:-</b> http://www.baeldung.com/java-8-collectors
	 */
	public void fromBaeldung() {
		List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");

		// 1. Collectors.toList()
		List<String> result = givenList.stream().collect(toList());
		System.out.println("1. Collectors.toList(): " + result);
		System.out.println("Are new list and old list same: " + (givenList == result));

		System.out.println();

		// 2. Collectors.toSet()
		Set<String> setResult = givenList.stream().collect(toSet());
		System.out.println("2. Collectors.toSet(): " + setResult);

		System.out.println();

		// 3. Collectors.toCollection()

		/* When using toSet and toList collectors, you can’t make any assumptions of their implementations. 
		 * If you want to use a custom implementation, you will need to use the toCollection collector
		 *  with a provided collection of your choice.*/
		LinkedList<String> linkedListResult = givenList.stream().collect(toCollection(LinkedList::new));
		System.out.println("3. Collectors.toCollection(): " + linkedListResult);

		System.out.println();

		// 4. Collectors.toMap()
		Map<String, Integer> mapResult = givenList.stream().collect(toMap(Function.identity(), String::length));
		System.out.println("4. Collectors.toMap(): " + mapResult);

		System.out.println();
		// 5. Collectors.collectingAndThen()
		List<String> immutableList = givenList.stream().collect(collectingAndThen(toList(), ImmutableList::copyOf));
		System.out.println("5. Collectors.collectingAndThen(): " + immutableList);

		System.out.println();
		// 6 . Collectors.joining
		String joinedString = givenList.stream().collect(joining());
		String commaSeperatedString = givenList.stream().collect(joining(","));
		String seperatorPrefixPostfixString = givenList.stream().collect(joining(",", "PRE-", "-POST"));
		System.out.println("5. Collectors.joining(): ");
		System.out.println("Joined String: " + joinedString);
		System.out.println("Comma Seperated String: " + commaSeperatedString);
		System.out.println("Seperator Prefix Postfix String: " + seperatorPrefixPostfixString);

		System.out.println();
		// 7. Collectors.counting()
		Long count = givenList.stream().collect(counting());
		System.out.println("7. Collectors.counting()- count: " + count);

		System.out.println();
		// 8. Collectors.summarizingDouble/Long/Int()
		DoubleSummaryStatistics statisticsResult = givenList.stream().collect(summarizingDouble(String::length));

		assertThat(statisticsResult.getAverage()).isEqualTo(2);
		assertThat(statisticsResult.getSum()).isEqualTo(8);
		assertThat(statisticsResult.getMax()).isEqualTo(3);
		assertThat(statisticsResult.getMin()).isEqualTo(1);
		assertThat(statisticsResult.getCount()).isEqualTo(4);

		// 9. Collectors.averagingDouble/Long/Int()
		double average = givenList.stream().collect(averagingDouble(String::length));
		assertThat(average).isEqualTo(2);

		// 10. Collectors.summingDouble/Long/Int()
		int sum = givenList.stream().collect(summingInt(String::length));
		assertThat(sum).isEqualTo(8);

		// 11. Collectors.maxBy()/minBy()
		/*
		 * 1. MaxBy/MinBy collectors return the biggest/the smallest element of a Stream according to a provided Comparator instance.
		 * 2. Notice that returned value is wrapped in an Optional instance. This forces users to rethink the empty collection corner case.
		 */
		Optional<String> max = givenList.stream().collect(maxBy(Comparator.naturalOrder()));
		System.out.println("11. Collectors.maxBy()/minBy(): " + max.get());

		// 12. Collectors.groupingBy()

		Map<Integer, Set<String>> groupResult = givenList.stream().collect(groupingBy(String::length, toSet()));

		assertThat(groupResult).containsEntry(1, new HashSet<String>(Arrays.asList("a")))
				.containsEntry(2, new HashSet<String>(Arrays.asList("bb", "dd")))
				.containsEntry(3, new HashSet<String>(Arrays.asList("ccc")));

		// 13. Collectors.partitioningBy()
		Map<Boolean, List<String>> partitionResult = givenList.stream().collect(partitioningBy(s -> s.length() > 2));

		assertThat(partitionResult).containsEntry(true, new ArrayList<String>(Arrays.asList("ccc")))
				.containsEntry(false, new ArrayList<String>(Arrays.asList("a", "bb", "dd")));

	}
}
