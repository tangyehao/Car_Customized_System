package cn.com.views.Systemview;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import cn.com.beans.Modle;
import cn.com.beans.Parts;
import cn.com.listeners.CloseView_ActionListener;
import cn.com.services.PartsInfoServiceInf;
import cn.com.services.impl.ModleInfoServiceImpl;
import cn.com.services.impl.PartsInfoServiceImpl;
import cn.com.utils.Center;
import cn.com.views.inventoryselectview.btnAllotJDialog;
import cn.com.views.sellview.SellBackView;
import cn.com.views.sellview.SellView;
import cn.com.views.stockview.StockBackView;
//import cn.com.service.PartsInfoServiceInf;
//import cn.com.service.impl.PartsInfoServiceImpl;
import cn.com.views.stockview.StockView;

public class BtnPartsView extends JDialog{
	private JPanel pnlMain;
	private JPanel pnlN;
	private JPanel pnlC;
	private JPanel pnlS;
	//private PartsInfoServiceInf service;
	
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
	
	private ModleInfoServiceImpl service;
	private PartsInfoServiceImpl pService;

	
	private JComboBox<String> cbxNum;
	private DefaultComboBoxModel<String> cbmNum;
	
	public JTable getTabSearch() {
		return tabSearch;
	}

	public BtnPartsView(Frame f,String title,boolean bool) {
		// TODO Auto-generated constructor stub
		super(f,title,bool);
		service = new ModleInfoServiceImpl();
		pService = new PartsInfoServiceImpl();
		pnlMain = new JPanel();
		pnlN = new JPanel(null);
		pnlC = new JPanel(null);
		pnlS = new JPanel(null);
		
		//service = new PartsInfoServiceImpl();
		
		//��
		
		cbxNum = new JComboBox<String>();
		cbmNum = new DefaultComboBoxModel<String>();
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
		lblSearch = new JLabel("����������ƽ��в�ѯ");
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
		setTableDate(pService.getAllPartsInfoService());
		
		//��ť���Ӽ���
		tabSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int count = e.getClickCount();
				if(count == 2) {
					btnUpdate(e);
				}
			}
		});
		
		init();
		
	}
	public BtnPartsView(Frame f,String title,boolean bool,StockView sv) {
		// TODO Auto-generated constructor stub
		super(f,title,bool);
		service = new ModleInfoServiceImpl();
		pService = new PartsInfoServiceImpl();
		pnlMain = new JPanel();
		pnlN = new JPanel(null);
		pnlC = new JPanel(null);
		pnlS = new JPanel(null);
		
		//service = new PartsInfoServiceImpl();
		
		//��
		btnAdd = new JButton("����");
		btnUpDate = new JButton("�޸�");
		btnDel = new JButton("ɾ��");
		btnExit = new JButton("�˳�");
		
		//�������
		lblSearch = new JLabel("����������ƽ��в�ѯ");
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
		setTableDate(pService.getAllPartsInfoService());
		//��ť���Ӽ���
		 setMD();
		btnAdd.setEnabled(false);
		btnDel.setEnabled(false);
		btnUpDate.setEnabled(false);
        tabSearch.addMouseListener(new MouseAdapter() {
       
        	@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int count = e.getClickCount();
				if(count ==2){
					int row = tabSearch.getSelectedRow();
					List<Parts> list = new ArrayList<Parts>();
					Parts pb = (Parts)getTabSearch().getValueAt(row, 0);
					list.add(pb);
					
					sv.setTable(list,cbxNum.getSelectedIndex()+1);
				}
			}
		});
        init();
		
		
	}
	public BtnPartsView(Frame f,String title,boolean bool,btnAllotJDialog sv) {
		// TODO Auto-generated constructor stub
		super(f,title,bool);
		service = new ModleInfoServiceImpl();
		pService = new PartsInfoServiceImpl();
		pnlMain = new JPanel();
		pnlN = new JPanel(null);
		pnlC = new JPanel(null);
		pnlS = new JPanel(null);
		
		//service = new PartsInfoServiceImpl();
		
		//��
		btnAdd = new JButton("����");
		btnUpDate = new JButton("�޸�");
		btnDel = new JButton("ɾ��");
		btnExit = new JButton("�˳�");
		
		//�������
		lblSearch = new JLabel("����������ƽ��в�ѯ");
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
		setTableDate(pService.getAllPartsInfoService());
		//��ť���Ӽ���
		 setMD();
		btnAdd.setEnabled(false);
		btnDel.setEnabled(false);
		btnUpDate.setEnabled(false);
        tabSearch.addMouseListener(new MouseAdapter() {
       
        	@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int count = e.getClickCount();
				if(count ==2){
					int row = tabSearch.getSelectedRow();
					List<Parts> list = new ArrayList<Parts>();
					Parts pb = (Parts)getTabSearch().getValueAt(row, 0);
					list.add(pb);
					
					sv.setTable(list,cbxNum.getSelectedIndex()+1);
				}
			}
		});
        init();
		
		
	}
	public BtnPartsView(Frame f,String title,boolean bool,SellView sv) {
		// TODO Auto-generated constructor stub
		super(f,title,bool);
		service = new ModleInfoServiceImpl();
		pService = new PartsInfoServiceImpl();
		pnlMain = new JPanel();
		pnlN = new JPanel(null);
		pnlC = new JPanel(null);
		pnlS = new JPanel(null);
		
		//service = new PartsInfoServiceImpl();
		
		//��
		btnAdd = new JButton("����");
		btnUpDate = new JButton("�޸�");
		btnDel = new JButton("ɾ��");
		btnExit = new JButton("�˳�");
		
		//�������
		lblSearch = new JLabel("����������ƽ��в�ѯ");
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
		setTableDate(pService.getAllPartsInfoService());
		//��ť���Ӽ���
		 setMD();
		btnAdd.setEnabled(false);
		btnDel.setEnabled(false);
		btnUpDate.setEnabled(false);
        tabSearch.addMouseListener(new MouseAdapter() {
       
        	@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int count = e.getClickCount();
				if(count ==2){
					int row = tabSearch.getSelectedRow();
					List<Parts> list = new ArrayList<Parts>();
					Parts pb = (Parts)getTabSearch().getValueAt(row, 0);
					list.add(pb);

					sv.setTable(list,cbxNum.getSelectedIndex()+1);
				}
			}
		});
        init();
		
		
	}
	public BtnPartsView(Frame f, String title, boolean bool, SellBackView bv) {
		// TODO Auto-generated constructor stub
		super(f,title,bool);
		service = new ModleInfoServiceImpl();
		pService = new PartsInfoServiceImpl();
		pnlMain = new JPanel();
		pnlN = new JPanel(null);
		pnlC = new JPanel(null);
		pnlS = new JPanel(null);
		
		//service = new PartsInfoServiceImpl();
		
		//��
		btnAdd = new JButton("����");
		btnUpDate = new JButton("�޸�");
		btnDel = new JButton("ɾ��");
		btnExit = new JButton("�˳�");
		
		//�������
		lblSearch = new JLabel("����������ƽ��в�ѯ");
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
		setTableDate(pService.getAllPartsInfoService());
		//��ť���Ӽ���
		 setMD();
		btnAdd.setEnabled(false);
		btnDel.setEnabled(false);
		btnUpDate.setEnabled(false);
        tabSearch.addMouseListener(new MouseAdapter() {
       
        	@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int count = e.getClickCount();
				if(count ==2){
					int row = tabSearch.getSelectedRow();
					List<Parts> list = new ArrayList<Parts>();
					Parts pb = (Parts)getTabSearch().getValueAt(row, 0);
					list.add(pb);
					
					bv.setTable(list,cbxNum.getSelectedIndex()+1);
				}
			}
		});
        init();
		
		
	}
	public BtnPartsView(Frame f, String title, boolean bool, StockBackView sv) {
		// TODO Auto-generated constructor stub
		super(f,title,bool);
		service = new ModleInfoServiceImpl();
		pService = new PartsInfoServiceImpl();
		pnlMain = new JPanel();
		pnlN = new JPanel(null);
		pnlC = new JPanel(null);
		pnlS = new JPanel(null);
		
		//service = new PartsInfoServiceImpl();
		
		//��
		btnAdd = new JButton("����");
		btnUpDate = new JButton("�޸�");
		btnDel = new JButton("ɾ��");
		btnExit = new JButton("�˳�");
		
		//�������
		lblSearch = new JLabel("����������ƽ��в�ѯ");
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
		setTableDate(pService.getAllPartsInfoService());
		//��ť���Ӽ���
		 setMD();
		btnAdd.setEnabled(false);
		btnDel.setEnabled(false);
		btnUpDate.setEnabled(false);
        tabSearch.addMouseListener(new MouseAdapter() {
       
        	@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int count = e.getClickCount();
				if(count ==2){
					int row = tabSearch.getSelectedRow();
					List<Parts> list = new ArrayList<Parts>();
					Parts pb = (Parts)getTabSearch().getValueAt(row, 0);
					list.add(pb);
					
					sv.setTable(list,cbxNum.getSelectedIndex()+1);
				}
			}
		});
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
		
		//setTableDate(service.getAllPartsInfoService());
		
		Center.centerByWindow(this);
		
		//��
		pnlN.add(btnAdd);
		pnlN.add(btnUpDate);
		pnlN.add(btnDel);
		pnlN.add(btnExit);
		
		btnAdd.setFont(new Font("����",Font.BOLD,18));
		btnUpDate.setFont(new Font("����",Font.BOLD,18));
		btnDel.setFont(new Font("����",Font.BOLD,18));
		
		
		
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BtnAdd(e);
			}
		});
		btnUpDate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnUpdate(e);
			}
		});
		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnDel(e);
			}
		});
		
		txtSearch.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				update(e);
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				update(e);
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				update(e);
			}
		});
		btnExit.addActionListener(new CloseView_ActionListener(this));
		
		
		
		//����
		pnlC.add(lblSearch);
		pnlC.add(txtSearch);
		pnlC.add(btnSearch);
		
		lblSearch.setFont(new Font("����",Font.BOLD,14));
		txtSearch.setFont(new Font("����",Font.BOLD,14));
		btnSearch.setFont(new Font("����",Font.BOLD,14));
		btnExit.setFont(new Font("����",Font.BOLD,14));
		
		//���Ӽ���
		
		
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnSearch(e);
			}
		});
		
		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnDel(e);
			}
		});
		//��
		pnlS.add(snpView);
		
		//��
		btnAdd.setBounds(30, 3, 60, 65);
		btnUpDate.setBounds(125, 3, 60, 65);
		btnDel.setBounds(220, 3, 60, 65);
		btnExit.setBounds(315, 3, 60, 65);
		
		//����
		lblSearch.setBounds(160,3, 200, 45);
		txtSearch.setBounds(370,10,150,30);
		btnSearch.setBounds(530, 10, 50, 30);
		
		
		pnlN.add(cbxNum);
		cbxNum.setBounds(850, 10, 50, 30);
		
		btnSearch.setBackground(Color.BLUE);
		
		//��
		snpView.setBounds(0, 0, 1000, 510);
		
		
		pnlMain.add(pnlN);
		pnlMain.add(pnlC);
		pnlMain.add(pnlS);
		this.add(pnlMain);
		
		this.setVisible(true);
	}


	protected void update(DocumentEvent e) {
		// TODO Auto-generated method stub
		String value = this.txtSearch.getText();
		PartsInfoServiceInf service = new PartsInfoServiceImpl();
		List<Parts> list = service.getPartsInfoByPartsNameService(value);
		this.setTableDate(list);
	}

	public JTextField getTxtSearch() {
		return txtSearch;
	}

	protected void btnSearch(ActionEvent e) {
		// TODO Auto-generated method stub
		this.setTableDate(pService.getPartsInfoByPartsNameService(this.txtSearch.getText().trim()));
	}

	protected void BtnAdd(ActionEvent e) {
		// TODO Auto-generated method stub
		new BtnAddPartsView(new Frame(), "���������Ϣ", true);
	}

	protected void btnDel(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = this.tabSearch.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "��ѡ��ɾ�������", "����", JOptionPane.ERROR_MESSAGE);
			return;
		}
		Parts pb = (Parts)tabSearch.getValueAt(row, 0);
		int result = JOptionPane.showConfirmDialog(this, "�Ƿ�ȷ��ɾ��", "��ʾ", JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.YES_OPTION) {
	        if(pService.delPartsInfoByPartsIdService(pb.getpID())) {
	        	List<Parts> list = pService.getAllPartsInfoService();
				setTableDate(list);
			}else {
				JOptionPane.showMessageDialog(this, "�޸�ʧ��", "����", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}		
			
	}

	protected void btnUpdate(AWTEvent e) {
		// TODO Auto-generated method stub
		int row = this.tabSearch.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "��ѡ��Ҫ�޸ĵ����","����",JOptionPane.ERROR_MESSAGE);
			return;
		}
		Parts pb = (Parts)tabSearch.getValueAt(row, 0);
		new BtnUpdatePartsView(this, "�޸������Ϣ", true, pb);
	}
	

	public void setTableDate(List<Parts> list) {
		// TODO Auto-generated method stub
		Vector<String> colNames = new Vector<String>();
		colNames.add("������");
		colNames.add("�������");
		colNames.add("��ɫ");
		colNames.add("�ͺű��");
		colNames.add("�ͺ�����");
		colNames.add("�������");
		colNames.add("����");
		colNames.add("�ۼ�");
		colNames.add("ռ�ÿ��");
		
		Vector<Vector> dates = new Vector<Vector>();
		
		if(list != null){
			Vector row = null;
			for(Parts f:list){
				List<Modle> modle = service.modleExportById(f.getpModle());
				Modle m = modle.get(0);
				row = new Vector();
				row.add(f);
				row.add(f.getpName());
				row.add(f.getpColour());
				row.add(m.getmID());
				row.add(m.getmName());
				row.add(m.getmType());
				row.add(m.getmPurchasePrice());
				row.add(m.getmSellPrice());
				row.add(m.getmCapacity());
				dates.add(row);
			}
		}
	
		dtmSearch = new DefaultTableModel(dates,colNames);
		tabSearch.setModel(dtmSearch);
		
	}
	private void setMD() {
		// TODO Auto-generated method stub
		
		cbxNum = new JComboBox<String>();
		cbmNum = new DefaultComboBoxModel<String>();
		
		cbxNum.setModel(cbmNum);

		for(int i = 1;i<=100;i++){
			cbmNum.addElement(i+"");
		}
	}
	
	
	
	

}
