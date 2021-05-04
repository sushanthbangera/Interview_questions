package com.nineleaps.onlinecoding;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

class Mapper {

	public static Function<String, CharactersCount> getDistinctCharactersCount() {
		return e -> {
			Set<Character> set = new HashSet<>();
			for (int i = 0; i < e.length(); i++) {
				set.add(e.charAt(i));
			}
			return new CharactersCount(e, set.size());
		};
	}
}