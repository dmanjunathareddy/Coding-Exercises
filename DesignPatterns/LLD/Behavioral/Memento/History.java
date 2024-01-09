package com.softgroup.behavioral.designpatterns.memento;

import java.util.ArrayList;
import java.util.List;

public class History {
	private List<TextEditorMemento> mementos = new ArrayList<>();

	public void addMemento(TextEditorMemento memento) {
		mementos.add(memento);
	}

	public TextEditorMemento getMemento(int index) {
		return mementos.get(index);
	}
}
