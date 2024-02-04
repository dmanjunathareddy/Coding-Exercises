package com.softgroup.behavioral.designpatterns.memento;

public class TextEditorMemento {
	private String savedContent;

	public TextEditorMemento(String content) {
		this.savedContent = content;
	}

	public String getSavedContent() {
		return savedContent;
	}
}
