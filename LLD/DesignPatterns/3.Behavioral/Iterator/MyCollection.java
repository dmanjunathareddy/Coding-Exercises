package com.softgroup.behavioral.designpatterns.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyCollection implements Iterable<Integer> {
	private List<Integer> elements = new ArrayList<>();

	public void addElement(int element) {
		elements.add(element);
	}

	@Override
	public Iterator<Integer> iterator() {
		return (Iterator<Integer>) new MyListIterator(elements);
	}
}