package org.treathunter.calculation;

public class CalculatorCutoutElement {
	public double area;
	
	public CalculatorCutoutElement(int lenght, int width) {
		area =(double) lenght * width / 1_000_000; //m^2
	}
	
	public CalculatorCutoutElement(double area) {
		this.area = area;
	}
}