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

	//��
	private JButton btnExport;
	private JButton btnQuit;

	//����
	private JLabel lblMonth;
	private JLabel lblOne;
	private JLabel lblTwo;
	private JLabel lblThree;
	private JLabel lblFour;
	private JLabel lblWare;

	private JButton btnSearch;

	//��
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
		//��
		//btnExport = new JButton("����");
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
		//��
		tabWare = new JTable();
		dtmWare = new DefaultTableModel();

		lblParts = new JLabel("������Ʋ���:");
		txtParts = new JTextField();

		snpView = new JScrollPane(tabWare);

		service = new WarehouseInfoServiceImpl();
		init();
	}

	private void init() {
		// TODO Auto-generated method stub

		this.setResizable(false);
		this.setSize(1000, 650);
		pnlN.setBorder(BorderFactory.createRaisedBevelBorder());//�ֽ���
		pnlC.setBorder(BorderFactory.createRaisedBevelBorder());

		pnlN.setPreferredSize(new Dimension(1000,75));//������С
		pnlC.setPreferredSize(new Dimension(1000,55));
		pnlS.setPreferredSize(new Dimension(1000,510));

		Center.centerByWindow(this);

		btnQuit.addActionListener(new CloseView_ActionListener(this));
		//��
		//pnlN.add(btnExport);
		pnlN.add(btnQuit);

		//btnExport.setFont(new Font("����",Font.BOLD,18));
		btnQuit.setFont(new Font("����",Font.BOLD,18));


		//setCmbDate();

		/*cmbYearThree.setSelectedIndex(17);*/

		//����
		/*pnlC.add(lblMonth);
		pnlC.add(lblOne);
		pnlC.add(lblTwo);
		pnlC.add(lblThree);
		pnlC.add(lblFour);
		pnlC.add(lblWare);*/
		pnlC.add(lblParts);
		/*lblMonth.setFont(new Font("����",Font.BOLD,14));
		lblOne.setFont(new Font("����",Font.BOLD,14));
		lblTwo.setFont(new Font("����",Font.BOLD,14));
		lblThree.setFont(new Font("����",Font.BOLD,14));
		lblFour.setFont(new Font("����",Font.BOLD,14));
		lblWare.setFont(new Font("����",Font.BOLD,14));*/
		lblParts.setFont(new Font("����",Font.BOLD,14));

		setTableDate(service.getAllWareStatPartInfoService());
		/*pnlC.add(cmbYearOne);
		pnlC.add(cmbYearTwo);
		pnlC.add(cmbYearThree);
		pnlC.add(cmbYearFour);
		pnlC.add(cmbWare);*/
		pnlC.add(txtParts);
		pnlC.add(btnSearch);

		/*cmbYearOne.setFont(new Font("����",Font.BOLD,16));
		cmbYearTwo.setFont(new Font("����",Font.BOLD,16));
		cmbYearThree.setFont(new Font("����",Font.BOLD,16));
		cmbYearFour.setFont(new Font("����",Font.BOLD,16));
		cmbWare.setFont(new Font("����",Font.BOLD,16));*/

		btnSearch.setFont(new Font("����",Font.BOLD,16));
		btnSearch.setBackground(Color.BLUE);

		//��
		pnlS.add(snpView);

		//��
		//btnExport.setBounds(30, 3, 60, 65);
		btnQuit.setBounds(800, 3, 60, 65);

		//����
	/*	lblMonth.setBounds(30,3, 75, 45);
		cmbYearOne.setBounds(110, 10, 90, 30);
		lblOne.setBounds(205,3,25,45);//��
		cmbYearTwo.setBounds(235,10,60,30);
		lblTwo.setBounds(300,3,40,45);//����
		cmbYearThree.setBounds(345,10,80,30);
		lblThree.setBounds(430,3,25,45);//��
		cmbYearFour.setBounds(460,10,60,30);
		lblFour.setBounds(525,3,25,45);//��
		lblWare.setBounds(575,3,65,45);//�ֿ�����
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

		this.dcmWare.addElement("���вֿ�");
		this.dcmWare.addElement("���ֿ�");
		this.dcmWare.addElement("�������");
		this.cmbWare.setModel(dcmWare);
	}*/

	private void setTableDate(List<WarePartsInfoDto> list) {
		// TODO Auto-generated method stub
		Vector<String> colNames = new Vector<String>();
		colNames.add("���ID");
		colNames.add("�������");
		//colNames.add("�ͺ�����");
		colNames.add("�������");
		colNames.add("����ۼ�");
		colNames.add("ռ������");
		colNames.add("�������");

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
