package cn.com.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cn.com.listeners.PnlSellView_BtnAccountActionListener;
import cn.com.listeners.PnlSellView_BtnUserActionListener;
import cn.com.views.Systemview.BtnPartsView;
import cn.com.views.Systemview.btnAddUserJDialog;
import cn.com.views.inventoryselectview.btnSearchJFrame;
import cn.com.views.sellview.AccountView;
import cn.com.views.sellview.SellBackView;
import cn.com.views.sellview.SellView;
import cn.com.views.statistic.Billreaserch_View;
import cn.com.views.warehouseview.btnWareJDialog;

/*
销售面板类
 */

public class pnlSellView extends JPanel{
	private MainView mv;


    private JPanel pnlMain;
    private JPanel pnlN;
    private JPanel pnlC;
    private JPanel pnlL;
    private JPanel pnlR;
    private JPanel pnlS;
    private JLabel lblTitle;
    private JButton btnPartsSell;//配件销售
    private JButton btnReturned;//顾客退货
    private JButton btnAccount;//往来账务
    private JButton btnSaleDocuments;//销售单据查询
    private JButton btnStore;//当前库存查询
    private JButton btnPartsInfo;//配件信息
    private JButton btnCustomer; //客户设置
    private JButton btnStoreSet;//仓库设置
    private JButton btnStaff;//员工信息
    private AccountView accountView;
    private btnAddUserJDialog btnAdd;

    public pnlSellView(AccountView accountView){
        this.accountView = accountView;
    }
    public pnlSellView(btnAddUserJDialog btnAdd){
        this.btnAdd = btnAdd;
    }

    public pnlSellView(LayoutManager lm){
        super(lm);
        pnlN = new JPanel();
        pnlC = new JPanel(new BorderLayout());
        pnlL = new JPanel(null);
        pnlR = new JPanel(null);
        pnlS = new JPanel(null);
        lblTitle = new JLabel("销售管理");

        btnPartsSell  = new JButton("配件销售");
        btnReturned = new JButton("顾客退货");
        btnAccount = new JButton("往来账务");
        btnSaleDocuments = new JButton("销售单据");
        btnStore = new JButton("当前库存");

        btnPartsInfo = new JButton("配件信息");
        btnCustomer = new JButton("客户设置");
        btnStoreSet = new JButton("仓库设置");
        btnStaff = new JButton("员工信息");
       // lblImage = new JLabel(new ImageIcon("images/warehouse.png"));
        init();
    }
    

    public JButton getBtnPartsSell() {
        return btnPartsSell;
    }

    public JButton getBtnReturned() {
        return btnReturned;
    }

    public JButton  getBtnAccount() {
        return btnAccount;
    }

    public JButton getBtnSaleDocuments() {
        return btnSaleDocuments;
    }

    public JButton getBtnStore() {
        return btnStore;
    }

    public JButton getBtnPartsInfo() {
        return btnPartsInfo;
    }

    public JButton getBtnCustomer() {
        return btnCustomer;
    }

    public JButton getBtnStoreSet() {
        return btnStoreSet;
    }

    public JButton getBtnStaff() {
        return btnStaff;
    }



    private void init() {
        pnlN.setBorder(BorderFactory.createRaisedBevelBorder());
        pnlS.setBorder(BorderFactory.createRaisedBevelBorder());
        btnPartsSell.setBounds(170, 150, 100, 50);
            btnReturned.setBounds(170, 350, 100, 50);
            btnAccount.setBounds(170, 150, 100, 50);
            btnSaleDocuments.setBounds(170, 250, 100, 50);
            btnStore.setBounds(170, 350, 100, 50);
            btnPartsInfo.setBounds(100, 35, 150, 50);
            btnCustomer.setBounds(400,35,150, 50);
            btnStoreSet.setBounds(600,35,150, 50);
            btnStaff.setBounds(900,35,150, 50);


        btnAccount.addActionListener(new PnlSellView_BtnAccountActionListener(accountView));
        btnStaff.addActionListener(new PnlSellView_BtnUserActionListener(btnAdd));
          
            btnPartsSell.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new SellView(new Frame(), "零件销售", true);
				}
			});
            
            btnSaleDocuments.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new Billreaserch_View();
				}
			});
            btnReturned.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SellBackView(new Frame(), "销售退货", true);
			}
		});
            
            btnStore.addActionListener(new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				// TODO Auto-generated method stub
    				new btnSearchJFrame(new Frame(), "库存查询", true);
    			}
    		});
            btnPartsInfo.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new BtnPartsView(new Frame(), "配件信息", true);
				}
			});
    		btnStoreSet.addActionListener(new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				// TODO Auto-generated method stub
    				new btnWareJDialog(new Frame(), "仓库设置", true);
    			}
    		});

        lblTitle.setFont(new Font("宋体",Font.BOLD,35));
        btnPartsSell.setFont(new Font("宋体",Font.BOLD,15));
        btnReturned.setFont(new Font("宋体",Font.BOLD,15));
        btnAccount.setFont(new Font("宋体",Font.BOLD,15));
        btnSaleDocuments.setFont(new Font("宋体",Font.BOLD,15));
        btnStore.setFont(new Font("宋体",Font.BOLD,15));
        btnPartsInfo.setFont(new Font("宋体",Font.BOLD,22));
        btnCustomer.setFont(new Font("宋体",Font.BOLD,22));
        btnStoreSet.setFont(new Font("宋体",Font.BOLD,22));
        btnStaff.setFont(new Font("宋体",Font.BOLD,22));

        pnlN.setPreferredSize(new Dimension(900,80));
        pnlC.setPreferredSize(new Dimension(900,580));
        pnlL.setPreferredSize(new Dimension(450,580));
        pnlR.setPreferredSize(new Dimension(450,580));
        pnlS.setPreferredSize(new Dimension(900,120));

        lblTitle.setForeground(Color.RED);
        btnPartsSell.setForeground(Color.BLUE);
        btnReturned.setForeground(Color.BLUE);
        btnAccount.setForeground(Color.BLUE);
        btnSaleDocuments.setForeground(Color.BLUE);
        btnStore.setForeground(Color.BLUE);
        btnPartsInfo.setForeground(Color.BLUE);
        btnCustomer.setForeground(Color.BLUE);
        btnStoreSet.setForeground(Color.BLUE);
        btnStaff.setForeground(Color.BLUE);

        pnlN.add(lblTitle);
        pnlL.add(btnPartsSell);
        pnlL.add(btnReturned);
        pnlR.add(btnAccount);
        pnlR.add(btnSaleDocuments);
        pnlR.add(btnStore);
        pnlS.add(btnPartsInfo);
        pnlS.add(btnCustomer);
        pnlS.add(btnStoreSet);
        pnlS.add(btnStaff);
        pnlC.add(pnlL,BorderLayout.WEST);
        pnlC.add(pnlR,BorderLayout.EAST);

        this.add(pnlC,BorderLayout.CENTER);
        this.add(pnlN,BorderLayout.NORTH);
        this.add(pnlS,BorderLayout.SOUTH);
    }
}
