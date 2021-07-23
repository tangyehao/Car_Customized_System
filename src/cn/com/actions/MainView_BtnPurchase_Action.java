package cn.com.actions;

import java.awt.BorderLayout;
import java.awt.Container;
import cn.com.views.MainView;

public class MainView_BtnPurchase_Action implements Action {
	public MainView_BtnPurchase_Action(){

	}
	@Override
	public void execute(Object e, Container w, Object... params) {
		// TODO Auto-generated method stub
		MainView mv = (MainView) w;
		mv.getPs().setVisible(false);
		mv.getPp().setVisible(false);
		mv.getPSell().setVisible(false);
		mv.getPsv().setVisible(false);
		mv.getPnlMain().add(mv.getPp(),BorderLayout.CENTER);
		mv.getPp().setVisible(true);
	}

}
