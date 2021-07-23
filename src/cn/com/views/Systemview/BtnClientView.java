package cn.com.views.Systemview;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import cn.com.beans.Client;
import cn.com.listeners.CloseView_ActionListener;
import cn.com.services.ClientInfoServiceInf;
import cn.com.services.impl.ClientInfoServiceImpl;
import cn.com.utils.Center;

public class BtnClientView extends JDialog {
	private JPanel pnlMain;
	private JPanel pnlN;
	private JPanel pnlC;
	private JPanel pnlS;
	private JPanel pnlW;
	private ClientInfoServiceInf service;
	
	//��
	private JButton btnAdd;
	private JButton btnUpDate;
	private JButton btnDel;
	private JButton btnExit;
	
	//�������
	private JLabel lblSearch;
	private JTextField txtSearch;
	private JButton btnSearch;
	
	//��
	private JTable tabSearch;
	private DefaultTableModel dtmSearch;
	
	private JScrollPane snpView;
	
	public BtnClientView(Frame f,String title,boolean bool) {
		// TODO Auto-generated constructor stub
		super(f,title,bool);
		pnlMain = new JPanel();
		pnlN = new JPanel(null);
		pnlC = new JPanel(null);
		pnlS = new JPanel(null);
		
		service = new ClientInfoServiceImpl();
		
		//��
		btnAdd = new JButton(){
			protected void paintComponent(Graphics g){
				Image img = new ImageIcon("images/Add.png").getImage();
				g.drawImage(img, 0, 0,60,65,this);
			}
		};
		btnUpDate = new JButton(){
			protected void paintComponent(Graphics g){
				Image img = new ImageIcon("images/Update.png").getImage();
				g.drawImage(img, 0, 0,60,65,this);
			}
		};
		btnDel = new JButton(){
			protected void paintComponent(Graphics g){
				Image img = new ImageIcon("images/Delete.png").getImage();
				g.drawImage(img, 0, 0,60,65,this);
			}
		};
		btnExit = new JButton(){
			protected void paintComponent(Graphics g){
				Image img = new ImageIcon("images/Exit.png").getImage();
				g.drawImage(img, 0, 0,60,65,this);
			}
		};
		
		//�������
		lblSearch = new JLabel("����ͻ���Ϣ���в�ѯ");
		txtSearch = new JTextField();
		btnSearch = new JButton("����");
		
		//��
		tabSearch = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};//���ñ���ж��󣨵�Ԫ�񣩲��ɱ��༭
		dtmSearch = new DefaultTableModel();
		snpView = new JScrollPane(tabSearch);
		
		init();
		
	}

	private void init() {
		// TODO Auto-generated method stub
		
		this.setVisible(false);
		this.setSize(1000, 650);
		pnlN.setBorder(BorderFactory.createRaisedBevelBorder());//�ֽ���
		pnlC.setBorder(BorderFactory.createRaisedBevelBorder());
		
		pnlN.setPreferredSize(new Dimension(1000,75));//������С
		pnlC.setPreferredSize(new Dimension(1000,55));
		pnlS.setPreferredSize(new Dimension(1000,510));
		
		Center.centerByWindow(this);
		
		//��
		pnlN.add(btnAdd);
		pnlN.add(btnUpDate);
		pnlN.add(btnDel);
		pnlN.add(btnExit);
		
		btnAdd.setFont(new Font("����",Font.BOLD,18));
		btnUpDate.setFont(new Font("����",Font.BOLD,18));
		btnDel.setFont(new Font("����",Font.BOLD,18));
		btnExit.setFont(new Font("����",Font.BOLD,18));
		
		//����
		pnlC.add(lblSearch);
		pnlC.add(txtSearch);
		pnlC.add(btnSearch);
		
		lblSearch.setFont(new Font("����",Font.BOLD,14));
		txtSearch.setFont(new Font("����",Font.BOLD,14));
		btnSearch.setFont(new Font("����",Font.BOLD,14));
		
		//��
		pnlS.add(snpView);
		
		//��
		btnAdd.setBounds(30, 3, 60, 65);
		btnUpDate.setBounds(125, 3, 60, 65);
		btnDel.setBounds(220, 3, 60, 65);
		btnExit.setBounds(315, 3, 60, 65);
		
		btnUpDate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnUpdate(e);
			}
		});
		tabSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int count = e.getClickCount();
				if(count == 2){
					btnUpdate(e);
				}
			}
		});
		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnDel(e);
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnAdd(e);
			}
		});
		txtSearch.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				Update(e);
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				Update(e);
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				Update(e);
			}
		});
		btnExit.addActionListener(new CloseView_ActionListener(this));
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnSearch(e);
			}
		});
		
		//����
		lblSearch.setBounds(210,3, 150, 45);
		txtSearch.setBounds(370,10,150,30);
		btnSearch.setBounds(530, 10, 50, 30);
		
		btnSearch.setBackground(Color.BLUE);
		
		//��
		snpView.setBounds(0, 0, 1000, 510);
		setTableDate(service.getAllClientInfoService());
		
		this.add(pnlMain);
		pnlMain.add(pnlN);
		pnlMain.add(pnlC);
		pnlMain.add(pnlS);
		this.setVisible(true);
	}

	protected void Update(DocumentEvent e) {
		// TODO Auto-generated method stub
		String value = this.txtSearch.getText();
		ClientInfoServiceInf service = new ClientInfoServiceImpl();
		List<Client> list = service.getClientInfoByClientNameService(value);
		this.setTableDate(list);
	}

	protected void btnSearch(ActionEvent e) {
		// TODO Auto-generated method stub
		this.setTableDate(service.getClientInfoByClientNameService(this.txtSearch.getText().trim()));
	}

	protected void btnAdd(ActionEvent e) {
		// TODO Auto-generated method stub
		new BtnAddClientView(this, "����ͻ���Ϣ", true);
	}

	protected void btnDel(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = this.tabSearch.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this,"��ѡ��Ҫɾ���Ŀͻ�", "����", JOptionPane.ERROR_MESSAGE);
			return;
		}
		Client cb = (Client) this.tabSearch.getValueAt(row, 0);
		int result = JOptionPane.showConfirmDialog(this, "�Ƿ�ѡ��ɾ���˿ͻ���", "�ͻ�ɾ��", JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.YES_OPTION) {
			if(service.delClientInfoService(cb.getcID())) {
				List<Client> list = service.getAllClientInfoService();
				this.setTableDate(list);
			}else {
				JOptionPane.showMessageDialog(this, "ɾ��ʧ��", "����", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
		}
	}

	protected void btnUpdate(AWTEvent e) {
		// TODO Auto-generated method stub
		int row = this.tabSearch.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "��ѡ��Ҫ�޸ĵĿͻ�", "����", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Client cb = (Client)tabSearch.getValueAt(row, 0);
		new BtnUpdateClientView(this, "�޸Ŀͻ���Ϣ", true, cb);
	}

	public void setTableDate(List<Client> list) {
		// TODO Auto-generated method stub
		Vector<String> colNames = new Vector<String>();
		colNames.add("�ͻ�ID");
		colNames.add("�ͻ�����");
		colNames.add("��ַ");
		colNames.add("�绰");
		colNames.add("��ע");	
		
		Vector<Vector> dates = new Vector<Vector>();
		Vector row = null;
		for(Client cb : list) {
			row = new Vector();
			row.add(cb);
			row.add(cb.getcName());
			row.add(cb.getcAddress());
			row.add(cb.getcPhone());
			row.add(cb.getcNote());
			
			dates.add(row);
		}
		
		dtmSearch = new DefaultTableModel(dates,colNames);
		this.tabSearch.setModel(dtmSearch);
	}
}
