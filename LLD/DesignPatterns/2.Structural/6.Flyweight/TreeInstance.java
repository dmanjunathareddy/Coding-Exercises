package com.softgroup.structural.designpatterns.flyweight;

public class TreeInstance implements Tree {
	private final TreeType treeType;
	private final int x;
	private final int y;

	public TreeInstance(TreeType treeType, int x, int y) {
		this.treeType = treeType;
		this.x = x;
		this.y = y;
	}

	@Override
	public void display(int x, int y) {
		treeType.display(this.x + x, this.y + y);
	}
}
