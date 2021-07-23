package cn.com.views.Systemview;

import cn.com.beans.Client;
import cn.com.listeners.CloseView_ActionListener;
import cn.com.services.ClientInfoServiceInf;
import cn.com.services.impl.ClientInfoServiceImpl;
import cn.com.utils.Center;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BtnUpdateClientView extends JDialog {
	private JPanel pnlMain;
	
	private JLabel lblId;
	private JLabel lblName;
	private JLabel lblAddress;
	private JLabel lblPhone;
	private JLabel lblNote;
	
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JTextField txtNote;
	
	
	private JButton btnSave;
	private JButton btnExit;
	
	private Client cb;
	private BtnClientView bcv;
	private ClientInfoServiceInf service;
	
	public BtnUpdateClientView(Dialog owner, String title, boolean model, Client cb) {
		// TODO Auto-generated constructor stub
		super(owner,title,model);
		bcv = (BtnClientView)owner;
		this.cb = cb;
		pnlMain = new JPanel(null);
		
		lblId = new JLabel("客户ID：");
		lblName = new JLabel("客户名称：");
		lblAddress = new JLabel("地址：");
		lblPhone = new JLabel("电话：");
		lblNote = new JLabel("备    注：");
		
		txtId = new JTextField(cb.toString());
		txtName = new JTextField(cb.getcName());
		txtAddress = new JTextField(cb.getcAddress());
		txtPhone = new JTextField(cb.getcPhone());
		txtNote = new JTextField(cb.getcNote());
		
		txtId.setEnabled(false);
		
		btnSave = new JButton("保存");
		btnExit = new JButton("退出");
		
		service = new ClientInfoServiceImpl();
		
		init();
		
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(350, 300);
		
		lblId.setBounds(10, 10, 100, 25);
		lblName.setBounds(10, 45, 100, 25);
		lblAddress.setBounds(10, 80, 100, 25);
		lblPhone.setBounds(10, 115, 100, 25);
		lblNote.setBounds(10, 150, 100, 25);
		
		txtId.setBounds(110, 10, 200, 25);
		txtName.setBounds(110, 45, 200, 25);
		txtAddress.setBounds(110, 80, 200, 25);
		txtPhone.setBounds(110, 115, 200, 25);
		txtNote.setBounds(110, 150, 200, 25);
		
		btnSave.setBounds(50, 200, 100, 50);
		btnExit.setBounds(200, 200, 100, 50);
		
		lblId.setFont(new Font("宋体",Font.BOLD,18));
		lblName.setFont(new Font("宋体",Font.BOLD,18));
		lblAddress.setFont(new Font("宋体",Font.BOLD,18));
		lblPhone.setFont(new Font("宋体",Font.BOLD,18));
		lblNote.setFont(new Font("宋体",Font.BOLD,18));
		
		btnSave.setFont(new Font("宋体",Font.BOLD,18));
		btnExit.setFont(new Font("宋体",Font.BOLD,18));
		
		Center.centerByWindow(this);
		
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UpdateParts(e);
			}
		});
		btnExit.addActionListener(new CloseView_ActionListener(this));
		
		pnlMain.add(lblId);
		pnlMain.add(lblName);
		pnlMain.add(lblAddress);
		pnlMain.add(lblPhone);
		pnlMain.add(lblNote);
		pnlMain.add(txtId);
		pnlMain.add(txtName);
		pnlMain.add(txtAddress);
		pnlMain.add(txtPhone);
		pnlMain.add(txtNote);

		pnlMain.add(btnSave);
		pnlMain.add(btnExit);	
		
		this.add(pnlMain);
		this.setVisible(true);
	}

	protected void UpdateParts(ActionEvent e) {
		// TODO Auto-generated method stub
		String clientName = this.txtName.getText().trim();
		String clientAddress = this.txtAddress.getText().trim();
		String clientPhone = this.txtPhone.getText().trim();
		String clientNote = this.txtNote.getText().trim();
		
		Client c = new Client();
		c.setcName(clientName);
		c.setcAddress(clientAddress);
		c.setcPhone(clientPhone);
		c.setcNote(clientNote);
		c.setcID(cb.getcID());
		if(service.updateClientInfoService(c)) {
			List<Client> list = service.getAllClientInfoService();
			bcv.setTableDate(list);
			this.dispose();
		}else {
			JOptionPane.showMessageDialog(this, "修改失败", "错误", JOptionPane.ERROR_MESSAGE);
			return;
		}
	}

}
