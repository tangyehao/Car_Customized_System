package cn.com.listeners;

import cn.com.actions.Action;
import cn.com.actions.ActionFactory;
import cn.com.views.PnlStoreView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PnlStoreView_btnWare_ActionListener implements ActionListener {
	
	private PnlStoreView ps;
	private Action action;
	
	public PnlStoreView_btnWare_ActionListener(PnlStoreView ps){
		this.ps = ps;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		action = ActionFactory.createPnlStoreView_btnWare_Action();
		action.execute(e, ps);
	}

}
