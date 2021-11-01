package org.treathunter.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class CutoutsListPanelManager
{
	private JPanel pn;
	private JButton addCutoutBtn;
	private JButton deleteCutoutBtn;
	public ArrayList<CutoutPanel> cutoutsPnlList = new ArrayList<CutoutPanel>();
	public CutoutsListPanelManager()
	{
		pn = new JPanel();
		pn.setBorder(BorderFactory.createTitledBorder("вырезы"));
		pn.setLayout(new BoxLayout(pn,BoxLayout.PAGE_AXIS));
		addCutoutBtn = new JButton("добавить вырез");
		addCutoutBtn.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		addCutoutBtn.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				CutoutPanel cutPn = new CutoutPanel();
				cutoutsPnlList.add(cutPn);
				pn.add(cutPn);
				pn.add(Box.createRigidArea(new Dimension(5,5)));
				pn.updateUI();
			}
			
		});
		pn.add(Box.createRigidArea(new Dimension(5,5)));
		pn.add(addCutoutBtn);
		deleteCutoutBtn = new JButton("удалить вырез");
		deleteCutoutBtn.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		deleteCutoutBtn.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				if(cutoutsPnlList.size() == 0)
					return;
				cutoutsPnlList.get(cutoutsPnlList.size()-1).setVisible(false);
				cutoutsPnlList.remove(cutoutsPnlList.size()-1);
				//bag actually cutoutPanel is still in cutoutsListPanel so it will never be deleted by garbage collector
			}
			
		});
		pn.add(Box.createRigidArea(new Dimension(5,5)));
		pn.add(deleteCutoutBtn);		
		pn.add(Box.createRigidArea(new Dimension(5,5)));
	}
	
	public JPanel getCutoutsListPanel()
	{
		return pn;
	}
}
