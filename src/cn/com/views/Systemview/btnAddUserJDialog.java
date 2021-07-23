package cn.com.views.Systemview;

import cn.com.beans.User;
import cn.com.services.UserBaseServiceInf;
import cn.com.services.UserChangeServiceInf;
import cn.com.services.impl.UserBaseServiceImpl;
import cn.com.services.impl.UserChangeServiceImpl;
import cn.com.utils.Center;
import cn.com.utils.CheckEmail;
import cn.com.utils.KeyCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class btnAddUserJDialog extends JDialog{
	private JLabel lblUserNo;//用户帐号标签
	private JLabel lblUserPwd;//用户密码标签
	private JLabel lblUserAge;//用户年龄标签

	private JLabel lblUserName;//用户姓名标签
	private JLabel lblJob;//用户职务标签
	private JLabel lblPhone;//用户电话标签
	private JLabel lblUserAddress;//用户地址标签
	private JLabel lblUserEmail;//用户邮箱标签
	private JTextField txtUserName;//用户姓名文本
	private JTextField txtUserNo;
	private JPasswordField userPwd;
	private JRadioButton rabUserSex1;
	private JRadioButton rabUserSex2;
	private JLabel lblUserSex;
	private ButtonGroup buttonGroup;

	private JComboBox<String> cmbJob;
	private DefaultComboBoxModel<String> dcmbJob;

	private JComboBox<String> cmbState;
	private DefaultComboBoxModel<String> dcmbState;

	private JComboBox<Integer> cmbUserAge;
	private DefaultComboBoxModel<Integer> dcmbUserAge;

	private JCheckBox chkPurchase;
	private JCheckBox chkSell;
	private JCheckBox chkWareManage;
	private JCheckBox chkBill;
	private JCheckBox chkParts;
	private JCheckBox chkClient;
	private JCheckBox chkFirm;
	private JCheckBox chkUser;

	private JTextField txtPhone;
	private JLabel lblUserState;
	private JTextField txtUserAddress;

	private JTextField txtUserEmail;
	private JButton btnSave;
	private JButton btnQuit;

	private UserChangeServiceInf service;
	private UserBaseServiceInf userService;

	private JLabel lblMsg;

	private JPanel pnlMain;

	public btnAddUserJDialog(Frame f, String title, boolean bool){
		super(f,title,bool);
		pnlMain = new JPanel(null);
		service = new UserChangeServiceImpl();
		userService = new UserBaseServiceImpl();
		lblUserNo = new JLabel("帐号:");
		lblUserName = new JLabel("员工姓名:");
		lblUserPwd = new JLabel("密码");
		lblUserSex = new JLabel("性别");
		rabUserSex1 = new JRadioButton("男");
		rabUserSex2 = new JRadioButton("女");
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rabUserSex1);
		buttonGroup.add(rabUserSex2);
		lblJob = new JLabel("职务:");

		chkSell = new JCheckBox("销售");
		chkPurchase = new JCheckBox("采购");
		chkBill = new JCheckBox("财务");
		chkWareManage = new JCheckBox("仓库");
		chkParts = new JCheckBox("配件");
		chkClient = new JCheckBox("客户");
		chkFirm = new JCheckBox("厂商");
		chkUser = new JCheckBox("用户");

		lblUserAge = new JLabel("年龄");
		lblPhone = new JLabel("联系电话:");
		lblUserAddress = new JLabel("联系地址:");
		lblUserEmail = new JLabel("邮箱");
		lblUserState = new JLabel("状态");

		txtUserNo = new JTextField();
		txtUserName = new JTextField();
		userPwd = new JPasswordField();

		cmbJob = new JComboBox<String>();
		dcmbJob = new DefaultComboBoxModel<String>();

		cmbState = new JComboBox<String>();
		dcmbState = new DefaultComboBoxModel<String>();

		cmbUserAge = new JComboBox<Integer>();
		dcmbUserAge = new DefaultComboBoxModel<Integer>();

		txtPhone = new JTextField();
		txtUserAddress = new JTextField();

		txtUserEmail = new JTextField();

		lblMsg = new JLabel();

		btnSave = new JButton("保存");
		btnQuit = new JButton("退出");

		
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(600, 600);
		this.setResizable(false);
		
		Center.centerByWindow(this);
		setCmbJobData();
		setCmbStateData();
		setCmbUserAge();

		lblUserNo.setBounds(40,50,50,30);
		lblUserNo.setFont(new Font("宋体",Font.BOLD,15));
		txtUserNo.setBounds(150,50,130,25);

		lblUserPwd.setBounds(40,90, 50, 30);
		lblUserPwd.setFont(new Font("宋体",Font.BOLD,15));
		userPwd.setBounds(150,90,130,25);

		lblUserName.setBounds(40, 130, 75, 30);
		lblUserName.setFont(new Font("宋体",Font.BOLD,15));
		txtUserName.setBounds(150,130,130,25);

		lblJob.setBounds(40, 170, 75, 30);
		lblJob.setFont(new Font("宋体",Font.BOLD,15));

		cmbJob.setBounds(150,170,130,25);

		chkSell.setBounds(300,170,60,25);
		chkPurchase.setBounds(370,170,60,25);
		chkWareManage.setBounds(440,170,60,25);
		chkBill.setBounds(510,170,60,25);
		chkParts.setBounds(300,210,60,25);
		chkClient.setBounds(370,210,60,25);
		chkFirm.setBounds(440,210,60,25);
		chkUser.setBounds(510,210,60,25);



		lblUserAge.setBounds(40,250,75,30);
		lblUserAge.setFont(new Font("宋体",Font.BOLD,15));
		cmbUserAge.setBounds(150,250,130,25);

		lblPhone.setBounds(40,290,75,30);
		lblPhone.setFont(new Font("宋体",Font.BOLD,15));
		txtPhone.setBounds(150,290,130,25);

		lblUserAddress.setBounds(40,330,75,30);
		lblUserAddress.setFont(new Font("宋体",Font.BOLD,15));
		txtUserAddress.setBounds(150,330,130,25);

		lblUserState.setBounds(40,370,75,30);
		lblUserState.setFont(new Font("宋体",Font.BOLD,15));
		cmbState.setBounds(150,370,130,25);

		lblUserSex.setBounds(40,410,75,25);
		lblUserSex.setFont(new Font("宋体",Font.BOLD,15));
		rabUserSex1.setBounds(150,410,75,25);
		rabUserSex2.setBounds(270,410,75,25);

		lblUserEmail.setBounds(40,450,75,25);
		lblUserEmail.setFont(new Font("宋体",Font.BOLD,15));
		txtUserEmail.setBounds(150,450,130,25);

		btnSave.setBounds(40,500,75,25);
		btnSave.setFont(new Font("宋体",Font.BOLD,15));

		btnQuit.setBounds(130,500,75,25);
		btnQuit.setFont(new Font("宋体",Font.BOLD,15));

		lblMsg.setBounds(220,500,130,25);
		lblMsg.setFont(new Font("宋体",Font.BOLD,15));

		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addUser();
				
			}
		});
		btnQuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		pnlMain.add(lblUserNo);
		pnlMain.add(lblUserPwd);
		pnlMain.add(lblUserName);
		pnlMain.add(lblJob);
		pnlMain.add(chkPurchase);
		pnlMain.add(chkSell);
		pnlMain.add(chkWareManage);
		pnlMain.add(chkBill);
		pnlMain.add(chkParts);
		pnlMain.add(chkFirm);
		pnlMain.add(chkClient);
		pnlMain.add(chkUser);

		pnlMain.add(lblUserSex);
		pnlMain.add(lblUserAge);
		pnlMain.add(lblPhone);
		pnlMain.add(lblUserAddress);
		pnlMain.add(lblUserState);
		pnlMain.add(lblUserEmail);

		pnlMain.add(txtUserNo);
		pnlMain.add(userPwd);
		pnlMain.add(txtUserName);
		pnlMain.add(cmbJob);
		pnlMain.add(rabUserSex1);
		pnlMain.add(rabUserSex2);
		pnlMain.add(cmbUserAge);
		pnlMain.add(txtPhone);
		pnlMain.add(txtUserAddress);
		pnlMain.add(cmbState);
		pnlMain.add(txtUserEmail);
		pnlMain.add(lblMsg);

		rabUserSex1.setSelected(true);
		pnlMain.add(btnSave);
		pnlMain.add(btnQuit);
		this.add(pnlMain);
		this.setVisible(true);
	}

	private void setCmbUserAge() {
		for(int i = 22;i<70;i++){
			this.dcmbUserAge.addElement(i);
		}
		cmbUserAge.setModel(dcmbUserAge);
	}

	private void setCmbStateData() {
		this.dcmbState.addElement("正常");
		this.dcmbState.addElement("禁用");
		cmbState.setModel(dcmbState);
	}


	private void setCmbJobData() {
		this.dcmbJob.addElement("管理员");
		this.dcmbJob.addElement("采购员");
		this.dcmbJob.addElement("销售员");
		this.dcmbJob.addElement("仓管");
		this.dcmbJob.addElement("财务员");
		cmbJob.setModel(dcmbJob);
	}

	private void addUser() {
		User user = new User();
		if(userService.validateByUserNo(txtUserNo.getText())){
			lblMsg.setText("帐号已经存在！");
			lblMsg.setForeground(Color.RED);
			return;
		}
		if(txtUserNo.getText().equals("")){
			lblMsg.setText("帐号必须填写!");
			lblMsg.setForeground(Color.RED);
			return;
		}
		user.setuNo(txtUserNo.getText());
		String pwd = String.valueOf(userPwd.getPassword());
		if(pwd.equals("")){
			lblMsg.setText("密码必须填写!");
			lblMsg.setForeground(Color.RED);
			return;
		}
		if(pwd.length() < 6 || pwd.length() >32){
			lblMsg.setText("密码长度不合法");
			lblMsg.setForeground(Color.RED);
			return;
		}
		String val = KeyCode.getKeyCodeMsg(pwd);
		user.setuPwd(val);
		if(txtUserName.getText().equals("")){
			lblMsg.setText("姓名必须填写!");
			lblMsg.setForeground(Color.RED);
			return;
		}
		if(txtUserName.getText().length() >10){
			lblMsg.setText("姓名长度非法");
			lblMsg.setForeground(Color.RED);
			return;
		}
		user.setuName(txtUserName.getText());

		cmbJob.setSelectedIndex(0);//设置默认职务
		user.setuJob(String.valueOf(cmbJob.getSelectedItem()));

		user.setuAge(String.valueOf(cmbUserAge.getSelectedItem()));

		if(rabUserSex1.isSelected()){
			user.setuSex(rabUserSex1.getText());
		}else{
			user.setuSex((rabUserSex2.getText()));
		}
		user.setuAddress(txtUserAddress.getText());
		user.setuPhone(txtPhone.getText());
		if(txtUserEmail.getText().equals("")){
			lblMsg.setText("邮箱必须填写!");
			lblMsg.setForeground(Color.RED);
			return;
		}
		if(userService.validateByUserEmail(txtUserEmail.getText())){
			lblMsg.setText("邮箱重复,请重新填写!");
			lblMsg.setForeground(Color.RED);
			return;
		}
		if(!CheckEmail.CheckEmail(txtUserEmail.getText())){
			lblMsg.setText("邮箱非法");
			lblMsg.setForeground(Color.RED);
			return;
		}
		if(CheckEmail.CheckEmail(txtUserEmail.getText())){
			lblMsg.setText("邮箱非法");
			lblMsg.setForeground(Color.RED);
			return;
		}
		user.setuEmail(txtUserEmail.getText());

		cmbState.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				user.setuState(String.valueOf(cmbState.getSelectedItem()));
			}
		});

		if(service.addUserInfo(user)){
			List<User> list = userService.getAllUsers();
			btnUserJDialog.setTabData(list);
			this.dispose();
		}
	}
}
