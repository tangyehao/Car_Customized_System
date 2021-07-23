package cn.com.listeners;

import cn.com.actions.Action;
import cn.com.actions.ActionFactory;
import cn.com.views.PnlSystemView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PnlSystemView_btnParts_ActionListener implements ActionListener {
	private PnlSystemView psv;
	private Action action;
	
	public PnlSystemView_btnParts_ActionListener(PnlSystemView psv){
		super();
		this.psv = psv;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		action = ActionFactory.createPnlSystemView_btnParts_Action();
		action.execute(e, psv);
	}
		
		


}
