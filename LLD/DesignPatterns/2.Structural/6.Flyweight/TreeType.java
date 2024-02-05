package com.softgroup.structural.designpatterns.flyweight;

import java.awt.Color;

public class TreeType implements Tree {
	private final String name;
	private final Color color;

	public TreeType(String name, Color color) {
		this.name = name;
		this.color = color;
	}

	@Override
	public void display(int x, int y) {
		System.out.println("TreeType: " + name + ", Color: " + color + ", Position: (" + x + ", " + y + ")");
	}
}