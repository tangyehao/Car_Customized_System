package cn.com.views.warehouseview;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import cn.com.dto.WareUserDto;
import cn.com.services.WarehouseInfoServiceInf;
import cn.com.services.impl.WarehouseInfoServiceImpl;

import cn.com.utils.Center;



public class btnAddWareJDialog extends JDialog{

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

	private btnWareJDialog bwj;

	private WarehouseInfoServiceInf service;
	private JLabel lblVali;

	public JTextField getTxtWareID() {
		return txtWareID;
	}

	public JTextField getTxtWareUser() {
		return txtWareUser;
	}

	public JLabel getLblVali() {
		return lblVali;
	}

	public btnAddWareJDialog(Frame f,String title,boolean bool){
		super(f,title,bool);
		pnlMain = new JPanel(null);

		lblWareID = new JLabel("仓库ID:");
		lblWareName = new JLabel("仓库名称:");
		lblWareCap = new JLabel("仓库容量:");
		lblWareAddress = new JLabel("仓库地址:");
		lblWareUser = new JLabel("仓管:");

		txtWareID = new JTextField();
		txtWareName = new JTextField();
		txtWareCap = new JTextField();
		txtWareAddress = new JTextField();
		txtWareUser = new JTextField();

		lblVali = new JLabel();

		btnSave = new JButton("保存");
		btnQuit = new JButton("退出");

		/*	service = new updateWareUserInfoServiceImpl();*/
		service = new WarehouseInfoServiceImpl();
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(450, 350);
		this.setResizable(false);

		Center.centerByWindow(this);

		lblWareID.setBounds(20,20, 75, 30);
		lblWareID.setFont(new Font("宋体",Font.BOLD,15));
		txtWareID.setBounds(100,20,230,30);
		lblVali.setBounds(335,20,90,30);
		lblVali.setFont(new Font("宋体",Font.BOLD,12));

		lblWareName.setBounds(20, 65, 75, 30);
		lblWareName.setFont(new Font("宋体",Font.BOLD,15));
		txtWareName.setBounds(100,65,230,30);
	/*	lblHandler.setEnabled(false);
		txtHandler.setEnabled(false);
		*/
		lblWareCap.setBounds(20,110,75,30);
		lblWareCap.setFont(new Font("宋体",Font.BOLD,15));
		txtWareCap.setBounds(100,110,230,30);
		/*lblPhone.setEnabled(false);
		txtPhone.setEnabled(false);*/

		lblWareAddress.setBounds(20,155,75,30);
		lblWareAddress.setFont(new Font("宋体",Font.BOLD,15));
		txtWareAddress.setBounds(100,155,230,30);

		lblWareUser.setBounds(20,200,75,30);
		lblWareUser.setFont(new Font("宋体",Font.BOLD,15));
		txtWareUser.setBounds(100,200,230,30);

		btnSave.setBounds(80,265,75,35);
		btnSave.setFont(new Font("宋体",Font.BOLD,15));

		btnQuit.setBounds(235,265,75,35);
		btnQuit.setFont(new Font("宋体",Font.BOLD,15));

		txtWareCap.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				int keyChar=e.getKeyChar();
				if (keyChar>=KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9) {

				} else {
					e.consume();
				}
				if(txtWareCap.getText().length()>4&&e.getKeyChar()!='\b')
				{
					e.setKeyChar('\0');
					JOptionPane.showMessageDialog(null, "超出最大仓库容量");
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});

		txtWareID.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				int keyChar=e.getKeyChar();
				if (keyChar>=KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9) {

				} else {
					e.consume();
				}
				if(txtWareID.getText().length()>7&&e.getKeyChar()!='\b')
				{
					e.setKeyChar('\0');
					JOptionPane.showMessageDialog(null, "已达最大长度！");
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});


		btnSave.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Save(e);
			}

		});
		txtWareID.getDocument().addDocumentListener(new DocumentListener(){

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				vali();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				removeVali();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				vali();
			}

		});

		pnlMain.add(lblWareID);
		pnlMain.add(lblWareName);
		pnlMain.add(lblWareCap);
		pnlMain.add(lblWareAddress);
		pnlMain.add(lblWareUser);

		pnlMain.add(txtWareID);
		pnlMain.add(txtWareUser);
		pnlMain.add(txtWareName);
		pnlMain.add(txtWareCap);
		pnlMain.add(txtWareAddress);
		pnlMain.add(lblVali);
		pnlMain.add(btnSave);
		pnlMain.add(btnQuit);


		this.add(pnlMain);
		this.setVisible(true);
	}

	protected void removeVali() {
		// TODO Auto-generated method stub
		this.getLblVali().setText("");
	}

	protected void vali() {
		// TODO Auto-generated method stub
		int value = Integer.parseInt(this.getTxtWareID().getText());
		service = new WarehouseInfoServiceImpl();
		if(service.validateByWarehouseIdService(value)){
			this.getLblVali().setText("编号已存在");
			this.getLblVali().setForeground(Color.RED);
		}else if(!service.validateByWarehouseIdService(value)){
			this.getLblVali().setText("编号可用");
			this.getLblVali().setForeground(Color.GREEN);
		}
		if(String.valueOf(value).length()>=6){
			this.getLblVali().setText("仓库ID过大");
			this.getLblVali().setForeground(Color.RED);
		}
	}

	protected void Save(ActionEvent e) {
		// TODO Auto-generated method stub
		if(this.getTxtWareID().getText().trim().equals("")){
			JOptionPane.showMessageDialog(this, "仓库ID必须填写,添加失败！", "警告", JOptionPane.WARNING_MESSAGE);
			return;
		}
		if(this.getTxtWareUser().getText().trim().equals("")){
			JOptionPane.showMessageDialog(this, "仓管负责人ID必须填写,添加失败！", "警告", JOptionPane.WARNING_MESSAGE);
			return;
		}
		int WareID = Integer.parseInt(txtWareID.getText().trim());
		String WareName = txtWareName.getText().trim();
		int WareCap = Integer.parseInt(txtWareCap.getText().trim());
		String WareAddress = txtWareAddress.getText().trim();
		int WareUser = Integer.parseInt(txtWareUser.getText().trim());

		WareUserDto wud = new WareUserDto();

		wud.setWareID(WareID);
		wud.setWareName(WareName);
		wud.setWareCap(WareCap);
		wud.setWareAddress(WareAddress);
		wud.setWareUser(WareUser);

		if(service.validateByWarehouseIdService(wud.getWareID())){
			JOptionPane.showMessageDialog(this, "此仓库编号已存在，添加失败", "错误", JOptionPane.ERROR_MESSAGE);
			return;
		}else if(service.addWareService(wud)) {
			List<WareUserDto> list = service.getWareHouseAllInfo();
			btnWareJDialog.setTabDate(list);
			JOptionPane.showMessageDialog(this, "添加成功", "提示", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		}else {
			JOptionPane.showMessageDialog(this, "此仓库编号已存在，添加失败", "错误", JOptionPane.ERROR_MESSAGE);
			return;
		}


	}
}
