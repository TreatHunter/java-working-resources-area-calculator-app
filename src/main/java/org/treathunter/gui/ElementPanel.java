package org.treathunter.gui;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class ElementPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ElementParametrsPanel elPn;
	public CutoutsListPanelManager cutsPnMng;
	public ElementPanel()
	{
		super();
		this.setBorder(BorderFactory.createTitledBorder("элемент"));
		this.setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
		elPn = new ElementParametrsPanel();
		this.add(elPn);
		this.add(Box.createRigidArea(new Dimension(5,5)));
		cutsPnMng = new CutoutsListPanelManager();
		this.add(cutsPnMng.getCutoutsListPanel());
	}
}
