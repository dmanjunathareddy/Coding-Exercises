package com.softgroup.behavioral.designpatterns.memento;

public class MementoPatternExample {

	/*
	 * The Memento design pattern is provides the ability to restore an object to
	 * its previous state (undo/redo functionality) without exposing its internal
	 * structure. This pattern involves three main components: the Originator, the
	 * Memento, and the Caretaker.
	 */

	public static void main(String[] args) {
		TextEditor textEditor = new TextEditor("Hello, World!");
		History history = new History();
		history.addMemento(textEditor.createMemento());
		textEditor.setContent("Design Patterns are awesome!");
		history.addMemento(textEditor.createMemento());
		System.out.println("Current Content: " + textEditor.getContent());
		textEditor.restoreFromMemento(history.getMemento(0));
		System.out.println("Restored Content: " + textEditor.getContent());
		textEditor.restoreFromMemento(history.getMemento(1));
		System.out.println("Restored Content: " + textEditor.getContent());
	}
}
