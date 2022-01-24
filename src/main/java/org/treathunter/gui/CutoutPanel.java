package org.treathunter.gui;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CutoutPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField lenghtTF;
	private JLabel lenghtLb;
	private JTextField widthTF;
	private JLabel widthLb;
	private JLabel orLb;
	private JTextField areaTF;
	private JLabel areaLb;
	
	public CutoutPanel()
	{
		super();
		this.setBorder(BorderFactory.createTitledBorder("вырез"));
		GroupLayout layout = new GroupLayout(this);
		lenghtTF = new JTextField();
		lenghtTF.setMaximumSize(new Dimension(100,30));
		lenghtTF.getDocument().addDocumentListener(new DocumentListener() 
		{
            private void changeAreaText() {
            	SwingUtilities.invokeLater(
            			() -> {
                        	areaTF.setText("");
                        	areaTF.update(areaTF.getGraphics());
            			}
            	);
            }

			@Override
			public void insertUpdate(DocumentEvent e) {
				changeAreaText();
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				changeAreaText();
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				changeAreaText();
				
			}
		});
		lenghtLb = new JLabel("длинна мм: ");
		
		widthTF = new JTextField();
		widthTF.setMaximumSize(new Dimension(100,30));
		widthTF.getDocument().addDocumentListener(new DocumentListener() 
		{
	                private void changeAreaText() {
	                	SwingUtilities.invokeLater(
	                			() -> {
		                        	areaTF.setText("");
		                        	areaTF.update(areaTF.getGraphics());
	                			}
	                	);
	                }

					@Override
					public void insertUpdate(DocumentEvent e) {
						changeAreaText();
						
					}

					@Override
					public void removeUpdate(DocumentEvent e) {
						changeAreaText();
						
					}

					@Override
					public void changedUpdate(DocumentEvent e) {
						changeAreaText();
						
					}
		});
		widthLb = new JLabel("ширина мм: ");
		
		orLb = new JLabel("или");		
		
		areaTF = new JTextField("",5);
		areaTF.setMaximumSize(new Dimension(100,30));
		areaTF.getDocument().addDocumentListener(new DocumentListener() 
		{
            private void changeLenghtWidthText() {
            	SwingUtilities.invokeLater(
            			() -> {
                        	widthTF.setText("");
                        	lenghtTF.setText("");
                        	widthTF.update(widthTF.getGraphics());
                        	lenghtTF.update(lenghtTF.getGraphics());
            			}
            	);
            }

			@Override
			public void insertUpdate(DocumentEvent e) {
				changeLenghtWidthText();
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				changeLenghtWidthText();
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				changeLenghtWidthText();
				
			}
		});
		areaLb = new JLabel("площадь м^2: ");		
		
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
							.addComponent(orLb)
					)		
					.addGroup(layout.createSequentialGroup()
							.addComponent(areaLb)
							.addComponent(areaTF)
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
							.addComponent(orLb)
					)		
					.addGroup(layout.createParallelGroup()
							.addComponent(areaLb)
							.addComponent(areaTF)
					)		
					
		);
		this.setMinimumSize(new Dimension(640,0));
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
	
	public String getAreaValue()
	{
		return areaTF.getText();
	}
}
