package com.softgroup.behavioral.designpatterns.iterator;

public class IteratorPatternExample {
	public static void main(String[] args) {
		MyCollection collection = new MyCollection();
		collection.addElement(1);
		collection.addElement(2);
		collection.addElement(3);

		MyIterator iterator = (MyIterator) collection.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}