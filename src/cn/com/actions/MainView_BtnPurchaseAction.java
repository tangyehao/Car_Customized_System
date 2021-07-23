package cn.com.actions;

import cn.com.views.MainView;

import java.awt.Container;
import java.util.EventObject;


public class MainView_BtnPurchaseAction implements Action {
	private MainView mv ;
	public MainView_BtnPurchaseAction(){
		
	}

	@Override
	public void execute(Object e, Container w, Object... params) {
		// TODO Auto-generated method stub
		mv = (MainView)w;
		mv.getPnlStatistics().setVisible(false);
		
	
	}

}
