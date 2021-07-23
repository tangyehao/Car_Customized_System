package cn.com.actions;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Window;
import java.util.EventObject;

import cn.com.views.MainView;
import cn.com.views.PnlStoreView;

public class MainView_BtnStore_Action implements Action {
	
	@Override
	public void execute(Object e, Container w, Object... params) {
		// TODO Auto-generated method stub
		MainView mv = (MainView) w;
		mv.getPs().setVisible(false);
		mv.getPp().setVisible(false);
		mv.getPSell().setVisible(false);
		mv.getPsv().setVisible(false);
		mv.getPnlMain().add(mv.getPs(),BorderLayout.CENTER);
		mv.getPs().setVisible(true);
	}

}
