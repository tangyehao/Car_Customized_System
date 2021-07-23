package cn.com.listeners;

import cn.com.actions.Action;
import cn.com.actions.ActionFactory;
import cn.com.views.PnlStatisticsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatisticsView_Btn_ActionListener implements ActionListener {
	private PnlStatisticsView ps;
	private Action action;
	public StatisticsView_Btn_ActionListener(PnlStatisticsView ps) {
		this.ps = ps;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == ps.getOfferStatisticBtn()) {
			action = ActionFactory.createOfferStatisticAction();
		}else if(obj == ps.getBtnBusinessAnalysis()){
			action = ActionFactory.createBusinessStatisticAction();
		}
		
		action.execute(e, ps);
	}

}
