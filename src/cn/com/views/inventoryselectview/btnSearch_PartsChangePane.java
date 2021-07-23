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
	
	//北
	private JButton btnCheckInfo;//查看明细按钮
	private JButton btnExport;
	private JButton btnQuit;
	
	//中心面板控件
	private JLabel lblTime;//两个comboBox分开的标签
	private JLabel lblParts;
	
	private JTextField txtParts;
	
	private JButton btnC_Search;
	//南
	
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
		//北
		pnlN = new JPanel(null);
		pnlC = new JPanel(null);
		pnlS = new JPanel(null);
		btnSearchAll = new JButton("全部");
		btnQuit = new JButton("退出");
		
		//中心
		lblParts = new JLabel("通过配件名称查询:");
		txtParts = new JTextField();
		btnC_Search = new JButton("查找");
		
		tabWare = new JTable(){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		snpView = new JScrollPane(tabWare);//将表格压进滚动条的面板
		service = new PartsInfoServiceImpl();
		
		init();
	}

	
	private void init() {
		// TODO Auto-generated method stub
		
		
		pnlN.setBorder(BorderFactory.createRaisedBevelBorder());//分界线
		pnlC.setBorder(BorderFactory.createRaisedBevelBorder());
		
		pnlN.setPreferredSize(new Dimension(1000,75));//北面板大小
		pnlC.setPreferredSize(new Dimension(1000,55));
		pnlS.setPreferredSize(new Dimension(1000,510));
		pnlN.add(btnSearchAll);
		pnlN.add(btnQuit);
		pnlC.add(lblParts);
		pnlC.add(txtParts);
		pnlC.add(btnC_Search);
		pnlS.add(snpView);
		
		//北
		btnSearchAll.setBounds(30,3,60,65);
		btnSearchAll.setFont(new Font("宋体",Font.BOLD,18));
		btnQuit.setBounds(120, 3, 60, 65);
		btnQuit.setFont(new Font("宋体",Font.BOLD,18));
		
		//中心
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
		
		setTableDate(service.getPartsChangeInfoAllService());//表格数据
		
		lblParts.setFont(new Font("宋体",Font.BOLD,16));
		txtParts.setFont(new Font("宋体",Font.BOLD,16));
		btnC_Search.setFont(new Font("宋体",Font.BOLD,16));
		btnC_Search.setBackground(Color.BLUE);//按钮背景色
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
		colNames.add("配件编号");
		colNames.add("配件名称");
		colNames.add("配件数量");
		colNames.add("经办人");
		colNames.add("联系电话");
		colNames.add("状态");
		
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
