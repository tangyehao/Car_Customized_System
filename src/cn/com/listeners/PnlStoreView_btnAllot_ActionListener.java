package cn.com.listeners;

import cn.com.actions.Action;
import cn.com.actions.ActionFactory;
import cn.com.views.PnlStoreView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PnlStoreView_btnAllot_ActionListener implements ActionListener {
	
	private PnlStoreView iv;
	private Action action;
	
	public PnlStoreView_btnAllot_ActionListener(PnlStoreView iv){
		this.iv = iv;
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		action = ActionFactory.createPnlStoreView_btnAllot_Action();
		action.execute(e, iv);
	}

}
