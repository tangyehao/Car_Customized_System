package cn.com.views.inventoryselectview;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.com.dto.WarePartsInfoDto;
import cn.com.listeners.CloseView_ActionListener;
import cn.com.services.WarehouseInfoServiceInf;
import cn.com.services.impl.WarehouseInfoServiceImpl;




public class btnSearch_WareChangePane extends JPanel{
	
	private JPanel pnlMain;
	private JPanel pnlN;
	private JPanel pnlC;
	private JPanel pnlS;
	
	//����尴ť�ؼ�
	private JButton btnSearch;
	private JButton btnSearchAll;
	private JButton btnCheckInfo;
	private JButton btnExport;
	private JButton btnQuit;
	
	//�������ؼ�
	private JLabel lblWare;
	private JLabel lblParts;
	
	private JTextField txtParts;
	
	private JComboBox<String> cmbWare; 
	private DefaultComboBoxModel<String> dcmWare;
	
	private JButton btnC_Search;
	
	//��
	private JTable tabWare;
	private DefaultTableModel dtmWare;
	
	private JScrollPane snpView;
	
	private WarehouseInfoServiceInf service;
	
	private WareChangePaneCheck wcpc;
	
	public JButton getBtnQuit() {
		return btnQuit;
	}

	public JTextField getTxtParts() {
		return txtParts;
	}

	public btnSearch_WareChangePane(){
		
		
		//��
		pnlMain = new JPanel();
		pnlN = new JPanel(null);
		pnlC = new JPanel(null);
		pnlS = new JPanel(null);
		
		btnSearch = new JButton("����");
		btnSearchAll = new JButton();
		btnCheckInfo = new JButton();
		btnExport = new JButton();
		btnQuit = new JButton();
		
		//����
		lblWare = new JLabel("�ֿ�:");
		lblParts = new JLabel("�����Ż�����:");
		
		txtParts = new JTextField();
		
		cmbWare = new JComboBox<String>();
		dcmWare = new DefaultComboBoxModel<String>();
		
		tabWare = new JTable();
		
		snpView = new JScrollPane(tabWare);
		
		btnC_Search = new JButton("����");
		
	}
	
	public btnSearch_WareChangePane(LayoutManager lm){
		
		super(lm);
		
		pnlMain = new JPanel();
		pnlN = new JPanel(null);
		pnlC = new JPanel(null);
		pnlS = new JPanel(null);
		
		btnSearch = new JButton("����");/*{
			protected void paintComponent(Graphics g){
				Image img = new ImageIcon("images/Search.png").getImage();
				g.drawImage(img, 0, 0,60,65,this);
			}
		};*/
		btnSearchAll = new JButton("ȫ��");
		btnCheckInfo = new JButton("��ϸ");
		btnExport = new JButton("����");
		btnQuit = new JButton("�˳�");
		
		//����
		lblWare = new JLabel("��ӭ���ֹ�:�߼ο�");
		lblParts = new JLabel("ͨ��������Ʋ�ѯ:");
				
		txtParts = new JTextField();
		
				
		cmbWare = new JComboBox<String>();
		dcmWare = new DefaultComboBoxModel<String>();
		
		tabWare = new JTable(){
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		
		snpView = new JScrollPane(tabWare);//�����ѹ�������������
				
		btnC_Search = new JButton("����");
		
		service = new WarehouseInfoServiceImpl();		
		init();
	}

	
	private void init() {
		// TODO Auto-generated method stub
		
		pnlN.setBorder(BorderFactory.createRaisedBevelBorder());//�ֽ���
		pnlC.setBorder(BorderFactory.createRaisedBevelBorder());
		//pnlS.setBorder(BorderFactory.createRaisedBevelBorder());
		
		//pnlMain.setSize(1000, 550);
		pnlN.setPreferredSize(new Dimension(1000,75));//������С
		pnlC.setPreferredSize(new Dimension(1000,55));
		pnlS.setPreferredSize(new Dimension(1000,510));
		
		
		
		//pnlN.add(btnSearch);
		pnlN.add(btnSearchAll);
		//pnlN.add(btnCheckInfo);
		//pnlN.add(btnExport);
		pnlN.add(btnQuit);
		
		pnlC.add(lblWare);
		//pnlC.add(cmbWare);
		pnlC.add(lblParts);
		pnlC.add(txtParts);
		
		pnlC.add(btnC_Search);
		
		pnlS.add(snpView);
		
		//����
		btnSearch.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				searchView();
			}
			
		});
		//.addActionListener(new btnSearch_WareChangePane_btnCheckInfo_ActionListener(this));
		//btnQuit.addActionListener(new CloseView_ActionListener());

		
		
		
		btnSearch.setFont(new Font("����",Font.BOLD,18));//����
		//��
		btnSearchAll.setFont(new Font("����",Font.BOLD,18));
		btnCheckInfo.setFont(new Font("����",Font.BOLD,18));
		btnExport.setFont(new Font("����",Font.BOLD,18));
		btnQuit.setFont(new Font("����",Font.BOLD,18));
		
		//btnSearch.setBounds(30, 3, 60, 65);
		btnSearchAll.setBounds(30, 3, 60, 65);
		/*btnCheckInfo.setBounds(220, 3, 60, 65);
		btnExport.setBounds(315, 3, 60, 65);*/
		btnQuit.setBounds(120, 3, 60, 65);
		
		
		
		//����
		setCmbDate();//�������������ݷ���
		
		cmbWare.setSelectedItem("���вֿ�");
		
		lblWare.setFont(new Font("����",Font.BOLD,16));
		lblWare.setForeground(Color.RED);
		cmbWare.setFont(new Font("����",Font.BOLD,16));
		lblParts.setFont(new Font("����",Font.BOLD,16));
		txtParts.setFont(new Font("����",Font.BOLD,16));
		txtParts.setFont(new Font("����",Font.BOLD,16));
		btnC_Search.setFont(new Font("����",Font.BOLD,16));
		
		btnC_Search.setBackground(Color.BLUE);//��ť����ɫ
		
		lblWare.setBounds(30,3, 150, 45);
		//cmbWare.setBounds(80, 10, 100, 30);
		lblParts.setBounds(220,3, 150, 45);
		txtParts.setBounds(375,10,150,30);
		btnC_Search.setBounds(535, 10, 80, 30);
		
		snpView.setBounds(0,0, 1000, 500);
		
		setTableDate(service.getAllWarePartInfoService());//�������
		
		
		
		tabWare.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int count = e.getClickCount();
				if(count == 2){
					check(e);
				}
			}
		});
		
		pnlMain.add(pnlN);
		pnlMain.add(pnlC);
		pnlMain.add(pnlS);
		
		
		this.add(pnlMain);
		this.setVisible(true);
		actions();
	}

	protected void check(AWTEvent e) {
		// TODO Auto-generated method stub
		int row = this.tabWare.getSelectedRow();
		
		WarePartsInfoDto wpi  = (WarePartsInfoDto)this.tabWare.getValueAt(row, 0);
		new WareChangePaneCheck(new Frame(),"��ϸ",true,wpi);
	}

	protected void searchView() {
		// TODO Auto-generated method stub
		new WareChangePaneCheck(new Frame(),"����",true, null);
	}

	private void actions() {
		// TODO Auto-generated method stub
		btnC_Search.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				search();
			}
			
		});
		
		btnSearchAll.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				searchAll();
			}
		});
	}
		
	
	protected void searchAll() {
		// TODO Auto-generated method stub
		String parts_name = "";
		List<WarePartsInfoDto> list = service.getWarePartInfoByParts_nameServiceImpl(parts_name);
		this.setTableDate(list);
	}

	protected void search() {
		// TODO Auto-generated method stub
		String parts_name = this.getTxtParts().getText().trim();
		List<WarePartsInfoDto> list = service.getWarePartInfoByParts_nameServiceImpl(parts_name);
		this.setTableDate(list);
	}
	private void setTableDate(List<WarePartsInfoDto> list) {
		// TODO Auto-generated method stub
		Vector<String> colNames = new Vector<String>();
		colNames.add("���ID");
		colNames.add("�������");
		colNames.add("�ͺ�����");
		colNames.add("�������");
		colNames.add("����ۼ�");
		colNames.add("ռ������");
	
		Vector<Vector> datas = new Vector();
		Vector row = null;
		
		for(WarePartsInfoDto pb : list) {
			row = new Vector();
			row.add(pb);
			row.add(pb.getParts_name());
			row.add(pb.getModle_type());
			row.add(pb.getPurchase_price());
			row.add(pb.getSelling_price());
			row.add(pb.getModle_capacity());
			datas.add(row);
		}
		dtmWare = new DefaultTableModel(datas,colNames);
		this.tabWare.setModel(dtmWare);
	}

	private void setCmbDate() {
		// TODO Auto-generated method stub
		this.dcmWare.addElement("���вֿ�");
		this.dcmWare.addElement("���ֿ�");
		this.dcmWare.addElement("�������");
		this.cmbWare.setModel(dcmWare);
	}

}
