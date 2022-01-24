package org.treathunter.gui;

import java.util.ArrayList;

import org.treathunter.calculation.CalculatorCutoutElement;
import org.treathunter.calculation.CalculatorElement;

class ObjectsConverter {
	
	ArrayList<CalculatorElement> convert(ArrayList<ElementPanel> elementsList) throws Exception{
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
}