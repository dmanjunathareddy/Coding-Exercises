package com.softgroup.behavioral.designpatterns.templatemethod;

public abstract class Game {
	abstract void initialize();

	abstract void startPlay();

	abstract void endPlay();

	// Template method
	final void play() {
		initialize();
		startPlay();
		endPlay();
	}
}