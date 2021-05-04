package com.nineleaps.onlinecoding;

import java.util.function.Predicate;

class Filter {

	public static Predicate<String> nameStartingWithPrefix(String prefix) {
		return s -> s.startsWith(prefix);
	}
}