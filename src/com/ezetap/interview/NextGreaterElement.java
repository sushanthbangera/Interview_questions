package com.ezetap.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {

	public List<Integer> getNextGreaterElements(List<Integer> elements) {
		
		List<Integer> greaterElements = new ArrayList<>();
		
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = elements.size() - 1; i > 0; i--) {
			
			int curElement = elements.get(i);
			int greaterElement = 0;
			
			while (!stack.isEmpty()) {
				//if (stack.)
			}
		}
		
		return greaterElements;
		
	}
}
