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

import cn.com.listeners.FirmInfoView_ActionListener;
import cn.com.listeners.PnlPurchaseView_btnBack_ActionListen;
import cn.com.listeners.PnlPurchaseView_btnSearch_ActionListen;
import cn.com.listeners.PnlPurchaseView_btnStock_ActionListen;
import cn.com.views.Systemview.BtnPartsView;
import cn.com.views.Systemview.btnUserJDialog;
import cn.com.views.inventoryselectview.btnSearchJFrame;
import cn.com.views.sellview.btnAccount_JDialog;
import cn.com.views.statistic.Billreaserch_View;
import cn.com.views.warehouseview.btnWareJDialog;

/*
���۽�����
 */

public class PnlPurchaseView extends JPanel{
	
	private JPanel pnlN;
	private JPanel pnlC;
	private JPanel pnlL;
	private JPanel pnlR;
	private JPanel pnlS;
	
	//�·��Ŀؼ�
	private JButton btnParts;
	private JButton btnWare;
	private JButton btnUser;
	private JButton btnFirm;
	
	//�м�Ŀؼ�
	private JButton btnStock; 
	private JButton btnSearch;
	private JButton btnBack;
	private JButton btnBill;
	private JButton btnWarehouse;
	
	private JLabel lblWare;
	private JLabel lblTitle;
	private JLabel lblImage;
	
	
	public JButton getBtnFirm() {
		return btnFirm;
	}

	public PnlPurchaseView(){
		//pnlMain = new JPanel(new BorderLayout());
		btnStock = new JButton("�ɹ�����");
		btnSearch = new JButton("���ݲ�ѯ");
		btnBack = new JButton("�ɹ��˻�");
		btnBill = new JButton("��������");
		btnWarehouse = new JButton("��ǰ���");
		
		btnUser = new JButton("�û���Ϣ");
		btnFirm = new JButton("������Ϣ");
		btnParts = new JButton("�����Ϣ");
		btnWare = new JButton("�ֿ�����");
		
		pnlN = new JPanel();
		pnlC = new JPanel(new BorderLayout());
		pnlL = new JPanel(null);
		pnlR = new JPanel(null);
		pnlS = new JPanel(null);
		lblTitle = new JLabel("��������");
		lblWare = new JLabel("����ɹ�");
		lblImage = new JLabel(new ImageIcon("images/Stock.png"));
		init();
	}
	
	public PnlPurchaseView(LayoutManager lm){
		super(lm);
		
		
		
		btnStock = new JButton("�ɹ�����");
		btnSearch = new JButton("���ݲ�ѯ");
		btnBack = new JButton("�ɹ��˻�");
		btnBill = new JButton("��������");
		btnWarehouse = new JButton("��ǰ���");
		
		btnUser = new JButton("�û���Ϣ");
		btnFirm = new JButton("������Ϣ");
		btnParts = new JButton("�����Ϣ");
		btnWare = new JButton("�ֿ�����");
		
		pnlN = new JPanel();
		pnlC = new JPanel(new BorderLayout());
		pnlL = new JPanel(null);
		pnlR = new JPanel(null);
		pnlS = new JPanel(null);
		lblTitle = new JLabel("��������");
		lblWare = new JLabel("����ɹ�");
		lblImage = new JLabel(new ImageIcon("images/Stock.png"));
		init();
	}
	
	private void init() {
		// TODO Auto-generated method stub
		
		pnlN.setBorder(BorderFactory.createRaisedBevelBorder());
		pnlS.setBorder(BorderFactory.createRaisedBevelBorder());
		
		/*btnStock.setBounds(250, 200, 100, 50);
		btnBack.setBounds(600, 200, 100, 50);
		btnStock.setBounds(600, 300, 100, 50);*/
		
		btnStock.setFont(new Font("����",Font.BOLD,15));
		btnBack.setFont(new Font("����",Font.BOLD,15));
		btnSearch.setFont(new Font("����",Font.BOLD,15));
		lblTitle.setFont(new Font("����",Font.BOLD,35));
		btnWare.setFont(new Font("����",Font.BOLD,15));
		btnParts.setFont(new Font("����",Font.BOLD,15));
		lblWare.setFont(new Font("����",Font.BOLD,22));
		btnBill.setFont(new Font("����",Font.BOLD,15));
		btnWarehouse.setFont(new Font("����",Font.BOLD,15));
		btnFirm.setFont(new Font("����",Font.BOLD,15));
		btnUser.setFont(new Font("����",Font.BOLD,15));
		
		pnlN.setPreferredSize(new Dimension(900,80));
		pnlC.setPreferredSize(new Dimension(900,580));
		pnlL.setPreferredSize(new Dimension(450,580));
		pnlR.setPreferredSize(new Dimension(450,580));
		pnlS.setPreferredSize(new Dimension(900,120));
		
		
		lblTitle.setForeground(Color.RED);
		btnBack.setForeground(Color.BLUE);
		btnStock.setForeground(Color.BLUE);
		btnSearch.setForeground(Color.BLUE);
		btnWare.setForeground(Color.BLUE);
		btnParts.setForeground(Color.BLUE);
		lblWare.setForeground(Color.BLUE);
		btnBill.setForeground(Color.BLUE);
		btnWarehouse.setForeground(Color.BLUE);
		btnFirm.setForeground(Color.BLUE);
		btnUser.setForeground(Color.BLUE);
		

		btnWarehouse.setBounds(170, 80, 100, 50);
		btnStock.setBounds(170, 160, 100, 50);
		btnSearch.setBounds(170, 240, 100, 50);
		btnBill.setBounds(170, 320, 100, 50);
		btnBack.setBounds(170, 400, 100, 50);
		lblImage.setBounds(100,150,350,250);
		lblWare.setBounds(200,100,100,55);
		
		btnUser.setBounds(600, 35, 100, 50);
		btnFirm.setBounds(400, 35, 100, 50);
		btnWare.setBounds(200, 35, 100, 50);
		btnParts.setBounds(800, 35, 100, 50);
		
		
		
		pnlN.add(lblTitle);
		pnlR.add(btnBill);
		pnlR.add(btnWarehouse);
		pnlR.add(btnStock);
		pnlR.add(btnBack);
		pnlR.add(btnSearch);
		pnlC.add(pnlL,BorderLayout.WEST);
		pnlC.add(pnlR,BorderLayout.EAST);
		pnlL.add(lblImage);
		pnlL.add(lblWare);
		pnlS.add(btnUser);
		pnlS.add(btnFirm);
		pnlS.add(btnParts);
		pnlS.add(btnWare);
		
		this.add(pnlC,BorderLayout.CENTER);
		this.add(pnlN,BorderLayout.NORTH);
		this.add(pnlS,BorderLayout.SOUTH);
		
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Billreaserch_View();
			}
		});
		btnStock.addActionListener(new PnlPurchaseView_btnStock_ActionListen(this));
		btnBack.addActionListener(new PnlPurchaseView_btnBack_ActionListen(this));
		btnFirm.addActionListener(new FirmInfoView_ActionListener(this));
		
		btnParts.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new BtnPartsView(new Frame(), "�����Ϣ", true);
			}
		});
		btnUser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new btnUserJDialog(new Frame(), "�û���Ϣ", true);
			}
		});
		btnBill.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new btnAccount_JDialog(new Frame(),"��������",true);
			}
		});
		btnWarehouse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new btnSearchJFrame(new Frame(), "����ѯ", true);
			}
		});
		btnWare.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new btnWareJDialog(new Frame(), "�ֿ�����", true);
			}
		});
	}
}
