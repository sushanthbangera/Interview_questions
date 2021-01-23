package com.interview.linkedin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestSpecialString {

	public String makeLargestSpecial(String binString) {
		
		int count = 0, i = 0;
		
		List<String> swappedString = new ArrayList<String>();
		
		for (int j = 0; j < binString.length(); ++j) {
			
			count = (binString.charAt(j) == '1') ? (count + 1) : (count - 1);
			
			if (count == 0) {
				swappedString.add('1' + makeLargestSpecial(binString.substring(i + 1, j)) + '0');
				i = j + 1;
			}
		}
		
		Collections.sort(swappedString, Collections.reverseOrder());
		return String.join("", swappedString);
	}

	public static void main(String[] args) {

		String s = "1010111000";

		LargestSpecialString largestSpecialString = new LargestSpecialString();
		System.out.println(largestSpecialString.makeLargestSpecial(s));
	}
}
