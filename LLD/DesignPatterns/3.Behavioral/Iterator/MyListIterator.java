package com.softgroup.behavioral.designpatterns.iterator;

import java.util.List;

public class MyListIterator implements MyIterator {
	private List<Integer> elements;
	private int index;

	public MyListIterator(List<Integer> elements) {
		this.elements = elements;
		this.index = 0;
	}

	@Override
	public boolean hasNext() {
		return index < elements.size();
	}

	@Override
	public int next() {
		if (hasNext()) {
			int element = elements.get(index);
			index++;
			return element;
		}
		throw new RuntimeException("No more elements");
	}
}