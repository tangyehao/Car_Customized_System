package cn.com.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


import cn.com.listeners.PnlStoreView_btnAllot_ActionListener;
import cn.com.listeners.PnlStoreView_btnSearch_ActionListener;
import cn.com.listeners.PnlStoreView_btnStat_ActionListener;
import cn.com.listeners.PnlStoreView_btnWare_ActionListener;
import cn.com.views.Systemview.BtnPartsView;

/*
库存管理类
 */

public class PnlStoreView extends JPanel{
	private MainView mv;
	
	private JPanel pnlMain;
	private JPanel pnlN;
	private JPanel pnlC;
	private JPanel pnlL;
	private JPanel pnlR;
	private JPanel pnlS;
	
	private JButton btnParts;
	private JButton btnWare;
	//private JButton btnCheck; //库存盘点按钮
	private JButton btnSearch;//库存查询
	private JButton btnAllot;//库存调拨
	
	private JLabel lblWare;
	private JLabel lblTitle;
	private JLabel lblImage;

	private JButton btnStat;
	
	public PnlStoreView(){
		pnlMain = new JPanel(new BorderLayout());
		
		btnStat = new JButton("库存成本统计");
		//btnCheck = new JButton("库存盘点");
		btnSearch = new JButton("库存查询");
		btnAllot = new JButton("库存调拨");
		btnParts = new JButton("配件信息");
		btnWare = new JButton("仓库设置");
		
		pnlN = new JPanel();
		pnlC = new JPanel(new BorderLayout());
		pnlL = new JPanel(null);
		pnlR = new JPanel(null);
		pnlS = new JPanel(null);
		
		lblTitle = new JLabel("库存管理");
		lblWare = new JLabel("仓库");
		lblImage = new JLabel(new ImageIcon("images/warehouse.png"));
		init();
	}
	
	public PnlStoreView(LayoutManager lm){
		super(lm);
		pnlMain = new JPanel(new BorderLayout());
		
		//btnCheck = new JButton("库存盘点");
		btnSearch = new JButton("库存查询");
		btnAllot = new JButton("库存调拨");
		btnParts = new JButton("配件信息");
		btnWare = new JButton("仓库设置");
		btnStat = new JButton("库存成本统计");
		
		pnlN = new JPanel();
		pnlC = new JPanel(new BorderLayout());
		pnlL = new JPanel(null);
		pnlR = new JPanel(null);
		pnlS = new JPanel(null);
		
		lblTitle = new JLabel("库存管理");
		lblWare = new JLabel("仓库");
		lblImage = new JLabel(new ImageIcon("images/warehouse.png"));
		init();
	}
	
	private void init() {
		// TODO Auto-generated method stub
		
		pnlN.setBorder(BorderFactory.createRaisedBevelBorder());
		pnlS.setBorder(BorderFactory.createRaisedBevelBorder());
		
		/*btnCheck.setBounds(250, 200, 100, 50);
		btnAllot.setBounds(600, 200, 100, 50);
		btnStock.setBounds(600, 300, 100, 50);*/
		
		//btnCheck.setFont(new Font("宋体",Font.BOLD,15));
		btnAllot.setFont(new Font("宋体",Font.BOLD,15));
		btnSearch.setFont(new Font("宋体",Font.BOLD,15));
		btnWare.setFont(new Font("宋体",Font.BOLD,15));
		btnParts.setFont(new Font("宋体",Font.BOLD,15));
		btnStat.setFont(new Font("宋体",Font.BOLD,15));
		
		lblWare.setFont(new Font("宋体",Font.BOLD,22));
		lblTitle.setFont(new Font("宋体",Font.BOLD,35));
		
		pnlN.setPreferredSize(new Dimension(900,80));
		pnlC.setPreferredSize(new Dimension(900,580));
		pnlL.setPreferredSize(new Dimension(450,580));
		pnlR.setPreferredSize(new Dimension(450,580));
		pnlS.setPreferredSize(new Dimension(900,120));
		
		btnAllot.setForeground(Color.BLUE);
		//btnCheck.setForeground(Color.BLUE);
		btnSearch.setForeground(Color.BLUE);
		btnWare.setForeground(Color.BLUE);
		btnParts.setForeground(Color.BLUE);
		btnStat.setForeground(Color.BLUE);
		
		lblWare.setForeground(Color.BLUE);
		lblTitle.setForeground(Color.RED);
		
		//库存查询按钮监听
		btnSearch.addActionListener(new PnlStoreView_btnSearch_ActionListener(this));
		
		//库存调拨按钮监听
		btnAllot.addActionListener(new PnlStoreView_btnAllot_ActionListener(this));
		
		//库存盘点按钮监听
		//btnCheck.addActionListener(new PnlStoreView_btnCheck_ActionListener(this));
		
		//仓库设置按钮监听
		btnWare.addActionListener(new PnlStoreView_btnWare_ActionListener(this));
		
		//配件信息按钮监听
		btnParts.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new BtnPartsView(new Frame(), "配件信息", true);
			}
		});
		
		//库存成本统计按钮监听
		btnStat.addActionListener(new PnlStoreView_btnStat_ActionListener(this));
		
		
		//btnCheck.setBounds(170, 150, 100, 50);
		btnSearch.setBounds(170, 150, 100, 50);
		btnAllot.setBounds(170, 310, 100, 50);
		btnWare.setBounds(250, 35, 100, 50);
		btnParts.setBounds(600, 35, 100, 50);
		btnStat.setBounds(415, 35, 120, 50);
		
		lblImage.setBounds(100,150,200,200);
		lblWare.setBounds(175,150,50,45);
		
		pnlN.add(lblTitle);
		//pnlR.add(btnCheck);
		pnlR.add(btnAllot);
		pnlR.add(btnSearch);
		pnlC.add(pnlL,BorderLayout.WEST);
		pnlC.add(pnlR,BorderLayout.EAST);
		pnlL.add(lblImage);
		pnlL.add(lblWare);
		pnlS.add(btnParts);
		pnlS.add(btnWare);
		pnlS.add(btnStat);
		
		this.add(pnlC,BorderLayout.CENTER);
		this.add(pnlN,BorderLayout.NORTH);
		this.add(pnlS,BorderLayout.SOUTH);
		//this.add(pnlMain);
		this.setVisible(true);
	}
}
