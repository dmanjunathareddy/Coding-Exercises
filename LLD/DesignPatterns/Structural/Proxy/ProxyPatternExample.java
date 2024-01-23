package com.softgroup.structural.designpatterns.proxy;

/*The Proxy pattern is a placeholder for another object to control access to it. 
This is useful for scenarios where you want to add some level of control over the interaction
with an object, such as lazy loading, access control, logging, or monitoring.*/
public class ProxyPatternExample {
	public static void main(String[] args) {
		Image image = new ProxyImage("sample.jpg");

		// Image is loaded and displayed only when needed
		image.display();

		// Image is not loaded again; it is displayed from the proxy
		image.display();
	}
}