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
		jlbMesage = new JLabel("��ϸ��Ϣ");
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
		jlImportBillNo.setText("���뵥�ݺ�:");;
		jlImportBillNo.setFont(new Font("����",Font.BOLD ,20));
		jlbMesage.setFont(new Font("����",Font.BOLD ,15));
		
		btnReaserch.setText("��ѯ");
		btnReaserch.setFont(new Font("����",Font.BOLD ,20));
		
		
		setTabMidDataById(service.getbillByIDService());
		btnReaserch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					int i = Integer.parseInt(jtImportBillNo.getText());
					setTabMidDataById(service.getbillByIDService(i));
					
				}catch (Exception e1) {
					
				JOptionPane.showMessageDialog(null, "���Ÿ�ʽ����","ϵͳ��ʾ",JOptionPane.ERROR_MESSAGE);
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
		
		btnTips.setToolTipText("˫��������ʾ���������ϸ��Ϣ");
		
		
		pnlMain.add(jlbMesage);
		pnlMain.add(pnltop);
		pnltop.add(jlImportBillNo);
		pnltop.add(jtImportBillNo);
		pnltop.add(btnReaserch);
		pnltop.add(btnTips);
		pnlMain.add(snpmidView);
	
		this.add(pnlMain);
		this.setTitle("���ݲ�ѯ");
		this.setBounds(0, 0, 800, 800);
		this.setVisible(true);
	    
		
		
	}
	
	
	protected void setDataPnllow(List<PartDto> partdto) {
		Vector<String> colNames = new Vector<String>();
		colNames.add("������");
		colNames.add("�������");
		colNames.add("��ɫ");
		colNames.add("����");
		colNames.add("����");
		colNames.add("�ܽ��");
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
		colNames.add("���ݺ�");
		colNames.add("������/�ͻ�"); 
		colNames.add("Ӧ�����");
		colNames.add("ʵ�����");
		colNames.add("��Ƿ��");
		colNames.add("������");
		colNames.add("�˵����");
		colNames.add("��������");
	
	
		
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

