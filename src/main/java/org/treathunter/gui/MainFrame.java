package org.treathunter.gui;

import javax.swing.JFrame;

public class MainFrame
{
	JFrame fr;
	
	public MainFrame()
	{
		fr = new JFrame("DS: Di Stone");
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setResizable(false);
		MainPanel pn = new MainPanel(fr);
		fr.add(pn);
		fr.setVisible(true);
		fr.setLocation(500,0);
		fr.pack();
	}
}
