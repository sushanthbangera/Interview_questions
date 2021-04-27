package com.digit88.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Given goals of 2 teams TeamA and TeamB, for every match in TeamB find the 
 * number of matches where goals are less than or equal in TeamA
 */
public class TeamsGoals {

	public static List<Integer> getMatches(List<Integer> teamA, List<Integer> teamB) {
		
		List<Integer> matchCount = new ArrayList<>();
		
		Collections.sort(teamA);
		
		for (Integer goal : teamB) {
			int index = Collections.binarySearch(teamA, goal);
			System.out.println(index);
			matchCount.add(Math.abs(index + 1));
		}
		
		return matchCount;
	}
	
	public static void main(String[] args) {
		List<Integer> teamA = Arrays.asList(1, 2, 3);
		List<Integer> teamB = Arrays.asList(2, 4);
		
		System.out.println(getMatches(teamA, teamB));
	}
}
