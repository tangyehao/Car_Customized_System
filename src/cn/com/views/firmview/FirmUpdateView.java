package cn.com.views.firmview;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cn.com.beans.Firm;
import cn.com.listeners.CloseView_ActionListener;
import cn.com.services.impl.FirmManageServiseImpl;
import cn.com.utils.Center;

public class FirmUpdateView extends JDialog{
	private FirmManageServiseImpl service;
	private FirmUpdateView fuv;
	private Firm firm;
	
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

	
	public FirmUpdateView(Frame f,String title,boolean bool,Firm firm){
		super(f,title,bool);
		service = new FirmManageServiseImpl();
		this.firm = firm;
		txtNote = new JTextArea();
		snpNote = new JScrollPane(txtNote);
		
		pnlMain = new JPanel(null);

		txtFirm = new JTextField();
		txtPhone = new JTextField();
		txtAddress = new JTextField();
		
		
		lblFirm = new JLabel("����������:");
		lblPhone = new JLabel("��ϵ�绰:");
		lblAddress = new JLabel("��ϵ��ַ:");
		lblNote = new JLabel("��ע:");
		
		btnSave = new JButton("����");
		btnQuit = new JButton("�˳�");
		
		fuv = this;
	
		
		init();
	
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setResizable(false);
		this.setSize(400, 500);
			

		
		Center.centerByWindow(this);
		
//		lblNote.setFont(new Font("����",Font.BOLD,10));
//		lblFirm.setFont(new Font("����",Font.BOLD,10));
//		lblPhone.setFont(new Font("����",Font.BOLD,10));
//		lblAddress.setFont(new Font("����",Font.BOLD,10));
		

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
		
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Update(e);
			}

			private void Update(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Firm fi = new Firm();
				fi.setfID(firm.getfID());
				String name = txtFirm.getText().trim();
				String phone = txtPhone.getText().trim();
				if(name.equals("")) {
					JOptionPane.showConfirmDialog(new Frame(), "��������Ϊ��", "��ʾ", JOptionPane.YES_NO_OPTION);
					return;
				}
				if(phone.length()!=11) {
					JOptionPane.showConfirmDialog(new Frame(), "������11λ�绰����", "��ʾ", JOptionPane.YES_NO_OPTION);
					return;
				}
				fi.setfName(name);
				fi.setfPhone(phone);
				fi.setfAddress(txtAddress.getText());
				fi.setfNote(txtNote.getText());
				service.firmUpdate(fi);
				int result = JOptionPane.showConfirmDialog(new Frame(), "�޸ĳɹ�", "��ʾ", JOptionPane.YES_NO_OPTION);
				fuv.dispose();
				FirmView.setTable(service.firmExport());
				
			}
		});
		btnQuit.addActionListener(new CloseView_ActionListener(this));
		
		this.add(pnlMain);
		this.setVisible(true);
		
	}
}
