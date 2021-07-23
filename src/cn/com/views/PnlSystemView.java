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
ϵͳ������
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
		
		btnAcc = new JButton("�������");
		btnSup = new JButton("����������");
		btnCus = new JButton("�ͻ�����");
		btnCon = new JButton("��ͬ����");
		btnUser = new JButton("��Ա����");
		
		pnlN = new JPanel();
		pnlC = new JPanel(null);

		lblTitle = new JLabel("�ճ�����");
		lblImg = new JLabel(new ImageIcon("images/richang.png"));
		
		init();
	}
	
	public PnlSystemView(LayoutManager lm){
		super(lm);
		pnlMain = new JPanel(new BorderLayout());
		
		btnAcc = new JButton("�������");
		btnSup = new JButton("����������");
		btnCus = new JButton("�ͻ�����");
		btnCon = new JButton("�ֿ����");
		btnUser = new JButton("��Ա����");
		
		pnlN = new JPanel();
		pnlC = new JPanel(null);
		
		lblTitle = new JLabel("ϵͳ����");
		lblImg = new JLabel(new ImageIcon("images/richang.png"));
		
		init();
	}
	
	private void init() {
		// TODO Auto-generated method stub
		
		pnlN.setBorder(BorderFactory.createRaisedBevelBorder());
		
		
		btnAcc.setFont(new Font("����",Font.BOLD,15));
		btnSup.setFont(new Font("����",Font.BOLD,15));
		btnCus.setFont(new Font("����",Font.BOLD,15));
		btnCon.setFont(new Font("����",Font.BOLD,15));
		btnUser.setFont(new Font("����",Font.BOLD,15));
		
		lblTitle.setFont(new Font("����",Font.BOLD,35));
		
		pnlN.setPreferredSize(new Dimension(1000,80));
	    pnlC.setPreferredSize(new Dimension(1000,580));


		btnAcc.setForeground(Color.BLUE);
		btnSup.setForeground(Color.BLUE);
		btnCus.setForeground(Color.BLUE);
		btnCon.setForeground(Color.BLUE);
		btnUser.setForeground(Color.BLUE);
	
		lblTitle.setForeground(Color.RED);
		
	
		
		//�����Ϣ��ť����
		btnAcc.addActionListener(new PnlSystemView_btnParts_ActionListener(this));
		
		btnCus.addActionListener(new PnlSystemView_btnClient_ActionListener(this));
		btnSup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new FirmView(new Frame(), "��������Ϣ", true);
			}
		});

		btnCon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new BtnContractView(new Frame(), "��ͬ����",true);
			}
		});
		
		btnUser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new btnUserJDialog(new Frame(), "��ͬ����", true);
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
