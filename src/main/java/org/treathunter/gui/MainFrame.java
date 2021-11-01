package org.treathunter.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame
{
	JFrame fr;
	private JButton btn;
	
	public MainFrame()
	{
		fr = new JFrame("made by TreatHunter");
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setResizable(false);
		MainPanel pn = new MainPanel(fr);
		fr.add(pn);
		fr.setVisible(true);
		fr.setLocation(500,0);
		fr.pack();
	}
}
