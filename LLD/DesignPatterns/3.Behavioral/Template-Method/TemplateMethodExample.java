package com.softgroup.behavioral.designpatterns.templatemethod;

public class TemplateMethodExample {

	public static void main(String[] args) {
		Game cricketGame = new Cricket();
		Game footballGame = new Football();

		System.out.println("Playing Cricket:");
		cricketGame.play();

		System.out.println("\nPlaying Football:");
		footballGame.play();
	}

}
