package cn.com.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import cn.com.beans.User;
import cn.com.listeners.*;
import cn.com.utils.Center;
/*
主界面类
 */
public class MainView extends JFrame{
	private JPanel pnlMain;
    private JPanel pnlN;
    private JPanel pnlS;
    private JPanel pnlE;
    private JPanel pnlW;
    private JPanel pnlC;
    
    private JPanel pnlSell;
    private JPanel pnlDaliy ;
    private JPanel pnlSystem ;

    private JLabel lblMsg;
    
    private PnlStoreView ps;
    private PnlPurchaseView pp;
    private pnlSellView psell;
    private PnlSystemView psv;
   
    private JButton btnPurchase;
    private JButton btnSell;
    private JButton btnStore;
    private JButton btnStatics;
    private JButton btnDaily;
    private JButton btnchange;
    private JButton btnExit;
    private JButton btnRemind;
    private JButton btnGroupNote;
    private JButton btnHelp;
    private JButton btnBuy;

    private User user;
	private PnlStatisticsView pnlStatistics;

    private MainView mv;
    public MainView(){
		
		pp = new PnlPurchaseView(new BorderLayout());
		ps = new PnlStoreView(new BorderLayout());
		psell = new pnlSellView(new BorderLayout());
		psv = new PnlSystemView();
		
    	pnlMain = new JPanel(new BorderLayout());
		pnlN = new JPanel(null);
		pnlS = new JPanel(null);
		pnlC = new JPanel(null);
		pnlE = new JPanel(null);
		pnlW = new JPanel(null);

	
		pnlSell = new JPanel();
		pnlDaliy = new JPanel();
		pnlSystem = new JPanel();
		
		mv = this;
		pnlStatistics = new PnlStatisticsView(new BorderLayout());
	
		btnPurchase = new JButton("进货管理");
		btnSell = new JButton("销售管理");
		btnStore = new JButton("库存管理");
		btnStatics = new JButton("统计报表");
		btnDaily = new JButton("日常管理");
		
		btnchange = new JButton("换班管理");
		btnRemind = new JButton("今日提醒");
	    btnGroupNote = new JButton("短信群发");
	    btnHelp = new JButton("软件帮助");
	    btnBuy = new JButton("软件购买");
		btnExit = new JButton("退出");
		init();
    }
	public MainView(User user){
		this.user = user;
		pp = new PnlPurchaseView(new BorderLayout());
		ps = new PnlStoreView(new BorderLayout());
		psell = new pnlSellView(new BorderLayout());
		psv = new PnlSystemView();
		
    	pnlMain = new JPanel(new BorderLayout());
		pnlN = new JPanel(null);
		pnlS = new JPanel(null);
		pnlC = new JPanel(null);
		pnlE = new JPanel(null);
		pnlW = new JPanel(null);

		lblMsg = new JLabel("当前操作员:"+user.getuName()+"("+user.getuJob()+")");
	
		pnlSell = new JPanel();
		pnlDaliy = new JPanel();
		pnlSystem = new JPanel();
		
		mv = this;
		pnlStatistics = new PnlStatisticsView(new BorderLayout());
	
		btnPurchase = new JButton("进货管理");
		btnSell = new JButton("销售管理");
		btnStore = new JButton("库存管理");
		btnStatics = new JButton("统计报表");
		btnDaily = new JButton("日常管理");
		
		btnchange = new JButton("换班管理");
		btnRemind = new JButton("今日提醒");
	    btnGroupNote = new JButton("短信群发");
	    btnHelp = new JButton("软件帮助");
	    btnBuy = new JButton("软件购买");
		btnExit = new JButton("退出");
		init();
    }

	public PnlStatisticsView getPnlStatistics() {
		return pnlStatistics;
	}

	public void setPnlStatistics(PnlStatisticsView pnlStatistics) {
		this.pnlStatistics = pnlStatistics;
	}

	public PnlSystemView getPsv(){
		return psv;
	}
	public PnlPurchaseView getPp() {
		return pp;
	}

	public pnlSellView getPSell() {
		return psell;
	}

	public PnlStoreView getPs() {
		return ps;
	}

	public JButton getBtnPurchase() {
		return btnPurchase;
	}

	public JPanel getPnlC() {
		return pnlC;
	}

	public JButton getBtnStatics() {
		return btnStatics;
	}

	public JPanel getPnlMain() {
		return pnlMain;
	}

	private void init() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1400, 800);
		pnlN.setPreferredSize(new Dimension(1400, 100));
		pnlC.setPreferredSize(new Dimension(1240, 650));
		pnlW.setPreferredSize(new Dimension(200, 150));
		pnlW.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 4, Color.YELLOW));
		
		Center.centerByWindow(this);
		
		btnchange.setBounds(100, 10, 100, 50);
		btnRemind.setBounds(300, 10, 100, 50);
		btnHelp.setBounds(500, 10, 100, 50);
		btnBuy.setBounds(700, 10, 100, 50);
		btnGroupNote.setBounds(900, 10, 100, 50);
		btnExit.setBounds(1100, 10, 100, 50);
		
		btnPurchase.setBounds(40, 40, 100, 50);
		btnSell.setBounds(40, 140, 100, 50); 
		btnStore.setBounds(40, 240, 100, 50); 
		btnStatics.setBounds(40, 340, 100, 50); 
		btnDaily .setBounds(40, 440, 100, 50); 

		lblMsg.setBounds(10,630,200,25);
		lblMsg.setFont(new Font("宋体",Font.BOLD,13));
		lblMsg.setForeground(Color.RED);

		btnPurchase.setFont(new Font("宋体",Font.BOLD,15));
		btnRemind.setFont(new Font("宋体",Font.BOLD,15));
		btnHelp.setFont(new Font("宋体",Font.BOLD,15));
		btnBuy.setFont(new Font("宋体",Font.BOLD,15));
		btnGroupNote.setFont(new Font("宋体",Font.BOLD,15));
		btnExit.setFont(new Font("宋体",Font.BOLD,15));
		btnSell.setFont(new Font("宋体",Font.BOLD,15));
		btnStore.setFont(new Font("宋体",Font.BOLD,15));
		btnchange.setFont(new Font("宋体",Font.BOLD,15));
		btnStatics.setFont(new Font("宋体",Font.BOLD,15));
		btnDaily.setFont(new Font("宋体",Font.BOLD,15));

		
		btnPurchase.addActionListener(new MainView_BtnPurchase_ActionListener(this,user));//进货管理监听
		btnSell.addActionListener(new MainView_BtnSell_ActionListener(this,user));
		btnStore.addActionListener(new MainView_BtnStore_ActionListener(this,user));//库存管理按钮监听
		btnStatics.addActionListener(new MainView_BtnStatics_ActionListener(this,user));
		btnchange.addActionListener(new MainView_BtnChange_ActionListener(this));
		btnExit.addActionListener(new CloseView_ActionListener(this));
		btnDaily.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(user.getuJob().equals("管理员")){
					mv.getPs().setVisible(false);
					mv.getPp().setVisible(false);
					mv.getPSell().setVisible(false);
					mv.getPsv().setVisible(false);
					mv.getPnlMain().add(mv.getPsv(),BorderLayout.CENTER);
					mv.getPsv().setVisible(true);
				}else{
					JOptionPane.showMessageDialog(mv,"您没有权限操作","错误",JOptionPane.ERROR_MESSAGE);
					return;
				}

			}
		});
		
		pnlMain.add(pnlN,BorderLayout.NORTH);
		//pnlMain.add(pnlC,BorderLayout.CENTER);
		pnlMain.add(pnlW,BorderLayout.WEST);
		
		this.pnlN.setBorder(BorderFactory.createRaisedBevelBorder());
		//this.pnlC.setBorder(BorderFactory.createRaisedBevelBorder());
		
		pnlN.add(btnchange);
		pnlN.add(btnRemind);
		pnlN.add(btnGroupNote);
		pnlN.add(btnHelp);
		pnlN.add(btnBuy);
		pnlN.add(btnExit);	
		pnlW.add(btnPurchase);
		pnlW.add(btnSell);
		pnlW.add(btnStore);
		pnlW.add(btnStatics);
		pnlW.add(btnDaily);
		pnlW.add(lblMsg);
	/*	pnlC.add(pnlPurchase);
		pnlC.add(pnlSell);*/
		
		
		
		this.add(pnlMain);
		this.setVisible(true);
	}
}

	

