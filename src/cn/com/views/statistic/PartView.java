package cn.com.views.statistic;

import javax.swing.*;

public class PartView  extends JDialog{
	private JPanel pnlPart;
	public PartView(){
		
		pnlPart = new JPanel();
		init();
	}

	private void init() {
		this.setBounds(0, 0, 500, 400);
		this.setVisible(true);
	}
}
