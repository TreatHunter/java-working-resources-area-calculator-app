package org.treathunter.gui;

import java.util.ArrayList;

import org.treathunter.calculation.CalculatorCutoutElement;
import org.treathunter.calculation.CalculatorElement;

class ObjectsConverter {
	
	ArrayList<CalculatorElement> convertElements(ArrayList<ElementPanel> elementsList) throws Exception{
		ArrayList<CalculatorElement> calculatorElementsList = new ArrayList<CalculatorElement>();
		ArrayList<CalculatorCutoutElement> cutoutsList;
		for(ElementPanel el : elementsList) {
			cutoutsList = new ArrayList<CalculatorCutoutElement>();
			for(CutoutPanel cut : el.cutsPnMng.cutoutsPnlList) {
				try
				{
					if(cut.getAreaValue().isEmpty()) {
						int lenght = Integer.parseInt(cut.getLenghtValue());
						int width = Integer.parseInt(cut.getWidthValue());
						cutoutsList.add(new CalculatorCutoutElement(lenght ,width));
					}
					else
					{
						double area  = Double.parseDouble(cut.getAreaValue());
						cutoutsList.add(new CalculatorCutoutElement(area));
					}
				}catch(NumberFormatException ex)
				{
					throw new Exception("в параметрах одного из вырезов находиться не целое число :" + ex.getMessage());
				}				
			}
			
			try
			{
				int elLength = Integer.parseInt(el.elPn.getLenghtValue());
				int elWidth = Integer.parseInt(el.elPn.getWidthValue());
				int elEdge = el.elPn.getEdgeLenghtValue();
				int elHem = Integer.parseInt(el.elPn.getHemLenghtValue());
				calculatorElementsList.add(new CalculatorElement(elLength,elWidth,elEdge,elHem,cutoutsList));
			}catch(NumberFormatException ex) {
				throw new Exception("в параметрах одного из элементов находиться не целое число :" + ex.getMessage());
			}
		}
		return calculatorElementsList;
	}
	
	double convertSheetCost(String costStr) throws Exception{
		double cost;
		try
		{
			cost = Double.parseDouble(costStr);
		}catch(NumberFormatException ex)
		{
			throw new Exception("цена указана не правильно :" + ex.getMessage());
		}
		
		return cost;
	}
	
	double convertSheetLength(String lengthStr) throws Exception{
		double length;
		try
		{
			length = Double.parseDouble(lengthStr);
		}catch(NumberFormatException ex)
		{
			throw new Exception("длинна листа указана не правильно :" + ex.getMessage());
		}
		
		return length;
	}
	
	double convertSheetWidth(String widthStr) throws Exception{
		double width;
		try
		{
			width = Double.parseDouble(widthStr);
		}catch(NumberFormatException ex)
		{
			throw new Exception("ширина листа указана не правильно :" + ex.getMessage());
		}
		
		return width;
	}
}