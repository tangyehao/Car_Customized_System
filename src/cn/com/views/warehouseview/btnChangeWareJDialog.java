package cn.com.views.warehouseview;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import cn.com.dto.WareUserDto;
import cn.com.listeners.CloseView_ActionListener;
import cn.com.services.WarehouseInfoServiceInf;
import cn.com.services.impl.WarehouseInfoServiceImpl;
import cn.com.utils.Center;


public class btnChangeWareJDialog extends JDialog{

	private JLabel lblWareID;
	private JLabel lblWareName;
	private JLabel lblWareCap;
	private JLabel lblWareUser;
	private JLabel lblWareAddress;
	
	private JTextField txtWareID;
	private JTextField txtWareName;
	private JTextField txtWareUser;
	private JTextField txtWareCap;
	private JTextField txtWareAddress;
	private JButton btnSave;
	private JButton btnQuit;
	
	private JPanel pnlMain;
	
	private WareUserDto wud;
	
	private btnWareJDialog bwj;
	
	private WarehouseInfoServiceInf service;

	public JTextField getTxtWareName() {
		return txtWareName;
	}

	public JTextField getTxtWareUser() {
		return txtWareUser;
	}

	public JTextField getTxtWareCap() {
		return txtWareCap;
	}

	public JTextField getTxtWareAddress() {
		return txtWareAddress;
	}

	public btnChangeWareJDialog(Frame f, String title, boolean bool, WareUserDto wud){
		super(f,title,bool);
		pnlMain = new JPanel(null);
		
		lblWareID = new JLabel("²Ö¿âID:");
		lblWareName = new JLabel("²Ö¿âÃû³Æ:");
		lblWareCap = new JLabel("²Ö¿âµØÖ·:");
		lblWareAddress = new JLabel("²Ö¿âÈÝÁ¿:");
		lblWareUser = new JLabel("²Ö¹ÜID:");
		
		this.wud  = wud;
		
		txtWareID = new JTextField();
		txtWareName = new JTextField(wud.getWareName());
		txtWareCap = new JTextField(wud.getWareAddress());
		txtWareAddress = new JTextField(String.valueOf(wud.getWareCap()));
		txtWareUser = new JTextField(String.valueOf(wud.getWareUser()));
		
		btnSave = new JButton("±£´æ");
		btnQuit = new JButton("ÍË³ö");
		
	/*	service = new updateWareUserInfoServiceImpl();*/
		 
		service = new WarehouseInfoServiceImpl();
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(400, 350);
		this.setResizable(false);
		

		Center.centerByWindow(this);
		lblWareID.setBounds(20,20, 75, 30);
		lblWareID.setFont(new Font("ËÎÌå",Font.BOLD,15));
		txtWareID.setBounds(100,20,230,30);
		
		lblWareName.setBounds(20, 65, 75, 30);
		lblWareName.setFont(new Font("ËÎÌå",Font.BOLD,15));
		txtWareName.setBounds(100,65,230,30);
	/*	lblHandler.setEnabled(false);
		txtHandler.setEnabled(false);
		*/
		lblWareCap.setBounds(20,110,75,30);
		lblWareCap.setFont(new Font("ËÎÌå",Font.BOLD,15));
		txtWareCap.setBounds(100,110,230,30);
		/*lblPhone.setEnabled(false);
		txtPhone.setEnabled(false);*/
		
		lblWareAddress.setBounds(20,155,75,30);
		lblWareAddress.setFont(new Font("ËÎÌå",Font.BOLD,15));
		txtWareAddress.setBounds(100,155,230,30);
		
		lblWareUser.setBounds(20,200,75,30);
		lblWareUser.setFont(new Font("ËÎÌå",Font.BOLD,15));
		txtWareUser.setBounds(100,200,230,30);
		
		btnSave.setBounds(80,245,75,25);
		btnSave.setFont(new Font("ËÎÌå",Font.BOLD,15));
		
		btnQuit.setBounds(235,245,75,25);
		btnQuit.setFont(new Font("ËÎÌå",Font.BOLD,15));
		
		btnQuit.addActionListener(new CloseView_ActionListener(this));
		btnSave.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Save();
			}
			
		});
		
		//pnlMain.add(lblWareID);
		pnlMain.add(lblWareName);
		pnlMain.add(lblWareCap);
		pnlMain.add(lblWareAddress);
		pnlMain.add(lblWareUser);
		
		//pnlMain.add(txtWareID);
		pnlMain.add(txtWareUser);
		pnlMain.add(txtWareName);
		pnlMain.add(txtWareCap);
		pnlMain.add(txtWareAddress);
		
		pnlMain.add(btnSave);
		pnlMain.add(btnQuit);
		
		
		this.add(pnlMain);
		this.setVisible(true);
	}

	protected void Save() {
		// TODO Auto-generated method stub
		//int WareID = Integer.parseInt(txtWareID.getText().trim());
		String WareName = txtWareName.getText().trim();
		int WareCap = Integer.parseInt(txtWareCap.getText().trim());
		String WareAddress = txtWareAddress.getText().trim();
		int WareUser = Integer.parseInt(txtWareUser.getText().trim());
		WareUserDto wud = new WareUserDto();
		
		wud.setWareID(this.wud.getWareID());
		wud.setWareName(WareName);
		wud.setWareCap(WareCap);
		wud.setWareAddress(WareAddress);
		wud.setWareUser(WareUser);
		
		if(service.updateWareUserService(wud)){
			List<WareUserDto> list = service.getWareHouseAllInfo();
			//bwj.setTabDate(list);
			btnWareJDialog.setTabDate(list);
			this.dispose();
		}else{
			JOptionPane.showMessageDialog(this, "ÐÞ¸ÄÊ§°Ü", "´íÎó", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		
	}
}
