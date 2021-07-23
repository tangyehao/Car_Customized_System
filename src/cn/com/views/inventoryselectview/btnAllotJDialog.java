package cn.com.views.inventoryselectview;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
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

import cn.com.beans.Modle;
import cn.com.beans.Parts;
import cn.com.beans.User;
import cn.com.dto.PartInventoryDto;
import cn.com.services.impl.ModleInfoServiceImpl;
import cn.com.services.impl.PartsInfoServiceImpl;
import cn.com.services.impl.UserBaseServiceImpl;
import cn.com.utils.Center;
import cn.com.views.Systemview.BtnPartsView;

public class btnAllotJDialog extends JDialog{
	private ModleInfoServiceImpl mService;
	private PartsInfoServiceImpl pService;
	private UserBaseServiceImpl uService;
	private btnAllotJDialog ajd;

	private JPanel pnlMain;
	private JPanel pnlN;
	private JPanel pnlC;
	private JPanel pnlS;

	private JLabel lblOutWare;
	private JLabel lblInWare;

	private JButton btnAdd;
	private JButton btnSure;
	private JButton btnQuit;

	private JScrollPane snpView;

	private JTable tabPart;
	private DefaultTableModel dtmPart;

	private JComboBox<String> cmbOutWare;
	private DefaultComboBoxModel<String> dcmOutWare;
	private JComboBox<String> cmbInWare;
	private DefaultComboBoxModel<String> dcmInWare;
	private JComboBox<String> cbxUser;
	private DefaultComboBoxModel<String> cbmUser;
	private JLabel lblHandler;
	private JLabel lblNote;

	private JTextField txtNote;
	private JPanel pnlSS;



	public btnAllotJDialog(Frame f,String title,boolean bool){
		super(f,title,bool);
		uService = new UserBaseServiceImpl();
		mService = new ModleInfoServiceImpl();
		pService = new PartsInfoServiceImpl();
		pnlMain = new JPanel();
		pnlN = new JPanel(null);
		pnlC = new JPanel(null);
		pnlS = new JPanel(null);
		pnlSS = new JPanel(null);
		ajd = this;
		lblOutWare = new JLabel("调出仓库:");
		lblInWare = new JLabel("调入仓库:");
		lblHandler = new JLabel("经办人:");
		lblNote = new JLabel("备注:");


		txtNote = new JTextField();

		cmbOutWare = new JComboBox<String>();
		dcmOutWare = new DefaultComboBoxModel<String>();

		cmbInWare = new JComboBox<String>();
		dcmInWare = new DefaultComboBoxModel<String>();


		btnAdd = new JButton("添加配件");
		btnSure = new JButton("确定");
		btnQuit = new JButton("退出");



		tabPart = new JTable(){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		dtmPart = new DefaultTableModel();

		snpView = new JScrollPane(tabPart);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(1000, 700);

		//pnlN.setBorder(BorderFactory.createRaisedBevelBorder());//分界线
		pnlC.setBorder(BorderFactory.createRaisedBevelBorder());
		pnlSS.setBorder(BorderFactory.createRaisedBevelBorder());

		pnlN.setPreferredSize(new Dimension(1000,75));//北面板大小
		pnlC.setPreferredSize(new Dimension(1000,55));
		pnlS.setPreferredSize(new Dimension(1000,400));
		pnlSS.setPreferredSize(new Dimension(1000,120));


		Center.centerByWindow(this);

		lblOutWare.setFont(new Font("宋体",Font.BOLD,14));
		lblInWare.setFont(new Font("宋体",Font.BOLD,14));
		lblHandler.setFont(new Font("宋体",Font.BOLD,14));
		lblNote.setFont(new Font("宋体",Font.BOLD,14));

		btnAdd.setFont(new Font("宋体",Font.BOLD,14));
		btnSure.setFont(new Font("宋体",Font.BOLD,14));
		btnQuit.setFont(new Font("宋体",Font.BOLD,14));

		lblOutWare.setBounds(30, 8, 75, 45);
		cmbOutWare.setBounds(110,15,150,30);

		lblInWare.setBounds(320,8,75,45);
		cmbInWare.setBounds(400,15,150,30);

		btnAdd.setBounds(30, 5,90, 45);

		snpView.setBounds(30, 0, 940, 400);

		setTable(pService.getAllPartsInfoService(),1);
		setCmbDate();

		lblHandler.setBounds(30,5,70,45);
		cbxUser.setBounds(115,10,180,30);
		lblNote.setBounds(320,5,65,45);
		txtNote.setBounds(390,10,580,30);

		btnSure.setBounds(650, 60, 75, 45);
		btnQuit.setBounds(800, 60, 75, 45);

		pnlN.add(lblOutWare);
		pnlN.add(cmbOutWare);
		pnlN.add(lblInWare);
		pnlN.add(cmbInWare);

		pnlC.add(btnAdd);

		pnlS.add(snpView);

		pnlSS.add(lblHandler);
		pnlSS.add(cbxUser);
		pnlSS.add(lblNote);
		pnlSS.add(txtNote);
		pnlSS.add(btnSure);
		pnlSS.add(btnQuit);

		pnlMain.add(pnlN);
		pnlMain.add(pnlC);
		pnlMain.add(pnlS);
		pnlMain.add(pnlSS);


		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new BtnPartsView(new Frame(), "配件导入", true,ajd);

			}
		});

		this.add(pnlMain);
		this.setVisible(true);

	}

	private void setCmbDate() {
		// TODO Auto-generated method stub

		this.dcmOutWare.addElement("主仓库");
		this.dcmOutWare.addElement("配件附库");
		this.cmbOutWare.setModel(dcmOutWare);
		this.cmbOutWare.setFont(new Font("宋体",Font.BOLD,14));

		this.dcmInWare.addElement("主仓库");
		this.dcmInWare.addElement("配件附库");
		this.cmbInWare.setModel(dcmInWare);
		this.cmbInWare.setFont(new Font("宋体",Font.BOLD,14));

		cbmUser = new DefaultComboBoxModel<String>();
		cbxUser = new JComboBox<String>();

		cbmUser = new DefaultComboBoxModel<String>();
		cbxUser.setModel(cbmUser);
		List<User> listU = new ArrayList<User>();
		listU = uService.getAllUsers();
		for(User u:listU) {
			cbmUser.addElement(u.getuName());
		}


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
		dtmPart = new DefaultTableModel(dates,colNames);
		tabPart.setModel(dtmPart);

	}
}
