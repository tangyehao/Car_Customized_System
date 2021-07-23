package cn.com.listeners;

import cn.com.actions.Action;
import cn.com.actions.ActionFactory;
import cn.com.views.PnlSystemView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PnlSystemView_btnClient_ActionListener implements ActionListener {
	private PnlSystemView psv;
	private Action action;
	
	public PnlSystemView_btnClient_ActionListener(PnlSystemView psv) {
		// TODO Auto-generated constructor stub
		super();
		this.psv = psv;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		action = ActionFactory.createPnlSystemView_btnClient_Action();
		action.execute(e, psv);
	}

}
