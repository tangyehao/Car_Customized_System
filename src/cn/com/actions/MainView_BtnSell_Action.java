package cn.com.actions;

import java.awt.BorderLayout;
import java.awt.Container;

import cn.com.views.MainView;

public class MainView_BtnSell_Action implements Action {

	@Override
	public void execute(Object e, Container c, Object... params) {
		// TODO Auto-generated method stub
		MainView mv = (MainView) c;
		mv.getPs().setVisible(false);
		mv.getPp().setVisible(false);
		mv.getPSell().setVisible(false);
		mv.getPsv().setVisible(false);
		mv.getPnlMain().add(mv.getPSell(),BorderLayout.CENTER);
		mv.getPSell().setVisible(true);
	}

}
