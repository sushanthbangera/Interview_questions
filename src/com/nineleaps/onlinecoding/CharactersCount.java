package com.nineleaps.onlinecoding;

class CharactersCount {
	private final String name;
	private final Integer distinctCharacterCount;

	public CharactersCount(String name, Integer distinctCharacterCount) {
		this.name = name;
		this.distinctCharacterCount = distinctCharacterCount;
	}

	@Override
	public String toString() {
		return "\"" + this.name + "\" has " + this.distinctCharacterCount + " distinct characters.";
	}
}
