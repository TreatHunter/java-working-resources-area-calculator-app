package org.treathunter.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.treathunter.calculation.Calculator;

public class MainPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JPanel ControlsPanel;
	
	JButton addElementBtn;
	JButton deleteElementBtn;
	
	JLabel plateAreaLb;
	JTextField plateAreaTF;
	JLabel plateCostLb;
	JTextField plateCostTF;
	
	JButton calculateBtn;
	JLabel plateAmountLb;
	JTextField plateAmountTF;
	JLabel CostLb;
	JTextField CostTF;
	JLabel areaLb;
	JTextField areaTF;
	JFrame frame;
	
	ElementsListPanel elementsListPnl;
	public MainPanel(JFrame frame) 
	{
		super();
		generateControlsPanel();
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		this.add(ControlsPanel);
		elementsListPnl = new ElementsListPanel();
		this.add(elementsListPnl);
		this.setPreferredSize(new Dimension(850,725));
	}
	
	public void generateControlsPanel() 
	{
		ControlsPanel = new JPanel();
		ControlsPanel.setBorder(BorderFactory.createTitledBorder("Управление"));
		addElementBtn = new JButton("добавить элемент");
		addElementBtn.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						elementsListPnl.addElement();
						
					}
			
				});
		deleteElementBtn = new JButton("удалить элемент");
		deleteElementBtn.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				elementsListPnl.deleteElement();
				
			}
	
		});
		
		plateAreaLb = new JLabel("площадь одной пластины мм^2:");
		plateAreaTF = new JTextField();
		plateAreaTF.setMaximumSize(new Dimension(150,10));
		plateCostLb = new JLabel("стоимость однго м^2 пластин стч. р");
		plateCostTF = new JTextField();
		plateCostTF.setMaximumSize(new Dimension(150,10));
		
		calculateBtn = new JButton("рассчитать");
		calculateBtn.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Calculator calc = new Calculator();
					try {
						calc.calculate(elementsListPnl.elementsList, plateCostTF.getText(), plateAreaTF.getText());
					} catch (Exception ex) 
					{
	            		JOptionPane.showMessageDialog(frame,
	                            ex.getMessage(),
	                            "Ошибка",
	                            JOptionPane.ERROR_MESSAGE);
					}
					plateAmountTF.setText(calc.getPlatesAmount().toString());
					CostTF.setText(calc.getTotalCost().toString());
					areaTF.setText(calc.getAreaWithoutHeight().toString());
				
			}
	
		});
		plateAmountLb = new JLabel("количество пластин:");
		plateAmountTF = new JTextField();
		plateAmountTF.setMaximumSize(new Dimension(150,10));
		CostLb = new JLabel("общая стоимость тсч.р:");
		CostTF = new JTextField();
		CostTF.setMaximumSize(new Dimension(150,10));
		areaLb = new JLabel("общая площадь мм:2:");
		areaTF = new JTextField();
		areaTF.setMaximumSize(new Dimension(150,10));
		
		GroupLayout layout = new GroupLayout(ControlsPanel);
		ControlsPanel.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup()
							.addComponent(addElementBtn)
							.addComponent(deleteElementBtn)
					)		
					.addGroup(layout.createParallelGroup()
							.addComponent(plateAreaLb)
							.addComponent(plateCostLb)
					)		
					.addGroup(layout.createParallelGroup()
							.addComponent(plateAreaTF)
							.addComponent(plateCostTF)
					)		
					.addGroup(layout.createParallelGroup()
							.addComponent(calculateBtn)
					)	
					.addGroup(layout.createParallelGroup()
							.addComponent(plateAmountLb)
							.addComponent(CostLb)
							.addComponent(areaLb)
					)
					.addGroup(layout.createParallelGroup()
							.addComponent(plateAmountTF)
							.addComponent(CostTF)
							.addComponent(areaTF)
					)
					
		);
		
		layout.setVerticalGroup(
				layout.createParallelGroup()
					.addGroup(layout.createSequentialGroup()
							.addComponent(addElementBtn)
							.addComponent(deleteElementBtn)
					)
					.addGroup(layout.createSequentialGroup()
							.addComponent(plateAreaLb)
							.addComponent(plateCostLb)
					)
					.addGroup(layout.createSequentialGroup()
							.addComponent(plateAreaTF)
							.addComponent(plateCostTF)
					)		
					.addGroup(layout.createSequentialGroup()
							.addComponent(calculateBtn)
					)					
					.addGroup(layout.createSequentialGroup()
							.addComponent(plateAmountLb)
							.addComponent(CostLb)
							.addComponent(areaLb)
					)	
					.addGroup(layout.createSequentialGroup()
							.addComponent(plateAmountTF)
							.addComponent(CostTF)
							.addComponent(areaTF)
					)	
		);
		//this.setMinimumSize(new Dimension(640,0));
		this.validate();
	}
}