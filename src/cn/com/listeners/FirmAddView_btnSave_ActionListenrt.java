package cn.com.listeners;

import cn.com.actions.Action;
import cn.com.actions.ActionFactory;
import cn.com.views.firmview.FirmAddView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirmAddView_btnSave_ActionListenrt implements ActionListener {
	private FirmAddView mv;
	private Action action;
	
	public FirmAddView_btnSave_ActionListenrt(FirmAddView mv) {
		// TODO Auto-generated constructor stub
		this.mv = mv;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		action = ActionFactory.createFirmAddView_btnSave_Action();
		action.execute(e,mv);
	}

}
