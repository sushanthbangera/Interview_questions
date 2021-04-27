package com.wallmart.interview.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FlatMapIterator<E> implements Iterator<E> {

	private List<E> flattendList;

	private final int size;

	private int curIndex = 0;

	public FlatMapIterator(List<List<E>> listOfLists) {
		flattendList = new ArrayList<>();
		flattenList(listOfLists);
		this.size = flattendList.size();
	}

	@Override
	public boolean hasNext() {
		return curIndex < size;
	}

	@Override
	public E next() {
		if (curIndex < size) {
			return flattendList.get(curIndex++);
		}
		throw new RuntimeException("Iterator out of bounds");
	}

	private void flattenList(List<List<E>> listOfLists) {

		Iterator<List<E>> listsIterator = listOfLists.iterator();

		while (listsIterator.hasNext()) {
			List<E> list = listsIterator.next();

			Iterator<E> listItr = list.iterator();

			while (listItr.hasNext()) {
				flattendList.add(listItr.next());
			}
		}
	}

	public static void main(String[] args) {

		List<List<Integer>> listOfLists = new ArrayList<List<Integer>>();
		listOfLists.add(Arrays.asList(1, 2, 3));
		listOfLists.add(Arrays.asList(4, 6));
		listOfLists.add(Arrays.asList(7, 9));

		FlatMapIterator<Integer> flatMapItr = new FlatMapIterator<>(listOfLists);

		while (flatMapItr.hasNext()) {
			System.out.println(flatMapItr.next());
		}
	}
}
