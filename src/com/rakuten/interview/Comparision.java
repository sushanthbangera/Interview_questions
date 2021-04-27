package com.rakuten.interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Comparision {

	public static void main(String[] args) {

		List<Person> pList = new ArrayList<>();
		pList.add(new Person(10, "Alex", new Address("a", "b", "c")));
		pList.add(new Person(71, "Ram", new Address("a", "b", "c")));
		pList.add(new Person(3, "Jhon", new Address("a", "b", "c")));
		pList.add(new Person(34, "Jhon", new Address("a", "b", "c")));

		/*
		 * Sort with name and then Id ascending
		 */
		Comparator<Person> nameComp = Comparator.comparing(Person::getName).thenComparing(Person::getId);

		List<Person> sortedPersons = pList.stream().sorted(nameComp).collect(Collectors.toList());

		System.out.println(sortedPersons);

		/*
		 * Sort with name ascending, then sort with Id descending
		 */
		Comparator<Person> idDescComparing = Comparator.comparing(Person::getId).reversed();

		Comparator<Person> nameAscIdDescComparing = Comparator.comparing(Person::getName)
				.thenComparing(idDescComparing);

		List<Person> sortedPersons2 = pList.stream().sorted(nameAscIdDescComparing).collect(Collectors.toList());

		System.out.println(sortedPersons2);

	}
}
