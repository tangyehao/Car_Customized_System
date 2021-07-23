package cn.com.views.inventoryselectview;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import cn.com.dto.WarePartsInfoDto;
import cn.com.listeners.CloseView_ActionListener;
import cn.com.services.WarehouseInfoServiceInf;
import cn.com.services.impl.WarehouseInfoServiceImpl;
import cn.com.utils.Center;

public class btnStatJDialog extends JDialog{

	private JPanel pnlMain;
	private JPanel pnlN;
	private JPanel pnlC;
	private JPanel pnlS;

	//北
	private JButton btnExport;
	private JButton btnQuit;

	//中心
	private JLabel lblMonth;
	private JLabel lblOne;
	private JLabel lblTwo;
	private JLabel lblThree;
	private JLabel lblFour;
	private JLabel lblWare;

	private JButton btnSearch;

	//南
	private JTable tabWare;
	private DefaultTableModel dtmWare;

	private JScrollPane snpView;
	private JTextField txtParts;

	private WarehouseInfoServiceInf service;
	private JLabel lblParts;

	public JTextField getTxtParts() {
		return txtParts;
	}

	public btnStatJDialog(Frame f,String title,boolean bool){

		super(f,title,bool);
		pnlMain = new JPanel();
		pnlN = new JPanel(null);
		pnlC = new JPanel(null);
		pnlS = new JPanel(null);
		//北
		//btnExport = new JButton("导出");
		btnQuit = new JButton(){
			protected void paintComponent(Graphics g){
				Image img = new ImageIcon("images/Quit.png").getImage();
				g.drawImage(img, 0, 0,60,65,this);
			}
		};


		btnSearch = new JButton(){
			protected void paintComponent(Graphics g){
				Image img = new ImageIcon("images/Search.png").getImage();
				g.drawImage(img, 0, 0,60,65,this);
			}
		};
		//南
		tabWare = new JTable();
		dtmWare = new DefaultTableModel();

		lblParts = new JLabel("配件名称查找:");
		txtParts = new JTextField();

		snpView = new JScrollPane(tabWare);

		service = new WarehouseInfoServiceImpl();
		init();
	}

	private void init() {
		// TODO Auto-generated method stub

		this.setResizable(false);
		this.setSize(1000, 650);
		pnlN.setBorder(BorderFactory.createRaisedBevelBorder());//分界线
		pnlC.setBorder(BorderFactory.createRaisedBevelBorder());

		pnlN.setPreferredSize(new Dimension(1000,75));//北面板大小
		pnlC.setPreferredSize(new Dimension(1000,55));
		pnlS.setPreferredSize(new Dimension(1000,510));

		Center.centerByWindow(this);

		btnQuit.addActionListener(new CloseView_ActionListener(this));
		//北
		//pnlN.add(btnExport);
		pnlN.add(btnQuit);

		//btnExport.setFont(new Font("宋体",Font.BOLD,18));
		btnQuit.setFont(new Font("宋体",Font.BOLD,18));


		//setCmbDate();

		/*cmbYearThree.setSelectedIndex(17);*/

		//中心
		/*pnlC.add(lblMonth);
		pnlC.add(lblOne);
		pnlC.add(lblTwo);
		pnlC.add(lblThree);
		pnlC.add(lblFour);
		pnlC.add(lblWare);*/
		pnlC.add(lblParts);
		/*lblMonth.setFont(new Font("宋体",Font.BOLD,14));
		lblOne.setFont(new Font("宋体",Font.BOLD,14));
		lblTwo.setFont(new Font("宋体",Font.BOLD,14));
		lblThree.setFont(new Font("宋体",Font.BOLD,14));
		lblFour.setFont(new Font("宋体",Font.BOLD,14));
		lblWare.setFont(new Font("宋体",Font.BOLD,14));*/
		lblParts.setFont(new Font("宋体",Font.BOLD,14));

		setTableDate(service.getAllWareStatPartInfoService());
		/*pnlC.add(cmbYearOne);
		pnlC.add(cmbYearTwo);
		pnlC.add(cmbYearThree);
		pnlC.add(cmbYearFour);
		pnlC.add(cmbWare);*/
		pnlC.add(txtParts);
		pnlC.add(btnSearch);

		/*cmbYearOne.setFont(new Font("宋体",Font.BOLD,16));
		cmbYearTwo.setFont(new Font("宋体",Font.BOLD,16));
		cmbYearThree.setFont(new Font("宋体",Font.BOLD,16));
		cmbYearFour.setFont(new Font("宋体",Font.BOLD,16));
		cmbWare.setFont(new Font("宋体",Font.BOLD,16));*/

		btnSearch.setFont(new Font("宋体",Font.BOLD,16));
		btnSearch.setBackground(Color.BLUE);

		//南
		pnlS.add(snpView);

		//北
		//btnExport.setBounds(30, 3, 60, 65);
		btnQuit.setBounds(800, 3, 60, 65);

		//中心
	/*	lblMonth.setBounds(30,3, 75, 45);
		cmbYearOne.setBounds(110, 10, 90, 30);
		lblOne.setBounds(205,3,25,45);//年
		cmbYearTwo.setBounds(235,10,60,30);
		lblTwo.setBounds(300,3,40,45);//月至
		cmbYearThree.setBounds(345,10,80,30);
		lblThree.setBounds(430,3,25,45);//年
		cmbYearFour.setBounds(460,10,60,30);
		lblFour.setBounds(525,3,25,45);//月
		lblWare.setBounds(575,3,65,45);//仓库名称
		cmbWare.setBounds(650,10,105,30);
		*/
		lblParts.setBounds(200,8,100,35);
		txtParts.setBounds(300,8,150,35);
		btnSearch.setBounds(500,8,75,35);

		snpView.setBounds(0, 0, 1000, 510);


		btnSearch.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				search();
			}

		});


		this.add(pnlMain);
		pnlMain.add(pnlN);
		pnlMain.add(pnlC);
		pnlMain.add(pnlS);
		this.setVisible(true);
	}


	protected void search() {
		// TODO Auto-generated method stub
		String parts_name = this.getTxtParts().getText().trim();
		List<WarePartsInfoDto> list = service.getWareStatInfoByParts_nameServiceImpl(parts_name);
		this.setTableDate(list);
	}

/*	private void setCmbDate() {
		// TODO Auto-generated method stub
		for(int i = 2004;i<=2021;i++){
			this.dcmYearOne.addElement(i);
			this.dcmYearThree.addElement(i);

		}

		this.cmbYearOne.setModel(dcmYearOne);
		this.cmbYearThree.setModel(dcmYearThree);

		for(int i = 1;i<=12;i++){
			this.dcmYearTwo.addElement(i);

			this.dcmYearFour.addElement(i);
		}

		this.cmbYearTwo.setModel(dcmYearTwo);
		this.cmbYearFour.setModel(dcmYearFour);

		this.dcmWare.addElement("所有仓库");
		this.dcmWare.addElement("主仓库");
		this.dcmWare.addElement("配件附库");
		this.cmbWare.setModel(dcmWare);
	}*/

	private void setTableDate(List<WarePartsInfoDto> list) {
		// TODO Auto-generated method stub
		Vector<String> colNames = new Vector<String>();
		colNames.add("配件ID");
		colNames.add("配件名称");
		//colNames.add("型号类型");
		colNames.add("配件进价");
		colNames.add("配件售价");
		colNames.add("占用容量");
		colNames.add("配件数量");

		Vector<Vector> datas = new Vector();
		Vector row = null;

		for(WarePartsInfoDto pb : list) {
			row = new Vector();
			row.add(pb.getParts_id());
			row.add(pb.getParts_name());
			//row.add(pb.getModle_type());
			row.add(pb.getPurchase_price());
			row.add(pb.getSelling_price());
			row.add(pb.getModle_capacity());
			row.add(pb.getParts_num());

			datas.add(row);
		}
		dtmWare = new DefaultTableModel(datas,colNames);
		this.tabWare.setModel(dtmWare);
	}
}
