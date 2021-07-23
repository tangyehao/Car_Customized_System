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
	
	//北
	private JButton btnAdd;
	private JButton btnUpDate;
	private JButton btnDel;
	private JButton btnExit;
	
	//中心面板
	private JLabel lblSearch;
	private JTextField txtSearch;
	private JButton btnSearch;
	
	//南
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
		
		//北
		
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
		
		//中心面板
		lblSearch = new JLabel("输入配件名称进行查询");
		txtSearch = new JTextField();
		btnSearch = new JButton("搜索");
		
		//南
		tabSearch = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};//设置表格中对象（单元格）不可被编辑
		dtmSearch = new DefaultTableModel();
		snpView = new JScrollPane(tabSearch);
		setTableDate(pService.getAllPartsInfoService());
		
		//按钮增加监听
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
		
		//北
		btnAdd = new JButton("增加");
		btnUpDate = new JButton("修改");
		btnDel = new JButton("删除");
		btnExit = new JButton("退出");
		
		//中心面板
		lblSearch = new JLabel("输入配件名称进行查询");
		txtSearch = new JTextField();
		btnSearch = new JButton("搜索");
		
		//南
		tabSearch = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};//设置表格中对象（单元格）不可被编辑
		dtmSearch = new DefaultTableModel();
		snpView = new JScrollPane(tabSearch);
		setTableDate(pService.getAllPartsInfoService());
		//按钮增加监听
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
		
		//北
		btnAdd = new JButton("增加");
		btnUpDate = new JButton("修改");
		btnDel = new JButton("删除");
		btnExit = new JButton("退出");
		
		//中心面板
		lblSearch = new JLabel("输入配件名称进行查询");
		txtSearch = new JTextField();
		btnSearch = new JButton("搜索");
		
		//南
		tabSearch = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};//设置表格中对象（单元格）不可被编辑
		dtmSearch = new DefaultTableModel();
		snpView = new JScrollPane(tabSearch);
		setTableDate(pService.getAllPartsInfoService());
		//按钮增加监听
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
		
		//北
		btnAdd = new JButton("增加");
		btnUpDate = new JButton("修改");
		btnDel = new JButton("删除");
		btnExit = new JButton("退出");
		
		//中心面板
		lblSearch = new JLabel("输入配件名称进行查询");
		txtSearch = new JTextField();
		btnSearch = new JButton("搜索");
		
		//南
		tabSearch = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};//设置表格中对象（单元格）不可被编辑
		dtmSearch = new DefaultTableModel();
		snpView = new JScrollPane(tabSearch);
		setTableDate(pService.getAllPartsInfoService());
		//按钮增加监听
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
		
		//北
		btnAdd = new JButton("增加");
		btnUpDate = new JButton("修改");
		btnDel = new JButton("删除");
		btnExit = new JButton("退出");
		
		//中心面板
		lblSearch = new JLabel("输入配件名称进行查询");
		txtSearch = new JTextField();
		btnSearch = new JButton("搜索");
		
		//南
		tabSearch = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};//设置表格中对象（单元格）不可被编辑
		dtmSearch = new DefaultTableModel();
		snpView = new JScrollPane(tabSearch);
		setTableDate(pService.getAllPartsInfoService());
		//按钮增加监听
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
		
		//北
		btnAdd = new JButton("增加");
		btnUpDate = new JButton("修改");
		btnDel = new JButton("删除");
		btnExit = new JButton("退出");
		
		//中心面板
		lblSearch = new JLabel("输入配件名称进行查询");
		txtSearch = new JTextField();
		btnSearch = new JButton("搜索");
		
		//南
		tabSearch = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};//设置表格中对象（单元格）不可被编辑
		dtmSearch = new DefaultTableModel();
		snpView = new JScrollPane(tabSearch);
		setTableDate(pService.getAllPartsInfoService());
		//按钮增加监听
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
		
		
		pnlN.setBorder(BorderFactory.createRaisedBevelBorder());//分界线
		pnlC.setBorder(BorderFactory.createRaisedBevelBorder());
		
		pnlN.setPreferredSize(new Dimension(1000,75));//北面板大小
		pnlC.setPreferredSize(new Dimension(1000,55));
		pnlS.setPreferredSize(new Dimension(1000,510));
		
		//setTableDate(service.getAllPartsInfoService());
		
		Center.centerByWindow(this);
		
		//北
		pnlN.add(btnAdd);
		pnlN.add(btnUpDate);
		pnlN.add(btnDel);
		pnlN.add(btnExit);
		
		btnAdd.setFont(new Font("宋体",Font.BOLD,18));
		btnUpDate.setFont(new Font("宋体",Font.BOLD,18));
		btnDel.setFont(new Font("宋体",Font.BOLD,18));
		
		
		
		
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
		
		
		
		//中心
		pnlC.add(lblSearch);
		pnlC.add(txtSearch);
		pnlC.add(btnSearch);
		
		lblSearch.setFont(new Font("宋体",Font.BOLD,14));
		txtSearch.setFont(new Font("宋体",Font.BOLD,14));
		btnSearch.setFont(new Font("宋体",Font.BOLD,14));
		btnExit.setFont(new Font("宋体",Font.BOLD,14));
		
		//增加监听
		
		
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
		//南
		pnlS.add(snpView);
		
		//北
		btnAdd.setBounds(30, 3, 60, 65);
		btnUpDate.setBounds(125, 3, 60, 65);
		btnDel.setBounds(220, 3, 60, 65);
		btnExit.setBounds(315, 3, 60, 65);
		
		//中心
		lblSearch.setBounds(160,3, 200, 45);
		txtSearch.setBounds(370,10,150,30);
		btnSearch.setBounds(530, 10, 50, 30);
		
		
		pnlN.add(cbxNum);
		cbxNum.setBounds(850, 10, 50, 30);
		
		btnSearch.setBackground(Color.BLUE);
		
		//南
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
		new BtnAddPartsView(new Frame(), "增加配件信息", true);
	}

	protected void btnDel(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = this.tabSearch.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "请选择删除的配件", "警告", JOptionPane.ERROR_MESSAGE);
			return;
		}
		Parts pb = (Parts)tabSearch.getValueAt(row, 0);
		int result = JOptionPane.showConfirmDialog(this, "是否确认删除", "提示", JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.YES_OPTION) {
	        if(pService.delPartsInfoByPartsIdService(pb.getpID())) {
	        	List<Parts> list = pService.getAllPartsInfoService();
				setTableDate(list);
			}else {
				JOptionPane.showMessageDialog(this, "修改失败", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}		
			
	}

	protected void btnUpdate(AWTEvent e) {
		// TODO Auto-generated method stub
		int row = this.tabSearch.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "请选择要修改的配件","警告",JOptionPane.ERROR_MESSAGE);
			return;
		}
		Parts pb = (Parts)tabSearch.getValueAt(row, 0);
		new BtnUpdatePartsView(this, "修改配件信息", true, pb);
	}
	

	public void setTableDate(List<Parts> list) {
		// TODO Auto-generated method stub
		Vector<String> colNames = new Vector<String>();
		colNames.add("配件编号");
		colNames.add("配件名称");
		colNames.add("颜色");
		colNames.add("型号编号");
		colNames.add("型号名称");
		colNames.add("配件类型");
		colNames.add("进价");
		colNames.add("售价");
		colNames.add("占用库存");
		
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
