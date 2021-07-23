package cn.com.views.Systemview;

import cn.com.actions.CloseView_Action;
import cn.com.beans.User;

import cn.com.listeners.CloseView_ActionListener;
import cn.com.services.UserChangeServiceInf;
import cn.com.services.UserInfoServiceInf;
import cn.com.services.impl.UserChangeServiceImpl;
import cn.com.services.impl.UserInfoServiceImpl;
import cn.com.utils.Center;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class btnUserJDialog extends JDialog{
	
	private JPanel pnlMain;
	private JPanel pnlN;
	private JPanel pnlC;
	
	private JButton btnAdd;
	private JButton btnChange;
	private JButton btnDelete;
	private JTextField txtUserName;
	private JTextField txtSearch;
	private JButton btnSearch;
	private JButton btnQuit;
	private static DefaultTableModel dtmUser;
	private static JTable tabUser;
	private JScrollPane snpView;
	
	private UserInfoServiceInf service;
	private UserChangeServiceInf serviceChange;
	
	public btnUserJDialog(Frame f, String title, boolean bool){
		super(f,title,bool);
		pnlMain = new JPanel();
		pnlN = new JPanel(null);
		pnlC = new JPanel(null);
		
		btnAdd = new JButton(){
			@Override
			protected void paintComponent(Graphics g){
				Image img = new ImageIcon("images/Add.png").getImage();
				g.drawImage(img, 0, 0,60,65,this);
			}
		};
		btnChange = new JButton(){
			@Override
			protected void paintComponent(Graphics g){
				Image img = new ImageIcon("images/Update.png").getImage();
				g.drawImage(img, 0, 0,60,65,this);
			}
		};
		btnDelete = new JButton(){
			@Override
			protected void paintComponent(Graphics g){
				Image img = new ImageIcon("images/Delete.png").getImage();
				g.drawImage(img, 0, 0,60,65,this);
			}
		};
		btnSearch = new JButton(){
			@Override
			protected void paintComponent(Graphics g){
				Image img = new ImageIcon("images/Select.png").getImage();
				g.drawImage(img, 0, 0,60,65,this);
			}
		};
		btnQuit = new JButton(){
			@Override
			protected void paintComponent(Graphics g){
				Image img = new ImageIcon("images/Quit.png").getImage();
				g.drawImage(img, 0, 0,60,65,this);
			}
		};

		txtUserName = new JTextField();
		txtSearch = new JTextField();

		tabUser = new JTable(){
			@Override
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		dtmUser = new DefaultTableModel();
		
		snpView = new JScrollPane(tabUser);
		
		service = new UserInfoServiceImpl();

		serviceChange = new UserChangeServiceImpl();
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(650, 500);
		
		pnlN.setBorder(BorderFactory.createRaisedBevelBorder());//�ֽ���
		pnlC.setBorder(BorderFactory.createRaisedBevelBorder());
		
		pnlN.setPreferredSize(new Dimension(650,75));//������С
		pnlC.setPreferredSize(new Dimension(650,400));
		
		Center.centerByWindow(this);
		this.setResizable(false);
		
		btnAdd.setFont(new Font("����",Font.BOLD,14));
		btnChange.setFont(new Font("����",Font.BOLD,14));
		btnDelete.setFont(new Font("����",Font.BOLD,14));
		btnSearch.setFont(new Font("����",Font.BOLD,14));
		btnQuit.setFont(new Font("����",Font.BOLD,14));
		
		btnAdd.setBounds(30,3,60,65);
		btnChange.setBounds(125, 3, 60, 65);
		btnDelete.setBounds(220, 3, 60, 65);
		txtSearch.setBounds(315, 3, 70, 25);
		btnSearch.setBounds(410, 3, 60, 65);
		btnQuit.setBounds(505, 3, 60, 65);
		
		snpView.setBounds(0,0,650,400);
		
		//���ĵ���������
		btnAdd.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Add();
			}
			
		});
		
		btnChange.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Change();
			}
			
		});

		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Delete();
			}
		});

		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Search(e);
			}
		});

		btnQuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		setTabData(service.getUserInfo());

		pnlN.add(btnAdd);
		pnlN.add(btnChange);
		pnlN.add(btnDelete);
		pnlN.add(txtSearch);
		pnlN.add(btnSearch);
		pnlN.add(btnQuit);
		pnlC.add(snpView);
		
		pnlMain.add(pnlN);
		pnlMain.add(pnlC);
		this.add(pnlMain);
		this.setVisible(true);
	}

	//��ѯ�û�
	private void Search(ActionEvent e) {
		if (txtUserName.getText().equals("") ) {
			return;
		}
		String val = txtUserName.getText().trim();
		List<User> list = new ArrayList<User>();
		if(!val.equals("")){
			list = service.getUserInfoByName(val);
		}else{
			list = service.getUserInfo();
		}
		setTabData(list);

	}

	private void Delete() {
		int row = tabUser.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "��ѡ��Ҫɾ�����û�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		User u = (User) tabUser.getValueAt(row,1);
			JOptionPane.showConfirmDialog(this,"�Ƿ�ɾ�����û���","��ʾ",JOptionPane.YES_NO_OPTION);
			int result = JOptionPane.YES_NO_OPTION;
			if(result == JOptionPane.YES_OPTION){
				if(serviceChange.UserDel(u)){
					List<User> list = service.getUserInfo();
					setTabData(list);
				}
				//this.dispose();
				//new btnUserJDialog(new Frame(),"Ա����Ϣ",true);
			}
	}

	protected void Change() {
		// TODO Auto-generated method stub
		int row = this.tabUser.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "��ѡ��Ҫ�޸ĵ��û�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		User u = (User) tabUser.getValueAt(row,1);
		new btnUpdateUserJDialog(new Frame(),"�޸�Ա��",true,u);
	}

	protected void Add() {
		// TODO Auto-generated method stub
		new btnAddUserJDialog(new Frame(),"����Ա��",true);
	}

	public static void setTabData(List<User> list) {
		// TODO Auto-generated method stub
		Vector<String> colNames = new Vector<String>();
		colNames.add("���");
		colNames.add("Ա������");
		colNames.add("ְ��");
		colNames.add("��ϵ�绰");
		colNames.add("��ϵ��ַ");
		
		Vector<Vector> datas = new Vector();
		Vector row = null;
		int i = 1;
		for(User pb : list) {
			row = new Vector();
			row.add(i);
			row.add(pb);
			row.add(pb.getuJob());
			row.add(pb.getuPhone());
			row.add(pb.getuAddress());
			datas.add(row);
			i++;
		}
		dtmUser = new DefaultTableModel(datas,colNames);
		tabUser.setModel(dtmUser);
	}
}
