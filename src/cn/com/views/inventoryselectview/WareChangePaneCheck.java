package cn.com.views.inventoryselectview;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cn.com.dto.WarePartsInfoDto;
import cn.com.utils.Center;

public class WareChangePaneCheck extends JDialog{
	
	private JPanel pnlMain;
	private JLabel lblPartsID;
	private JLabel lblPartsName;
	private JLabel lblPartsType;
	private JLabel lblPartsPrice;
	private JLabel lblPartsSale;
	private JLabel lblCap;
	private JLabel lblPartsID2;
	private JLabel lblPartsName2;
	private JLabel lblPartsType2;
	private JLabel lblPartsPrice2;
	private JLabel lblPartsSale2;
	private JLabel lblCap2;
	private WarePartsInfoDto wpi;
	
	public JPanel getPnlMain() {
		return pnlMain;
	}

	public JLabel getLblPartsID() {
		return lblPartsID;
	}

	public JLabel getLblPartsName() {
		return lblPartsName;
	}

	public JLabel getLblPartsType() {
		return lblPartsType;
	}

	public JLabel getLblPartsPrice() {
		return lblPartsPrice;
	}

	public JLabel getLblPartsSale() {
		return lblPartsSale;
	}

	public JLabel getLblCap() {
		return lblCap;
	}

	public JLabel getLblPartsID2() {
		return lblPartsID2;
	}

	public JLabel getLblPartsName2() {
		return lblPartsName2;
	}

	public JLabel getLblPartsType2() {
		return lblPartsType2;
	}

	public JLabel getLblPartsPrice2() {
		return lblPartsPrice2;
	}

	public JLabel getLblPartsSale2() {
		return lblPartsSale2;
	}

	public JLabel getLblCap2() {
		return lblCap2;
	}

	public WareChangePaneCheck(Frame f,String title,boolean bool,WarePartsInfoDto wpi){
		super(f,title,bool);
		pnlMain = new JPanel(null);
		lblPartsID = new JLabel("配件ID:");
		lblPartsName = new JLabel("配件名称:");
		lblPartsType = new JLabel("型号类型:");
		lblPartsPrice = new JLabel("配件进价:");
		lblPartsSale= new JLabel("配件售价:");
		lblCap = new JLabel("占用容量");
		this.wpi = wpi;
		lblPartsID2 = new JLabel(wpi.toString());
		lblPartsName2 = new JLabel(wpi.getParts_name());
		lblPartsType2 = new JLabel(wpi.getModle_type());
		lblPartsPrice2 = new JLabel(String.valueOf(wpi.getPurchase_price()));
		lblPartsSale2 = new JLabel(String.valueOf(wpi.getSelling_price()));
		lblCap2 = new JLabel(String.valueOf(wpi.getModle_capacity()));
		
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(300,350);
		this.setResizable(false);
		
		Center.centerByWindow(this);
		lblPartsID.setBounds(20,20, 85, 30);
		lblPartsID.setFont(new Font("宋体",Font.BOLD,14));
		lblPartsID2.setBounds(110,20,230,30);
		lblPartsID2.setFont(new Font("宋体",Font.BOLD,14));
		
		lblPartsName.setBounds(20, 65, 85, 30);
		lblPartsName.setFont(new Font("宋体",Font.BOLD,14));
		lblPartsName2.setBounds(110,65,230,30);
		lblPartsName2.setFont(new Font("宋体",Font.BOLD,14));
	/*	lblHandler.setEnabled(false);
		txtHandler.setEnabled(false);
		*/
		lblPartsType.setBounds(20,110,85,30);
		lblPartsType.setFont(new Font("宋体",Font.BOLD,14));
		lblPartsType2.setBounds(110,110,230,30);
		lblPartsType2.setFont(new Font("宋体",Font.BOLD,14));
		/*lblPhone.setEnabled(false);
		txtPhone.setEnabled(false);*/
		
		lblPartsPrice.setBounds(20,155,85,30);
		lblPartsPrice.setFont(new Font("宋体",Font.BOLD,14));
		lblPartsPrice2.setBounds(110,155,230,30);
		lblPartsPrice2.setFont(new Font("宋体",Font.BOLD,14));
		
		lblPartsSale.setBounds(20,200,85,30);
		lblPartsSale.setFont(new Font("宋体",Font.BOLD,14));
		lblPartsSale2.setBounds(110,200,230,30);
		lblPartsSale2.setFont(new Font("宋体",Font.BOLD,14));
		
		lblCap.setBounds(20,245,85,30);
		lblCap.setFont(new Font("宋体",Font.BOLD,14));
		lblCap2.setBounds(110,245,75,30);
		lblCap2.setFont(new Font("宋体",Font.BOLD,14));
		
		pnlMain.add(lblCap);
		pnlMain.add(lblCap2);
		pnlMain.add(lblPartsID);
		pnlMain.add(lblPartsID2);
		pnlMain.add(lblPartsName);
		pnlMain.add(lblPartsPrice);
		pnlMain.add(lblPartsName2);
		pnlMain.add(lblPartsPrice2);
		pnlMain.add(lblPartsSale);
		pnlMain.add(lblPartsSale2);
		pnlMain.add(lblPartsType);
		pnlMain.add(lblPartsType2);
		
		this.add(pnlMain);
		this.setVisible(true);
	}
}
