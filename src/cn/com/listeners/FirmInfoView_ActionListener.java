package cn.com.listeners;

import cn.com.actions.Action;
import cn.com.actions.ActionFactory;
import cn.com.views.PnlPurchaseView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirmInfoView_ActionListener implements ActionListener{
	private PnlPurchaseView sv;
	private Action action;
	
	public FirmInfoView_ActionListener(PnlPurchaseView sv){
		this.sv = sv;
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		action = ActionFactory.createFirmView_Action();
		action.execute(e, sv);
	}
}
