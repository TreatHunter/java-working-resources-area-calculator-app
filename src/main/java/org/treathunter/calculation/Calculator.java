package org.treathunter.calculation;

import java.util.ArrayList;

public class Calculator {
	private double totalAreaWithoutCutouts;
	private double totalAreaWithCutouts;
	private double sheetsAmount;
	private double totalCost;
	private double totalArea;
	
	public void calculate(ArrayList<CalculatorElement> elList, double squareMeterCost, double sheetLength, double sheetWidth) {
		totalAreaWithoutCutouts = elList
				.parallelStream()
				.mapToDouble(el -> el.areaWithoutCutouts)
				.sum();
		totalAreaWithCutouts = elList
				.parallelStream()
				.mapToDouble(el -> el.areaWithCutouts)
				.sum();
		double sheetArea = sheetLength * sheetWidth / 1_000_000; //m^2
		sheetsAmount = totalAreaWithCutouts / sheetArea;
		totalCost = totalAreaWithoutCutouts * squareMeterCost;
		totalArea = totalAreaWithCutouts;
	}
	
	public double getSheetsAmount() {
		return sheetsAmount;
	}
	
	public double getTotalCost() {
		return totalCost;
	}
	
	public double getTotalArea() {
		return totalArea;
	}
}
