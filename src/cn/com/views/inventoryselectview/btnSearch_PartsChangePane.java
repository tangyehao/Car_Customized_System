package cn.com.views.inventoryselectview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.com.actions.CloseView_Action;
import cn.com.dto.WarePartsInfoDto;
import cn.com.dto.partChangeInfoDto;
import cn.com.listeners.CloseView_ActionListener;
import cn.com.services.WarehouseInfoServiceInf;
import cn.com.services.impl.PartsInfoServiceImpl;
import cn.com.services.impl.WarehouseInfoServiceImpl;


public class btnSearch_PartsChangePane extends JPanel{
	
	private JPanel pnlMain;
	private JPanel pnlN;
	private JPanel pnlC;
	private JPanel pnlS;
	
	//��
	private JButton btnCheckInfo;//�鿴��ϸ��ť
	private JButton btnExport;
	private JButton btnQuit;
	
	//�������ؼ�
	private JLabel lblTime;//����comboBox�ֿ��ı�ǩ
	private JLabel lblParts;
	
	private JTextField txtParts;
	
	private JButton btnC_Search;
	//��
	
	private JTable tabWare;
	private DefaultTableModel dtmWare;
	private JScrollPane snpView;
	private PartsInfoServiceImpl service;
	private JButton btnSearchAll;
	
	
	public JTextField getTxtParts() {
		return txtParts;
	}

	public JButton getBtnQuit() {
		return btnQuit;
	}

	public btnSearch_PartsChangePane(){
		
		
	}
	
	public btnSearch_PartsChangePane(LayoutManager lm){
		super(lm);
		
		pnlMain = new JPanel();
		//��
		pnlN = new JPanel(null);
		pnlC = new JPanel(null);
		pnlS = new JPanel(null);
		btnSearchAll = new JButton("ȫ��");
		btnQuit = new JButton("�˳�");
		
		//����
		lblParts = new JLabel("ͨ��������Ʋ�ѯ:");
		txtParts = new JTextField();
		btnC_Search = new JButton("����");
		
		tabWare = new JTable(){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		snpView = new JScrollPane(tabWare);//�����ѹ�������������
		service = new PartsInfoServiceImpl();
		
		init();
	}

	
	private void init() {
		// TODO Auto-generated method stub
		
		
		pnlN.setBorder(BorderFactory.createRaisedBevelBorder());//�ֽ���
		pnlC.setBorder(BorderFactory.createRaisedBevelBorder());
		
		pnlN.setPreferredSize(new Dimension(1000,75));//������С
		pnlC.setPreferredSize(new Dimension(1000,55));
		pnlS.setPreferredSize(new Dimension(1000,510));
		pnlN.add(btnSearchAll);
		pnlN.add(btnQuit);
		pnlC.add(lblParts);
		pnlC.add(txtParts);
		pnlC.add(btnC_Search);
		pnlS.add(snpView);
		
		//��
		btnSearchAll.setBounds(30,3,60,65);
		btnSearchAll.setFont(new Font("����",Font.BOLD,18));
		btnQuit.setBounds(120, 3, 60, 65);
		btnQuit.setFont(new Font("����",Font.BOLD,18));
		
		//����
		lblParts.setBounds(220,3, 150, 45);
		txtParts.setBounds(375,10,150,30);
		btnC_Search.setBounds(535, 10, 80, 30);
		btnSearchAll.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				searchAll();
			}
			
		});
		
		btnC_Search.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				search();
			}
			
		});
		
		setTableDate(service.getPartsChangeInfoAllService());//�������
		
		lblParts.setFont(new Font("����",Font.BOLD,16));
		txtParts.setFont(new Font("����",Font.BOLD,16));
		btnC_Search.setFont(new Font("����",Font.BOLD,16));
		btnC_Search.setBackground(Color.BLUE);//��ť����ɫ
		snpView.setBounds(0,0, 1000, 500);
		pnlMain.add(pnlN);
		pnlMain.add(pnlC);
		pnlMain.add(pnlS);
		this.add(pnlMain);
		this.setVisible(true);
	}

	protected void searchAll() {
		// TODO Auto-generated method stub
		String parts_name2 = "";
		List<partChangeInfoDto> list = service.getPartsChangeInfoByPartsName(parts_name2);
		this.setTableDate(list);
	}

	protected void search() {
		// TODO Auto-generated method stub
		String parts_name1 = this.getTxtParts().getText().trim();
		List<partChangeInfoDto> list = service.getPartsChangeInfoByPartsName(parts_name1);
		this.setTableDate(list);
	}

	private void setTableDate(List<partChangeInfoDto> list) {
		// TODO Auto-generated method stub
		
		Vector<String> colNames = new Vector<String>();
		colNames.add("������");
		colNames.add("�������");
		colNames.add("�������");
		colNames.add("������");
		colNames.add("��ϵ�绰");
		colNames.add("״̬");
		
		Vector<Vector> datas = new Vector<Vector>();
		Vector row = null;
		
		for(partChangeInfoDto pci : list) {
			row = new Vector();
			row.add(pci);
			row.add(pci.getParts_name());
			row.add(pci.getParts_num());
			row.add(pci.getUser_name());
			row.add(pci.getUserphone());
			row.add(pci.getFlog());
			datas.add(row);
		}
		dtmWare = new DefaultTableModel(datas,colNames);
		this.tabWare.setModel(dtmWare);
	}
}
