package cn.com.views.Systemview;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import cn.com.beans.Client;
import cn.com.listeners.CloseView_ActionListener;
import cn.com.services.ClientInfoServiceInf;
import cn.com.services.impl.ClientInfoServiceImpl;
import cn.com.utils.Center;

public class BtnAddClientView extends JDialog {
	private JPanel pnlMain;
	
	private JLabel lblId;
	private JLabel lblName;
	private JLabel lblAddress;
	private JLabel lblPhone;
	private JLabel lblNote;
	private JLabel lblMe;
	
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JTextField txtNote;
	
	private JButton btnSave;
	private JButton btnExit;
	
	private Client cb;
	private BtnClientView bcd;
	private ClientInfoServiceInf service;
	

	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public void setTxtName(JTextField txtName) {
		this.txtName = txtName;
	}

	public JTextField getTxtAddress() {
		return txtAddress;
	}

	public void setTxtAddress(JTextField txtAddress) {
		this.txtAddress = txtAddress;
	}

	public JTextField getTxtPhone() {
		return txtPhone;
	}

	public void setTxtPhone(JTextField txtPhone) {
		this.txtPhone = txtPhone;
	}

	public JTextField getTxtNote() {
		return txtNote;
	}

	public void setTxtNote(JTextField txtNote) {
		this.txtNote = txtNote;
	}
	

	public BtnAddClientView(Dialog f, String title, boolean bool) {
		// TODO Auto-generated constructor stub
		super(f,title,true);
		bcd = (BtnClientView)f;
		pnlMain = new JPanel(null);
		
		lblId = new JLabel("客户ID：");
		lblName = new JLabel("客户姓名：");
		lblAddress = new JLabel("地址：");
		lblPhone = new JLabel("电话：");
		lblNote = new JLabel("备    注：");
		lblMe = new JLabel();

		
		txtId = new JTextField();
		txtName = new JTextField();
		txtAddress = new JTextField();
		txtPhone = new JTextField();
		txtNote = new JTextField();

		
		btnSave = new JButton("保存");
		btnExit = new JButton("退出");
	
		
		init();
		
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(450, 340);
		
		lblId.setBounds(10, 10, 100, 25);
		lblName.setBounds(10, 45, 100, 25);
		lblAddress.setBounds(10, 80, 100, 25);
		lblPhone.setBounds(10, 115, 100, 25);
		lblNote.setBounds(10, 150, 100, 25);
		lblMe.setBounds(310, 10, 150, 25);

		
		txtId.setBounds(110, 10, 200, 25);
		txtName.setBounds(110, 45, 200, 25);
		txtAddress.setBounds(110, 80, 200, 25);
		txtPhone.setBounds(110, 115, 200, 25);
		txtNote.setBounds(110, 150, 200, 25);

		
		btnSave.setBounds(100, 250, 100, 50);
		btnExit.setBounds(250, 250, 100, 50);
		
		lblId.setFont(new Font("宋体",Font.BOLD,18));
		lblName.setFont(new Font("宋体",Font.BOLD,18));
		lblAddress.setFont(new Font("宋体",Font.BOLD,18));
		lblPhone.setFont(new Font("宋体",Font.BOLD,18));
		lblNote.setFont(new Font("宋体",Font.BOLD,18));
		lblMe.setFont(new Font("宋体", Font.BOLD, 15));
		
		
		btnSave.setFont(new Font("宋体",Font.BOLD,18));
		btnExit.setFont(new Font("宋体",Font.BOLD,18));
		
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BtnSave(e);
			}
		});
		txtId.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				validateClientId(e);
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				validateClientId(e);
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				validateClientId(e);
			}
		});
		btnExit.addActionListener(new CloseView_ActionListener(this));
		
		
		Center.centerByWindow(this);
		
		pnlMain.add(lblId);
		pnlMain.add(lblName);
		pnlMain.add(lblAddress);
		pnlMain.add(lblPhone);
		pnlMain.add(lblNote);
		pnlMain.add(lblMe);
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

	protected void validateClientId(DocumentEvent e) {
		// TODO Auto-generated method stub
		if(this.txtId.getText().equals("")) {
			this.lblMe.setText("请输入客户ID");
			this.lblMe.setForeground(Color.RED);
		}else {
			int value = Integer.parseInt(this.txtId.getText());
			service = new ClientInfoServiceImpl();
			if(service.validateByClientIdService(value)) {
				this.lblMe.setText("该客户ID已存在");
				this.lblMe.setForeground(Color.RED);
			}else {
				this.lblMe.setText("该客户ID不存在");
				this.lblMe.setForeground(Color.GREEN);
			}
		}
}

	protected void BtnSave(ActionEvent e) {
		// TODO Auto-generated method stub
		if(this.getTxtId().getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "客户ID必须填写,添加失败！", "警告", JOptionPane.WARNING_MESSAGE);
			return;
		}/*else if((this.txtPartsId.getText().class).equals(String.class)) {
			JOptionPane.showMessageDialog(this, "配件ID必须为整形数字,添加失败", "警告", JOptionPane.WARNING_MESSAGE);
			return;
		}*/else if(this.getTxtName().getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "客户姓名必须填写,添加失败！", "警告", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		service = new ClientInfoServiceImpl();
		cb = new Client();
		
		cb.setcID(Integer.parseInt(this.getTxtId().getText().trim()));
		cb.setcName(this.getTxtName().getText().trim());
		cb.setcPhone(this.getTxtPhone().getText().trim());
		cb.setcAddress(this.getTxtAddress().getText().trim());
		cb.setcNote(this.getTxtNote().getText().trim());
		
		if(service.validateByClientIdService(cb.getcID())) {
			JOptionPane.showMessageDialog(this, "此配件编号已存在，添加失败", "错误", JOptionPane.ERROR_MESSAGE);
			return;
		}else if(service.addClientInfoService(cb) ){
			List<Client> list = service.getAllClientInfoService();
			bcd.setTableDate(list);
			JOptionPane.showMessageDialog(this, "配件添加成功", "提示", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		}else {
			JOptionPane.showMessageDialog(this, "此配件编号已存在，添加失败", "错误", JOptionPane.ERROR_MESSAGE);
			return;
		}
	
	}
}
