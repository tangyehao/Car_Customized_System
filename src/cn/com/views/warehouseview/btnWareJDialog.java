package cn.com.views.warehouseview;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.eltima.components.ui.DatePicker;

import cn.com.dto.WareUserDto;
import cn.com.listeners.CloseView_ActionListener;
import cn.com.services.WarehouseInfoServiceInf;
import cn.com.services.impl.WarehouseInfoServiceImpl;
import cn.com.utils.Center;




public class btnWareJDialog extends JDialog{
	
	private JPanel pnlMain;
	private JPanel pnlN;
	private JPanel pnlC;
	
	private JButton btnAdd;
	private JButton btnChange;
	private JButton btnDelete;
	private JButton btnQuit;
	private static DefaultTableModel dtmWareHouse;
	private static JTable tabWareHouse;
	private JScrollPane snpView;
	
	private WareUserDto wud;
	private btnWareJDialog bwj;
	private WarehouseInfoServiceInf service;
	private btnChangeWareJDialog bcwj;
	public btnWareJDialog getBwj() {
		return bwj;
	}

	public btnWareJDialog(Frame f,String title,boolean bool){
		super(f,title,bool);
		
		pnlMain = new JPanel();
		pnlN = new JPanel(null);
		pnlC = new JPanel(null);
		final DatePicker datepick;
		datepick = getDatePicker();
		
		btnAdd = new JButton(){
			protected void paintComponent(Graphics g){
				Image img = new ImageIcon("images/WareAdd.png").getImage();
				g.drawImage(img, 0, 0,60,65,this);
			}
		};
		btnChange = new JButton(){
			protected void paintComponent(Graphics g){
				Image img = new ImageIcon("images/WareUpdate.png").getImage();
				g.drawImage(img, 0, 0,60,65,this);
			}
		};
		btnDelete = new JButton(){
			protected void paintComponent(Graphics g){
				Image img = new ImageIcon("images/WareDelete.png").getImage();
				g.drawImage(img, 0, 0,60,65,this);
			}
		};
		btnQuit = new JButton(){
			protected void paintComponent(Graphics g){
				Image img = new ImageIcon("images/WareQuit.png").getImage();
				g.drawImage(img, 0, 0,60,65,this);
			}
		};
		
		tabWareHouse = new JTable(){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		dtmWareHouse = new DefaultTableModel();
		
		snpView = new JScrollPane(tabWareHouse);
		
		service = new WarehouseInfoServiceImpl();
		init();
	}
	
	public static JTable getTabWareHouse() {
		return tabWareHouse;
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(800, 500);
		
		pnlN.setBorder(BorderFactory.createRaisedBevelBorder());//�ֽ���
		pnlC.setBorder(BorderFactory.createRaisedBevelBorder());
		
		pnlN.setPreferredSize(new Dimension(800,75));//������С
		pnlC.setPreferredSize(new Dimension(800,400));
		
		Center.centerByWindow(this);
		this.setResizable(false);
		
		btnAdd.setFont(new Font("����",Font.BOLD,14));
		btnChange.setFont(new Font("����",Font.BOLD,14));
		btnDelete.setFont(new Font("����",Font.BOLD,14));
		btnQuit.setFont(new Font("����",Font.BOLD,14));
		
		btnAdd.setBounds(30,3,60,65);
		btnChange.setBounds(125, 3, 60, 65);
		btnDelete.setBounds(220, 3, 60, 65);
		btnQuit.setBounds(315, 3, 60, 65);
		
		snpView.setBounds(0,0,800,400);
		
		setTabDate(service.getWareHouseAllInfo());
		
		tabWareHouse.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int count = e.getClickCount();
				if(count == 2) {
					Change(e);
				}
			}
		});
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
				Change(e);
			}
			
		});
		
		btnDelete.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Del();
			}
			
		});
		
		btnQuit.addActionListener(new CloseView_ActionListener(this));
		final DatePicker datepick;
		datepick = getDatePicker();
		pnlN.add(btnAdd);
		pnlN.add(btnChange);
		pnlN.add(btnDelete);
		pnlN.add(btnQuit);
		pnlN.add(datepick);
		
		pnlC.add(snpView);
		
		pnlMain.add(pnlN);
		pnlMain.add(pnlC);
		this.add(pnlMain);
		this.setVisible(true);
		
		
	}

	protected void Del() {
		// TODO Auto-generated method stub
		int row = this.tabWareHouse.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this,"��ѡ��Ҫɾ���Ĳֿ�", "����", JOptionPane.ERROR_MESSAGE);
			return;
		}
		WareUserDto cb = (WareUserDto) this.tabWareHouse.getValueAt(row, 0);
		int result = JOptionPane.showConfirmDialog(this, "�Ƿ�ѡ��ɾ���˲ֿ⣿", "�ͻ�ɾ��", JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.YES_OPTION) {
			if(service.delClientInfoService(cb.getWareID())) {
				List<WareUserDto> list = service.getWareHouseAllInfo();
				setTabDate(list); 
			}else {
				JOptionPane.showMessageDialog(this, "ɾ��ʧ��", "����", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
		}
	}

	protected void Change(AWTEvent e) {
		// TODO Auto-generated method stub
		
		int row = this.tabWareHouse.getSelectedRow();
		System.out.println(row);
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "��ѡ��Ҫ�޸ĵ��û�","����", JOptionPane.WARNING_MESSAGE);
			return;
		}
		// UserBaseBean ub = (UserBaseBean)cv.getTabView().getValueAt(row, 1);
		WareUserDto wud = (WareUserDto)tabWareHouse.getValueAt(row, 0);
		new btnChangeWareJDialog(new Frame(),"�޸Ĳֿ�",true,wud);
	}

	protected void Add() {
		// TODO Auto-generated method stub
		new btnAddWareJDialog(new Frame(),"���Ӳֿ�",true);
	}
	
	public static void setTabDate(List<WareUserDto> list) {
		// TODO Auto-generated method stub
		Vector<String> colNames = new Vector<String>();
		colNames.add("�ֿ�ID");
		colNames.add("�ֿ�����");
		colNames.add("�ֿ�����");
		colNames.add("�ֿ��ַ");
		colNames.add("�ֹ�ID");
		
		Vector<Vector> datas = new Vector<Vector>();
		Vector row = null;
		
		for(WareUserDto wud : list) {
			row = new Vector();
			row.add(wud);
			row.add(wud.getWareName());
			row.add(wud.getWareCap());
			row.add(wud.getWareAddress());
			row.add(wud.getWareUser());
	
			datas.add(row);
		}
		dtmWareHouse = new DefaultTableModel(datas,colNames);
		tabWareHouse.setModel(dtmWareHouse);
	}
	private static DatePicker getDatePicker() {
		final DatePicker datepick;
		// ��ʽ
		String DefaultFormat = "yyyy-MM-dd HH:mm:ss";
		// ��ǰʱ��
		Date date = new Date();
		// ����
		Font font = new Font("Times New Roman", Font.BOLD, 14);

		Dimension dimension = new Dimension(180, 35);

	      /*  int[] hilightDays = { 1};

	        int[] disabledDays = { 4, 6, 5, 9 };*/
		//���췽������ʼʱ�䣬ʱ����ʾ��ʽ�����壬�ؼ���С��
		datepick = new DatePicker(date, DefaultFormat, font, dimension);

		datepick.setLocation(450, 20);//������ʼλ��
	        /*
	        //Ҳ����setBounds()ֱ�����ô�С��λ��
	        datepick.setBounds(137, 83, 177, 24);
	        */
		// ����һ���·�����Ҫ������ʾ������
	       /* datepick.setHightlightdays(hilightDays, Color.red);
	        // ����һ���·��в���Ҫ�����ӣ��ʻ�ɫ��ʾ
	        datepick.setDisableddays(disabledDays);*/
		// ���ù���
		datepick.setLocale(Locale.CANADA);
		// ����ʱ�����ɼ�
		datepick.setTimePanleVisible(true);
		return datepick;
	}
}
