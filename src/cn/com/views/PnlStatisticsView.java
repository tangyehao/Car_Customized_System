package cn.com.views;

import cn.com.listeners.StatisticsView_Btn_ActionListener;
import javax.swing.*;
import java.awt.*;

/*
统计报表类
 */
public class PnlStatisticsView extends JPanel {
	private JButton offerStatisticBtn;
	
	private JButton btnBusinessAnalysis; 
	private JLabel  jlPicture;
	
	public JButton getOfferStatisticBtn() {
		return offerStatisticBtn;
	}

	public JButton getBtnBusinessAnalysis() {
		return btnBusinessAnalysis;
	}
	public PnlStatisticsView(){
		offerStatisticBtn = new JButton("单据查询");
		btnBusinessAnalysis = new JButton("营业分析");
		
		jlPicture = new JLabel(new ImageIcon("images/Statistic.jpg"));
		init();
	}
	public PnlStatisticsView(LayoutManager lm){
		super(lm);
		offerStatisticBtn  = new JButton("单据查询");
	}
	
	private void init() {
		if(this.getLayout() == null) {
			offerStatisticBtn.setBounds(100, 200, 100, 30);
			
			btnBusinessAnalysis.setBounds(100, 130, 200, 30);
			//fjlPicture.setBounds(300,300,300,300);
		}
		offerStatisticBtn.setFont(new Font("宋体",Font.BOLD,28));
		btnBusinessAnalysis.setFont(new Font("宋体",Font.BOLD,28));
		//this.add(jlPicture);
		this.add(offerStatisticBtn);
		this.add(btnBusinessAnalysis);
		
		offerStatisticBtn.addActionListener(new StatisticsView_Btn_ActionListener(this));
		btnBusinessAnalysis.addActionListener(new StatisticsView_Btn_ActionListener(this));
		
	}


}
