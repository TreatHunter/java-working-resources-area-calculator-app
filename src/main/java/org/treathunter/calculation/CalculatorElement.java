package org.treathunter.calculation;

import java.util.ArrayList;

public class CalculatorElement {
	public ArrayList<CalculatorCutoutElement> cutOutsList = new ArrayList<CalculatorCutoutElement>(); 
	public double areaWithoutCutouts;
	public double areaWithCutouts;
	
	public CalculatorElement (int lenght, int width, int edge, int hem, ArrayList<CalculatorCutoutElement> cutOutsList) {
		areaWithoutCutouts = (lenght * width + lenght * edge + lenght * hem) / 1_000_000;
		areaWithCutouts = areaWithoutCutouts - cutOutsList
				.parallelStream()
				.mapToDouble(c -> c.area)
				.sum();
	}
}