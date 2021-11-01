package org.treathunter.gui;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ElementsListPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<ElementPanel> elementsList = new ArrayList<ElementPanel>();
	private JPanel insidePanel;
	private JScrollPane scroll;
	public ElementsListPanel()
	{
		this.setBorder(BorderFactory.createTitledBorder("элементы"));
		insidePanel = new JPanel();
		insidePanel.setLayout(new BoxLayout(insidePanel,BoxLayout.PAGE_AXIS));
		scroll = new JScrollPane();
		scroll.setViewportView(insidePanel);
		scroll.setPreferredSize(new Dimension(485,550));
		this.add(scroll);
		addElement();
		addElement();
		addElement();
		addElement();
		addElement();
		this.validate();
		this.updateUI();
	}
	
	public void addElement() 
	{
		ElementPanel pn = new ElementPanel();
		insidePanel.add(pn);
		elementsList.add(pn);
		scroll.setViewportView(insidePanel);
		this.revalidate();
		this.updateUI();
	}
	
	public void deleteElement()
	{
		if(elementsList.size() == 0)
			return;
		elementsList.get(elementsList.size()-1).setVisible(false);
		elementsList.remove(elementsList.size()-1);
		//bag actually cutoutPanel is still in cutoutsListPanel so it will never be deleted by garbage collector
	}
}
