package cn.com.listeners;

import cn.com.actions.Action;
import cn.com.actions.ActionFactory;
import cn.com.views.PnlStoreView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PnlStoreView_btnSearch_ActionListener implements ActionListener {
	private PnlStoreView iv;
	private Action action;
	
	public PnlStoreView_btnSearch_ActionListener(PnlStoreView iv){
		this.iv = iv;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		action = ActionFactory.createInventoryView_btnSearch_Action();
		action.execute(e,iv);
	}

}
