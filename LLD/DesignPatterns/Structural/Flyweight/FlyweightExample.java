package com.softgroup.structural.designpatterns.flyweight;

import java.awt.Color;

/*The Flyweight pattern is used to minimize memory or computational costs by sharing as much as possible with related objects.
 *  It is particularly useful when dealing with a large number of similar objects that can be effectively shared.*/
public class FlyweightExample {
	public static void main(String[] args) {
		TreeInstance tree1 = new TreeInstance(TreeFactory.getTreeType("Oak", Color.GREEN), 10, 20);
		TreeInstance tree2 = new TreeInstance(TreeFactory.getTreeType("Pine", Color.GREEN), 30, 40);
		TreeInstance tree3 = new TreeInstance(TreeFactory.getTreeType("Oak", Color.GREEN), 50, 60);

		tree1.display(0, 0);
		tree2.display(0, 0);
		tree3.display(0, 0);
	}
}