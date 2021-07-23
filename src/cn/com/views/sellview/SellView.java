package cn.com.views.sellview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.com.beans.Firm;
import cn.com.beans.Modle;
import cn.com.beans.Parts;
import cn.com.beans.User;
import cn.com.services.FirmManageServiseInf;
import cn.com.services.impl.FirmManageServiseImpl;
import cn.com.services.impl.ModleInfoServiceImpl;
import cn.com.services.impl.PartsInfoServiceImpl;
import cn.com.services.impl.UserBaseServiceImpl;
import cn.com.utils.Center;
import cn.com.utils.DateChooserJButton;
import cn.com.views.Systemview.BtnPartsView;

public class SellView extends JDialog{
	private Firm f;
	private User u;
	private SellView sv;

	private ModleInfoServiceImpl mService;
	private PartsInfoServiceImpl pService;
	private JPanel pnlMain;
	private JPanel pnlN;
	private JPanel pnlC;
	private JPanel pnlS;
	private JPanel pnlNN;
	private JPanel pnlNS;
	private JPanel pnlNC;

	private JLabel lblTitle;
	private JLabel lblFirm;
	private JLabel lblDate;
	private JLabel lblPay;
	private JLabel lblPaid;
	private JLabel lblUser;
	private JLabel lblNub;
	private JLabel lblNote;

	private JButton btnPartsAdd;
	private JButton btnSave;
	private JButton btnQuit;

	private DateChooserJButton  btnDate;
	private JTextField txtPay;
	private JTextField txtPaid;
	private JTextField txtNub;
	private JTextField txtNote;

	private JComboBox<String> cbxFirm;
	private DefaultComboBoxModel<String> cbmFirm;
	private JComboBox<String> cbxUser;
	private DefaultComboBoxModel<String> cbmUser;

	private JScrollPane snpInfo;
	private JTable tabParts;
	private DefaultTableModel tmdParts;

	private FirmManageServiseInf service;
	private UserBaseServiceImpl uService;

	public SellView(Frame f,String title,boolean bool){
		super(f,title,bool);
		mService = new ModleInfoServiceImpl();
		pService = new PartsInfoServiceImpl();
		service  = new FirmManageServiseImpl();
		uService = new UserBaseServiceImpl();
		tabParts = new JTable();
		sv = this;
		snpInfo = new JScrollPane(tabParts);

		pnlMain = new JPanel(new BorderLayout());
		pnlN = new JPanel(new BorderLayout());
		pnlC = new JPanel(null);
		pnlS = new JPanel(null);
		pnlNN = new JPanel();
		pnlNS = new JPanel();
		pnlNC = new JPanel(null);

		lblTitle = new JLabel("配件销售");
		lblFirm = new JLabel("供应商:");
		lblDate = new JLabel("收货日期:");
		lblPay = new JLabel("应付金额:");
		lblPaid = new JLabel("实付金额:");
		lblUser = new JLabel("经办人:");
		lblNub = new JLabel("单号:");
		lblNote = new JLabel("备注:");

		btnPartsAdd = new JButton("配件导入");
		btnSave = new JButton("保存");
		btnQuit = new JButton("取消");

		btnDate = new DateChooserJButton (this);
		txtPay = new JTextField();
		txtPaid = new JTextField();
		txtNub = new JTextField();
		txtNote = new JTextField();




		init();

	}

	private void init() {
		// TODO Auto-generated method stub
		this.setResizable(false);
		this.setSize(1000, 650);

		setModle();

		setTable(pService.getAllPartsInfoService(),1);

		lblTitle.setForeground(Color.RED);

		lblTitle.setFont(new Font("宋体",Font.BOLD,24));
		btnPartsAdd.setFont(new Font("宋体",Font.BOLD,14));

		pnlN.setPreferredSize(new Dimension(1000,150));//北面板大小
		pnlC.setPreferredSize(new Dimension(1000,400));
		pnlS.setPreferredSize(new Dimension(1000,100));
		pnlNN.setPreferredSize(new Dimension(1000,40));
		pnlNC.setPreferredSize(new Dimension(1000,80));
		pnlNS.setPreferredSize(new Dimension(1000,30));

		Center.centerByWindow(this);

		pnlMain.add(pnlN,BorderLayout.NORTH);
		pnlMain.add(pnlC,BorderLayout.CENTER);
		pnlMain.add(pnlS,BorderLayout.SOUTH);

		pnlN.add(pnlNN,BorderLayout.NORTH);
		pnlN.add(pnlNC,BorderLayout.CENTER);
		pnlN.add(pnlNS,BorderLayout.SOUTH);

		pnlNN.add(lblTitle);
		pnlNC.add(lblFirm);
		pnlNC.add(lblDate);
		pnlNC.add(cbxFirm);
		pnlNC.add(btnDate);
		pnlNS.add(btnPartsAdd);

		pnlS.add(lblPaid);
		pnlS.add(lblPay);
		pnlS.add(lblUser);
		pnlS.add(lblNub);
		pnlS.add(lblNote);
		pnlS.add(txtPay);
		pnlS.add(txtPaid);
		pnlS.add(cbxUser);
		pnlS.add(txtNub);
		pnlS.add(txtNote);
		pnlS.add(btnSave);
		pnlS.add(btnQuit);

		lblFirm.setBounds(100, 30, 50, 30);
		cbxFirm.setBounds(150, 30, 200, 30);
		lblDate.setBounds(500, 30, 60, 30);
		btnDate.setBounds(560, 30, 200, 30);

		lblPay.setBounds(20,20,60,30);
		txtPay.setBounds(80, 20, 150, 30);
		lblPaid.setBounds(240, 20, 60, 30);
		txtPaid.setBounds(300, 20, 150, 30);
		lblUser.setBounds(470, 20, 60, 30);
		cbxUser.setBounds(520, 20, 150, 30);
		lblNub.setBounds(700, 20, 60, 30);
		txtNub.setBounds(740, 20, 150, 30);

		lblNote.setBounds(20, 60, 60, 30);
		txtNote.setBounds(80, 60, 600, 30);
		btnSave.setBounds(750, 60, 70, 30);
		btnQuit.setBounds(850, 60, 70, 30);

		snpInfo.setBounds(0, 0, 1000, 400);


		pnlC.add(snpInfo);

		this.add(pnlMain);
		btnPartsAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new BtnPartsView(new Frame(), "配件导入", true,sv);

			}
		});
		this.setVisible(true);
		this.setVisible(true);

	}

	public void setTable(List<Parts> list,int num) {
		// TODO Auto-generated method stub
		Vector<String> colNames = new Vector<String>();
		colNames.add("配件编号");
		colNames.add("配件名称");
		colNames.add("颜色");
		colNames.add("单价");
		colNames.add("数量");
		colNames.add("总金额");
		colNames.add("配件类型");
		colNames.add("备注");

		Vector<Vector> dates = new Vector();
		if(list != null){
			Vector row = null;
			for(Parts f:list){

				List<Modle> modle = mService.modleExportById(f.getpModle());
				Modle m = modle.get(0);
				int price = m.getmPurchasePrice();
				int np = price*num;
				row = new Vector();
				row.add(f);
				row.add(f.getpName());
				row.add(f.getpColour());
				row.add(price);
				row.add(num);
				row.add(np);
				row.add(m.getmName());
				dates.add(row);
			}
		}
		tmdParts = new DefaultTableModel(dates,colNames);
		tabParts.setModel(tmdParts);

	}

	private void setModle() {
		// TODO Auto-generated method stub
		cbxFirm = new JComboBox<String>();
		cbxUser = new JComboBox<String>();
		cbmFirm = new DefaultComboBoxModel<String>();
		cbmUser = new DefaultComboBoxModel<String>();

		cbxFirm.setModel(cbmFirm);
		cbxUser.setModel(cbmUser);

		List<Firm> listF = new ArrayList<Firm>();
		listF = service.firmExport();
		for(Firm f:listF){
			cbmFirm.addElement(f.getfName());
		}
		List<User> listU = new ArrayList<User>();
		listU = uService.getAllUsers();
		for(User u:listU) {
			cbmUser.addElement(u.getuName());
		}


	}


}
