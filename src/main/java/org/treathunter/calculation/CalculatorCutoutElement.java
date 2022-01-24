package org.treathunter.calculation;

public class CalculatorCutoutElement {
	public double area;
	
	public CalculatorCutoutElement(int lenght, int height) {
		area = lenght * height / 1_000_000;
	}
	
	public CalculatorCutoutElement(double area) {
		this.area = area;
	}
}