package cn.com.actions;

import java.awt.Container;
import java.awt.Frame;
import java.util.EventObject;

import cn.com.views.inventoryselectview.btnAllotJDialog;



public class PnlStoreView_btnAllot_Action implements Action {

	@Override
	public void execute(Object e, Container w, Object... params) {
		// TODO Auto-generated method stub
		new btnAllotJDialog(new Frame(),"¿â´æµ÷²¦",true);
	}

}
