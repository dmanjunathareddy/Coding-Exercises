package com.softgroup.behavioral.designpatterns.observer;

//Subject interface
interface Subject {
	void addObserver(Observer observer);

	void removeObserver(Observer observer);

	void notifyObservers(String message);
}
