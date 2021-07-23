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

import cn.com.listeners.PnlSystemView_btnClient_ActionListener;
import cn.com.listeners.PnlSystemView_btnParts_ActionListener;
import cn.com.views.Systemview.BtnContractView;
import cn.com.views.Systemview.btnUserJDialog;
import cn.com.views.firmview.FirmView;


/*
系统设置类
 */

public class PnlSystemView extends JPanel {
	private MainView mv;
	
	private JPanel pnlMain;
	private JPanel pnlN;
	private JPanel pnlC;
	
	private JButton btnAcc;
	private JButton btnSup;
	private JButton btnCus;
	private JButton btnCon;
	private JButton btnUser;
	
	private JLabel lblTitle;
	private JLabel lblImg;

	
	public PnlSystemView(){
		pnlMain = new JPanel(new BorderLayout());
		
		btnAcc = new JButton("配件管理");
		btnSup = new JButton("供货商设置");
		btnCus = new JButton("客户设置");
		btnCon = new JButton("合同管理");
		btnUser = new JButton("人员管理");
		
		pnlN = new JPanel();
		pnlC = new JPanel(null);

		lblTitle = new JLabel("日常管理");
		lblImg = new JLabel(new ImageIcon("images/richang.png"));
		
		init();
	}
	
	public PnlSystemView(LayoutManager lm){
		super(lm);
		pnlMain = new JPanel(new BorderLayout());
		
		btnAcc = new JButton("配件管理");
		btnSup = new JButton("供货商设置");
		btnCus = new JButton("客户设置");
		btnCon = new JButton("仓库管理");
		btnUser = new JButton("人员管理");
		
		pnlN = new JPanel();
		pnlC = new JPanel(null);
		
		lblTitle = new JLabel("系统设置");
		lblImg = new JLabel(new ImageIcon("images/richang.png"));
		
		init();
	}
	
	private void init() {
		// TODO Auto-generated method stub
		
		pnlN.setBorder(BorderFactory.createRaisedBevelBorder());
		
		
		btnAcc.setFont(new Font("宋体",Font.BOLD,15));
		btnSup.setFont(new Font("宋体",Font.BOLD,15));
		btnCus.setFont(new Font("宋体",Font.BOLD,15));
		btnCon.setFont(new Font("宋体",Font.BOLD,15));
		btnUser.setFont(new Font("宋体",Font.BOLD,15));
		
		lblTitle.setFont(new Font("宋体",Font.BOLD,35));
		
		pnlN.setPreferredSize(new Dimension(1000,80));
	    pnlC.setPreferredSize(new Dimension(1000,580));


		btnAcc.setForeground(Color.BLUE);
		btnSup.setForeground(Color.BLUE);
		btnCus.setForeground(Color.BLUE);
		btnCon.setForeground(Color.BLUE);
		btnUser.setForeground(Color.BLUE);
	
		lblTitle.setForeground(Color.RED);
		
	
		
		//配件信息按钮监听
		btnAcc.addActionListener(new PnlSystemView_btnParts_ActionListener(this));
		
		btnCus.addActionListener(new PnlSystemView_btnClient_ActionListener(this));
		btnSup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new FirmView(new Frame(), "供货商信息", true);
			}
		});

		btnCon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new BtnContractView(new Frame(), "合同管理",true);
			}
		});
		
		btnUser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new btnUserJDialog(new Frame(), "合同管理", true);
			}
		});
				

		btnAcc.setBounds(220, 200, 100, 50);
		btnSup.setBounds(220, 300, 100, 50);
		btnCus.setBounds(220, 400, 100, 50);
		btnCon.setBounds(700, 200, 100, 50);
		btnUser.setBounds(700, 300, 100, 50);
		
		lblImg.setBounds(350, 50, 320, 400);
	
		pnlN.add(lblTitle);
		pnlC.add(lblImg);

		pnlC.add(btnAcc);
		pnlC.add(btnSup);
		pnlC.add(btnCus);
		pnlC.add(btnCon);
		pnlC.add(btnUser);
		
		this.add(pnlN,BorderLayout.NORTH);
		this.add(pnlC,BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
}
