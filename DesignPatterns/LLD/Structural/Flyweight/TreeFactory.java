package com.softgroup.structural.designpatterns.flyweight;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class TreeFactory {
	private static final Map<String, TreeType> treeTypes = new HashMap<>();

	public static TreeType getTreeType(String name, Color color) {
		String key = name + color.toString();
		if (!treeTypes.containsKey(key)) {
			treeTypes.put(key, new TreeType(name, color));
		}
		return treeTypes.get(key);
	}
}