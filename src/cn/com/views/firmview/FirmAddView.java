package cn.com.views.firmview;

import java.awt.Frame;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cn.com.listeners.CloseView_ActionListener;
import cn.com.listeners.FirmAddView_btnSave_ActionListenrt;
import cn.com.utils.Center;

public class FirmAddView extends JDialog{
	private JPanel pnlMain;

	
	private JLabel lblFirm;
	private JLabel lblPhone;
	private JLabel lblAddress;
	private JLabel lblNote;


	
	private JButton btnSave;
	private JButton btnQuit;

	
	private JTextField txtFirm;
	private JTextField txtPhone;
	private JTextField txtAddress;
	
	
	private JTextArea txtNote;
	private JScrollPane snpNote;

	
	public JTextField getTxtFirm() {
		return txtFirm;
	}

	public JTextField getTxtPhone() {
		return txtPhone;
	}

	public JTextField getTxtAddress() {
		return txtAddress;
	}

	public JTextArea getTxtNote() {
		return txtNote;
	}

	public FirmAddView(Frame f,String title,boolean bool){
		super(f,title,bool);
		
		txtNote = new JTextArea();
		snpNote = new JScrollPane(txtNote);
		
		pnlMain = new JPanel(null);

		txtFirm = new JTextField();
		txtPhone = new JTextField();
		txtAddress = new JTextField();
		
		
		lblFirm = new JLabel("供货商名称:");
		lblPhone = new JLabel("联系电话:");
		lblAddress = new JLabel("联系地址:");
		lblNote = new JLabel("备注:");
		
		btnSave = new JButton("保存");
		btnQuit = new JButton("退出");
		
	
		
		init();
	
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setResizable(false);
		this.setSize(400, 500);
			

		
		Center.centerByWindow(this);
		
//		lblNote.setFont(new Font("宋体",Font.BOLD,10));
//		lblFirm.setFont(new Font("宋体",Font.BOLD,10));
//		lblPhone.setFont(new Font("宋体",Font.BOLD,10));
//		lblAddress.setFont(new Font("宋体",Font.BOLD,10));
		

		lblFirm.setBounds(20, 25, 70, 30);
		lblPhone.setBounds(20, 70, 70, 30);
		lblAddress.setBounds(20, 115, 70, 30);
		lblNote.setBounds(20,160,70,30);
		
		txtFirm.setBounds(100, 25, 200, 30);
		txtPhone.setBounds(100, 70, 200, 30);
		txtAddress.setBounds(100, 115, 200, 30);
		
		snpNote.setBounds(100, 160, 200, 200);
		
		btnSave.setBounds(100, 420, 50, 30);
		btnQuit.setBounds(250, 420, 50, 30);
		
		pnlMain.add(txtFirm);
		pnlMain.add(txtPhone);
		pnlMain.add(txtAddress);
		
		pnlMain.add(lblFirm);
		pnlMain.add(lblAddress);
		pnlMain.add(lblNote);
		pnlMain.add(lblPhone);
		
		pnlMain.add(btnSave);
		pnlMain.add(btnQuit);
		
		pnlMain.add(snpNote);
		
		btnSave.addActionListener(new FirmAddView_btnSave_ActionListenrt(this));
		btnQuit.addActionListener(new CloseView_ActionListener(this));
		
		this.add(pnlMain);
		this.setVisible(true);
		
	}
}
