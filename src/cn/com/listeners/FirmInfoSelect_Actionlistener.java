package cn.com.listeners;

import cn.com.actions.Action;
import cn.com.actions.ActionFactory;
import cn.com.views.firmview.FirmView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirmInfoSelect_Actionlistener implements ActionListener {
	private FirmView sv;
	private Action action;
	
	public FirmInfoSelect_Actionlistener(FirmView sv){
		this.sv = sv;
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		action = ActionFactory.createFirmInfoSelect_Action();
		action.execute(e, sv);
	}

}
