package cn.com.views.inventoryselectview;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


import cn.com.listeners.CloseView_ActionListener;
import cn.com.utils.Center;

public class btnSearchJFrame extends JDialog{
	
	private JPanel pnlMain;
	private JTabbedPane tapView;
	private btnSearch_WareChangePane bw;
	private btnSearch_PartsChangePane bp;
	
	public btnSearchJFrame(Frame f,String title ,Boolean bool){
		super(f,title,bool);
		pnlMain = new JPanel(new BorderLayout());
		tapView = new JTabbedPane();
		bw = new btnSearch_WareChangePane(new BorderLayout());
		bp = new btnSearch_PartsChangePane(new BorderLayout());
		
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(1000, 650);
		this.setResizable(false);
		
		Center.centerByWindow(this);
		
		pnlMain.add(tapView);
		
		bw.getBtnQuit().addActionListener(new CloseView_ActionListener(this) );
		
		tapView.add("库存变动情况",bw);
		tapView.add("配件变动情况",bp);
		
		this.add(pnlMain);
		this.setVisible(true);
	}
}
