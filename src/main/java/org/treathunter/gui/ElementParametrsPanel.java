package org.treathunter.gui;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ElementParametrsPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField lenghtTF;
	private JLabel lenghtLb;
	private JTextField widthTF;
	private JLabel widthLb;
	private JTextField edgeLenghtTF;
	private JLabel edgeLenghtLb;
	private JTextField hemLenghtTF;
	private JLabel hemLenghtLb;
	private JLabel hightLb;
	private Integer[] hightValues = {12,24,36,48,60,72,84,96,108,120,132,144,156,168,180}; //{"12","24","36","48","60","72","84","96","108","120","132","144","156","168","180"};
	private JComboBox<Integer> hightCmB;
	public ElementParametrsPanel()
	{
		super();
		this.setBorder(BorderFactory.createTitledBorder("параметры"));
		GroupLayout layout = new GroupLayout(this);
		lenghtLb = new JLabel("длинна: ");
		lenghtTF = new JTextField();
		lenghtTF.setMaximumSize(new Dimension(100,30));
		widthLb = new JLabel("ширина: ");
		widthTF = new JTextField();
		widthTF.setMaximumSize(new Dimension(100,30));
		hightLb = new JLabel("высота мм: ");
		hightCmB = new JComboBox<Integer>(hightValues);
		hightCmB.setMaximumSize(new Dimension(100,30));
		hightCmB.setSelectedIndex(1);
		edgeLenghtLb = new JLabel("длинна кромки: ");
		edgeLenghtTF = new JTextField();
		edgeLenghtTF.setMaximumSize(new Dimension(100,30));
		hemLenghtLb = new JLabel("длинна подгибки: ");
		hemLenghtTF = new JTextField();
		hemLenghtTF.setMaximumSize(new Dimension(100,30));

		this.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(
				layout.createParallelGroup()
					.addGroup(layout.createSequentialGroup()
							.addComponent(lenghtLb)
							.addComponent(lenghtTF)
					)
					.addGroup(layout.createSequentialGroup()
							.addComponent(widthLb)
							.addComponent(widthTF)
					)
					.addGroup(layout.createSequentialGroup()
							.addComponent(hightLb)
							.addComponent(hightCmB)
					)
					.addGroup(layout.createSequentialGroup()
							.addComponent(edgeLenghtLb)
							.addComponent(edgeLenghtTF)
					)
					.addGroup(layout.createSequentialGroup()
							.addComponent(hemLenghtLb)
							.addComponent(hemLenghtTF)
					)
					
		);
		layout.setVerticalGroup(
				layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup()
							.addComponent(lenghtLb)
							.addComponent(lenghtTF)
					)		
					.addGroup(layout.createParallelGroup()
							.addComponent(widthLb)
							.addComponent(widthTF)
					)			
					.addGroup(layout.createParallelGroup()
							.addComponent(hightLb)
							.addComponent(hightCmB)
					)	
					.addGroup(layout.createParallelGroup()
							.addComponent(edgeLenghtLb)
							.addComponent(edgeLenghtTF)
					)	
					.addGroup(layout.createParallelGroup()
							.addComponent(hemLenghtLb)
							.addComponent(hemLenghtTF)
					)	
					
		);
		this.setSize(new Dimension(640,500));
		this.validate();
	}
	public String getWidthValue()
	{
		return widthTF.getText();
	}
	
	public String getLenghtValue()
	{
		return lenghtTF.getText();
	}
	
	public String getEdgeLenghtValue()
	{
		return edgeLenghtTF.getText();
	}
	public String getHemLenghtValue()
	{
		return hemLenghtTF.getText();
	}
	public int getHeightValue()
	{
		return hightValues[hightCmB.getSelectedIndex()];
	}
}
