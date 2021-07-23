package cn.com.views.statistic;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.EventObject;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import cn.com.beans.Bill;
import cn.com.dto.BillViewDto;
import cn.com.dto.PartDto;
import cn.com.services.BillManageServiceInf;
import cn.com.services.impl.BillManagerSerViceImp;
import cn.com.utils.Center;

public class Billreaserch_View extends JFrame {
	
	
	private JPanel pnltop ;
	private JPanel pnlmid ;
	private JPanel pnllow ;
	private JPanel pnlMain;
	private JLabel jlImportBillNo;
	private JLabel  jlbMesage;
	private JTextField jtImportBillNo;
	private JButton btnReaserch;
	private JButton btnTips ;
    private JScrollPane snpmidView;
    private JScrollPane snplowView;
    private JTable tabMidView;
    private JTable tabLowView;
    private DefaultTableModel dtmMidView;
    private Bill bill;
    private BillManageServiceInf service;
    private PartDto partdto;
    private BillViewDto billViewDto;
    

	public Billreaserch_View(){
		billViewDto = new BillViewDto();
		partdto = new PartDto();
		jlbMesage = new JLabel("详细信息");
		btnTips = new JButton(new ImageIcon("images/warn.jpg"));
		Center.centerByWindow(this);
		pnlMain = new JPanel(null);
		pnltop = new JPanel(null);
		jlImportBillNo = new JLabel();
		jtImportBillNo = new JTextField();
		btnReaserch = new JButton();
		tabMidView = new JTable();
		tabLowView = new JTable();
		snplowView = new JScrollPane(tabLowView);
		snpmidView = new JScrollPane(tabMidView);
		dtmMidView = new DefaultTableModel();
		bill = new Bill();
		
		init();
		Objectinit();
	}
	private void Objectinit() {
		// TODO Auto-generated method stub
		
	}
	private void init() {

		Center.centerByWindow(this);
		this.setResizable(false);
		this.setResizable(false);
		service = new BillManagerSerViceImp();
		// TODO Auto-generated method stub
		//tabMidView.setBounds(0, 130, 800, 300);
		jlbMesage.setBounds(10, 435, 200,20 );
		btnTips.setBounds(600, 10, 100, 66);
		pnltop.setBounds(0, 0, 800, 100);
		snpmidView.setBounds(0, 130, 800, 300);
		snplowView.setBounds(0,470, 800, 350);
		jlImportBillNo.setBounds(100, 30, 130, 30);
		jtImportBillNo.setBounds(250,30, 200, 30);
		btnReaserch.setBounds(470, 30, 100, 30);
		jlImportBillNo.setText("输入单据号:");;
		jlImportBillNo.setFont(new Font("宋体",Font.BOLD ,20));
		jlbMesage.setFont(new Font("宋体",Font.BOLD ,15));
		
		btnReaserch.setText("查询");
		btnReaserch.setFont(new Font("宋体",Font.BOLD ,20));
		
		
		setTabMidDataById(service.getbillByIDService());
		btnReaserch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					int i = Integer.parseInt(jtImportBillNo.getText());
					setTabMidDataById(service.getbillByIDService(i));
					
				}catch (Exception e1) {
					
				JOptionPane.showMessageDialog(null, "单号格式错误","系统提示",JOptionPane.ERROR_MESSAGE);
				}
			}
		}  );
		
		
		tabMidView.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				
				int value = (int) tabMidView.getValueAt(tabMidView.getSelectedRow(),0);
				
				setDataPnllow(service.getPartSerice(value));
				
		}
	});
		pnlMain.add(snplowView);
		
		btnTips.setToolTipText("双击订单显示订单配件详细信息");
		
		
		pnlMain.add(jlbMesage);
		pnlMain.add(pnltop);
		pnltop.add(jlImportBillNo);
		pnltop.add(jtImportBillNo);
		pnltop.add(btnReaserch);
		pnltop.add(btnTips);
		pnlMain.add(snpmidView);
	
		this.add(pnlMain);
		this.setTitle("单据查询");
		this.setBounds(0, 0, 800, 800);
		this.setVisible(true);
	    
		
		
	}
	
	
	protected void setDataPnllow(List<PartDto> partdto) {
		Vector<String> colNames = new Vector<String>();
		colNames.add("配件编号");
		colNames.add("配件名称");
		colNames.add("颜色");
		colNames.add("单价");
		colNames.add("数量");
		colNames.add("总金额");
		Vector<Vector>datas = new Vector<Vector>();
		Vector row = null ;
		if(partdto != null){
			for(PartDto p : partdto){
				row = new Vector();
				row.add(p.getPartIdDto());
				row.add(p.getPartNameDto());
				row.add(p.getPartColorDto());
				row.add(p.getPartPriceDto());
				row.add(p.getPartNumberDto());
				row.add(p.getPartTotalPriceDto());
				
				datas.add(row);
				
			}
		dtmMidView = new DefaultTableModel(datas,colNames);
		this.tabLowView.setModel(dtmMidView);
		}
	}
	protected void setTabMidDataById(List<BillViewDto>billViewDto ) {
		Vector<String> colNames = new Vector<String>();
		colNames.add("单据号");
		colNames.add("供货商/客户"); 
		colNames.add("应付金额");
		colNames.add("实付金额");
		colNames.add("拖欠款");
		colNames.add("经办人");
		colNames.add("账单标记");
		colNames.add("开单日期");
	
	
		
		Vector<Vector>datas = new Vector<Vector>();
		Vector row = null ;
		
		if(billViewDto != null){
			for(BillViewDto b : billViewDto){
				row = new Vector();
				row.add(b.getbIdDto());
				row.add(b.getClientorfactoryDto());
				row.add(b.getPayableDto());
				row.add(b.getPaidDto());
				row.add(b.getInArrearDto());
				row.add(b.getUserDto());
				row.add(b.getFlogNameDto());
				row.add(b.getDateDto());
				
				datas.add(row);
			}
		dtmMidView = new DefaultTableModel(datas,colNames);
		this.tabMidView.setModel(dtmMidView);
		
				}

		
	}
	protected void test() {
			new PartView();
		
	}
	



	}	

