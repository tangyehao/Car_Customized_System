package cn.com.views.firmview;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;


import java.util.List;
import java.util.Vector;


import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.table.DefaultTableModel;

import cn.com.beans.Firm;

import cn.com.listeners.*;
import cn.com.services.impl.FirmManageServiseImpl;
import cn.com.utils.Center;


public class FirmView extends JDialog{
	
	private JPanel pnlMain;
	private JPanel pnlN;
	private JPanel pnlC;

	
	private JLabel lblAdd;
	private JLabel lblUpdate;
	private JLabel lblDelete;
	private JLabel lblSelect;
	private JLabel lblQuit;

	
	private JButton btnPartsAdd;

	
	private JTextField txtSelect;

	
	private JScrollPane snpInfo;
	public static JTable tabParts;
	public static DefaultTableModel tmdParts;
	
	private FirmManageServiseImpl service;

	
	public FirmView(Frame f,String title,boolean bool){
		super(f,title,bool);
		
		service = new FirmManageServiseImpl();
		
		tabParts = new JTable(){
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		
		snpInfo = new JScrollPane(tabParts);
		
		pnlMain = new JPanel(new BorderLayout());
		pnlN = new JPanel(null);
		pnlC = new JPanel(null);

		
		lblAdd = new JLabel(new ImageIcon("images/Add.png"));
		lblUpdate = new JLabel(new ImageIcon("images/Update.png"));
		lblDelete = new JLabel(new ImageIcon("images/Delete.png"));
		lblSelect = new JLabel("请输入供货商名称:");
		lblQuit = new JLabel(new ImageIcon("images/Quit.png"));

		
		btnPartsAdd = new JButton("查询");

		txtSelect = new JTextField();
	
		
		init();
	
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setResizable(false);
		this.setSize(1000, 650);
		
		
		setTable(service.firmExport());
		
		
		pnlN.setPreferredSize(new Dimension(1000,200));//北面板大小
		pnlC.setPreferredSize(new Dimension(1000,450));

		
		Center.centerByWindow(this);
		
		pnlMain.add(pnlN,BorderLayout.NORTH);
		pnlMain.add(pnlC,BorderLayout.CENTER);
		
		lblSelect.setFont(new Font("宋体",Font.BOLD,15));
		

		lblAdd.setBounds(40, 25, 55, 65);
		lblUpdate.setBounds(140, 25, 55, 65);
		lblDelete.setBounds(240, 25, 55, 65);
		lblQuit.setBounds(340, 25, 55, 65);
		
		
		btnPartsAdd.setBounds(850, 150, 60, 30);
		txtSelect.setBounds(300, 150, 500, 30);
		lblSelect.setBounds(100,150,200,30);



		snpInfo.setBounds(0, 0, 1000, 450);
		
		
		pnlN.add(lblAdd);
		pnlN.add(lblDelete);
		pnlN.add(lblQuit);
		pnlN.add(lblSelect);
		pnlN.add(lblUpdate);
		pnlN.add(txtSelect);
		pnlN.add(btnPartsAdd);
		
		pnlC.add(snpInfo);
		
		//lblQuit.addAncestorListener((AncestorListener) new CloseView_ActionListener(this));
		lblAdd.addMouseListener(new FirmInfoAddView_MouseListener(this));
		lblUpdate.addMouseListener(new FirmInfoUpdateView_MouseListener(this));
		lblDelete.addMouseListener(new FirmInfoDeleteView_MouseListener(this));
		lblQuit.addMouseListener( new CloseView_ActionListener(this));
		btnPartsAdd.addActionListener(new FirmInfoSelect_Actionlistener(this));
		
		
		this.add(pnlMain);
		this.setVisible(true);
		
	}

	public JTextField getTxtSelect() {
		return txtSelect;
	}

	public static JTable getTabParts() {
		return tabParts;
	}

	public static void setTable(List<Firm> list) {
		// TODO Auto-generated method stub
		Vector<String> colNames = new Vector<String>();
		colNames.add("供货商名称");
		colNames.add("联系电话");
		colNames.add("地址");
		colNames.add("备注");
		
		Vector<Vector> datas = new Vector();
		Vector row = null;
		for(Firm f:list){
			row = new Vector();
			row.add(f);
			row.add(f.getfPhone());
			row.add(f.getfAddress());
			row.add(f.getfNote());
			datas.add(row);
		}
		
		tmdParts = new DefaultTableModel(datas,colNames);
		tabParts.setModel(tmdParts);
		
	}
}
