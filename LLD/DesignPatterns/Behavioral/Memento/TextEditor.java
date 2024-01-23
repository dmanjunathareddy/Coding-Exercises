package com.softgroup.behavioral.designpatterns.memento;

public class TextEditor {

	private String content;

	public TextEditor(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	// Create a memento (snapshot) of the current state
	public TextEditorMemento createMemento() {
		return new TextEditorMemento(content);
	}

	// Restore the state from a memento
	public void restoreFromMemento(TextEditorMemento memento) {
		this.content = memento.getSavedContent();
	}

}