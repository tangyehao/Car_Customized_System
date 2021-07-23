package cn.com.views;

import java.awt.Frame;

import javax.swing.JDialog;

import cn.com.utils.Center;

public class StatostocsView extends JDialog{
	PnlStatisticsView ba;
	public StatostocsView(){
		ba = new PnlStatisticsView(null);
		this.setSize(1240,650);
		this.add(ba);
		Center.centerByWindow(this);
		this.setVisible(true);
	}
	public StatostocsView(Frame f,String title,boolean bool){
		super(f, title, bool);
		ba = new PnlStatisticsView();
		this.setSize(800,600);
		this.add(ba);
		Center.centerByWindow(this);
		this.setVisible(true);
	}
}
