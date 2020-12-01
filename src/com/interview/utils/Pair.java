package com.interview.utils;

public class Pair<U, V> {

	public final U first;

	public final V second;

	private Pair(U first, V second) {
		this.first = first;
		this.second = second;
	}

	public static <U, V> Pair<U, V> of(U first, V second) {
		return new Pair<>(first, second);
	}

	// To change body of generated methods, choose
	// Tools | Templates.
	public void add(Pair<Integer, Double> pair) {
		throw new UnsupportedOperationException("Not supported yet."); 
	}
	
	public String toString() {
		return "(" + this.first + ", " + this.second + ")";
	}
}
