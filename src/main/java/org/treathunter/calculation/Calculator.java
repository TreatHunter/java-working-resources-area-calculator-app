package org.treathunter.calculation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import org.treathunter.gui.CutoutPanel;
import org.treathunter.gui.ElementPanel;
import org.treathunter.gui.ElementParametrsPanel;

public class Calculator {
	public final static int PLATE_HEIGHT_IN_MM = 12;
	private ArrayList<ElementPanel> elementsList;
	private double area;
	private double areaInMetersSquare;
	private double areaWithoutCutouts;
	private double areaWithoutHeight;
	private double areaWithoutHeightAndCutouts;
	private double squareMeterCost;
	private double Totalcost;
	private double plateArea;
	private double platesAmount;
	
	public void calculate(ArrayList<ElementPanel> elementsList,String squareMeterCost,String plateArea) throws Exception {
		this.elementsList = elementsList;
		try
		{
			this.squareMeterCost = Double.parseDouble(squareMeterCost);
		}catch(NumberFormatException ex) {
			throw new Exception("цена не является числом с плавающей точкой :" + ex.getMessage());
		}
		
		try
		{
			this.plateArea = Double.parseDouble(plateArea);
		}catch(NumberFormatException ex) {
			throw new Exception("площадь плиты не является числом с плавающей точкой :" + ex.getMessage());
		}		

		calculateAreas();
		calculateTotalCost();
		calculateAmountOfPlates();
	}
	
	public void calculateAmountOfPlates() 
	{
		platesAmount = new BigDecimal(areaWithoutCutouts / plateArea).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
	
	public void calculateTotalCost()
	{
		Totalcost = new BigDecimal(areaInMetersSquare * squareMeterCost).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
	
	public void calculateAreas() throws Exception {
		if(elementsList.equals(null) | elementsList.size() == 0)
		{
			throw new Exception("Cписок элементов пуст");
		}
		area = 0;
		areaInMetersSquare = 0;
		areaWithoutCutouts = 0;
		areaWithoutHeight = 0;
		areaWithoutHeightAndCutouts = 0;
		for(ElementPanel elPnl : elementsList) {
			double currientElAreaWithoutHeightAndCutouts = 0;
			ElementParametrsPanel elParams= elPnl.elPn;
			try
			{
				currientElAreaWithoutHeightAndCutouts+= (Integer.parseInt(elParams.getLenghtValue()) +Integer.parseInt(elParams.getEdgeLenghtValue()) +Integer.parseInt(elParams.getHemLenghtValue()))*Integer.parseInt(elParams.getWidthValue());
			}catch(NumberFormatException ex) {
				throw new Exception("в параметрах одного из элементов находиться не целое число :" + ex.getMessage());
			}
			int cutoutsArea = 0;
			ArrayList<CutoutPanel> coutoutPanelList =  elPnl.cutsPnMng.cutoutsPnlList;
			for(CutoutPanel cutoutEl : coutoutPanelList)
			{
				if(cutoutEl.getAreaValue().isEmpty())
				{
					try
					{
						cutoutsArea+= Integer.parseInt(cutoutEl.getLenghtValue()) *Integer.parseInt(cutoutEl.getWidthValue());
					}catch(NumberFormatException ex)
					{
						throw new Exception("в параметрах одного из вырезов находиться не целое число :" + ex.getMessage());
					}
				}else
				{
					try
					{
						cutoutsArea+= Integer.parseInt(cutoutEl.getAreaValue());
					}catch(NumberFormatException ex)
					{
						throw new Exception("в параметрах одного из вырезов находиться не целое число :" + ex.getMessage());
					}
				}
			}
			double currientElAreaWithoutHeight = currientElAreaWithoutHeightAndCutouts - cutoutsArea;
			if(currientElAreaWithoutHeight <= 0)
			{
				throw new Exception("в одном элементе площадь вырезов больше площади элемента ");
			}
			area += (elParams.getHeightValue() / Calculator.PLATE_HEIGHT_IN_MM) * currientElAreaWithoutHeight; 
			areaWithoutCutouts += (elParams.getHeightValue() / Calculator.PLATE_HEIGHT_IN_MM) * currientElAreaWithoutHeightAndCutouts ;
			areaWithoutHeight += currientElAreaWithoutHeight;
			areaWithoutHeightAndCutouts += currientElAreaWithoutHeightAndCutouts;
		}
		areaInMetersSquare = new BigDecimal(area / 1000000).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
	
	public Double getTotalCost()
	{
		return Totalcost;
	}
	
	public Double getPlatesAmount()
	{
		return platesAmount;
	}
	
	public Double getAreaWithoutHeight()
	{
		return areaWithoutHeight;
	}
}
