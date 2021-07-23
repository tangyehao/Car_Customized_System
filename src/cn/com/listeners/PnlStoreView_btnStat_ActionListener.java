package cn.com.listeners;

import cn.com.actions.Action;
import cn.com.actions.ActionFactory;
import cn.com.views.PnlStoreView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PnlStoreView_btnStat_ActionListener implements ActionListener {
	
	private PnlStoreView pv;
	private Action action;
	
	public PnlStoreView_btnStat_ActionListener(PnlStoreView pv){
		this.pv = pv;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		action = ActionFactory.createPnlStoreView_btnStat_Action();
		action.execute(e, pv);
	}

}
