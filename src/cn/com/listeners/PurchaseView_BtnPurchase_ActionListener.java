package cn.com.listeners;

import cn.com.actions.Action;
import cn.com.actions.ActionFactory;
import cn.com.views.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PurchaseView_BtnPurchase_ActionListener  implements ActionListener{
	private MainView mv;
	private Action action;
	public PurchaseView_BtnPurchase_ActionListener(MainView mv) {
		this.mv = mv;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == mv.getBtnPurchase()) {
		//	action = ActionFactory.createPurchaseAction();
		}else if(obj == mv.getBtnStatics()){
			action = ActionFactory.createStatisticAction();
		}
		action.execute(e, mv);
	}
		
	}

	

