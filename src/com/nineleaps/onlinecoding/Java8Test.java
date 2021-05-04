package com.nineleaps.onlinecoding;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Java8Test {
	
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		List<String> names = Arrays.asList("aaryanna", "aayanna", "airianna", "alassandra", "allanna", "allannah",
				"allessandra", "allianna", "allyanna", "anastaisa", "anastashia", "anastasia", "annabella", "annabelle",
				"annebelle");

		names.stream().filter(Filter.nameStartingWithPrefix(scanner.nextLine()))
				.map(Mapper.getDistinctCharactersCount()).forEachOrdered(System.out::println);
	}
}