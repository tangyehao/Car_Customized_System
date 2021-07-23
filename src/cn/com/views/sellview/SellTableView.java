package cn.com.views.sellview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
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
import cn.com.beans.User;
import cn.com.utils.Center;
import cn.com.utils.DateChooserJButton;

public class SellTableView extends JDialog{

	
	
	private JPanel pnlMain;
	private JPanel pnlN;
	private JPanel pnlC;
	private JPanel pnlS;

	
	
	private JLabel lblFrist;
	private JLabel lblLast;
	private JLabel lblSelect;
	
	private JButton btnSelect;
	private DateChooserJButton  btnDate1;
	private DateChooserJButton  btnDate2;
	
	private JTextField txtSelect;


	
	private JScrollPane snpFirm;
	private JScrollPane snpParts;
	private JTable txtFirm;
	private JTable txtPrits;
	private DefaultTableModel tmdFirm;
	private DefaultTableModel tmdParts;
	
	public SellTableView(Frame f,String title,boolean bool){
		super(f,title,bool);
		
		txtFirm = new JTable();
		txtPrits = new JTable();
		
		snpFirm = new JScrollPane(txtFirm);
		snpParts = new JScrollPane(txtPrits);
		
		pnlMain = new JPanel(new BorderLayout());
		pnlN = new JPanel(null);
		pnlC = new JPanel(null);
		pnlS = new JPanel(null);


		lblFrist = new JLabel("查询日期:");
		lblLast = new JLabel("至");
		lblSelect = new JLabel("按供货商/单号查询:");
		
		btnSelect = new JButton("查询");

		
		btnDate1 = new DateChooserJButton (this);
		btnDate2 = new DateChooserJButton (this);
		
		txtSelect = new JTextField();
	
		init();
	
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setResizable(false);
		this.setSize(1000, 650);
		
		
		setTable();
		

		btnSelect.setFont(new Font("宋体",Font.BOLD,14));
		
		pnlN.setPreferredSize(new Dimension(1000,50));//北面板大小
		pnlC.setPreferredSize(new Dimension(1000,400));
		pnlS.setPreferredSize(new Dimension(1000,200));

		
		Center.centerByWindow(this);
		
		pnlMain.add(pnlN,BorderLayout.NORTH);
		pnlMain.add(pnlC,BorderLayout.CENTER);
		pnlMain.add(pnlS,BorderLayout.SOUTH);
		


		pnlN.add(btnDate1);
		pnlN.add(btnDate2);
		pnlN.add(btnSelect);
		pnlN.add(txtSelect);
		pnlN.add(lblSelect);
		pnlN.add(lblFrist);
		pnlN.add(lblLast);
		
		pnlC.add(snpFirm);
		pnlS.add(snpParts);




		btnDate1.setBounds(80, 20, 150, 30);
		btnDate2.setBounds(250, 20, 150, 30);

		lblFrist.setBounds(20, 20, 60, 30);
		lblLast.setBounds(333, 20, 20, 30);
		lblSelect.setBounds(420, 20, 120, 30);
		txtSelect.setBounds(540, 20, 300, 30);
		btnSelect.setBounds(900, 20, 50, 30);
		
		
		snpFirm.setBounds(0, 20, 1000, 350);
		snpParts.setBounds(0, 0, 1000, 250);
		
		
		this.add(pnlMain);
		this.setVisible(true);
		
	}

	private void setTable() {
		// TODO Auto-generated method stub
		Vector<String> colNames1 = new Vector<String>();
		colNames1.add("单据号");
		colNames1.add("开单日期");
		colNames1.add("供货商名称");
		colNames1.add("应付金额");
		colNames1.add("实付金额");
		colNames1.add("总金额");
		colNames1.add("单据类型");
		colNames1.add("经办人");
		colNames1.add("备注");
		Vector<Vector> datas = new Vector();
		tmdFirm = new DefaultTableModel(datas,colNames1);
		txtFirm.setModel(tmdFirm);
		
		Vector<String> colNames2 = new Vector<String>();
		colNames2.add("配件编号");
		colNames2.add("配件名称");
		colNames2.add("颜色");
		colNames2.add("单价");
		colNames2.add("数量");
		colNames2.add("总金额");
		colNames2.add("配件类型");
		Vector<Vector> datas2 = new Vector();
		tmdParts = new DefaultTableModel(datas2,colNames2);
		txtPrits.setModel(tmdParts);
		
	}

}
