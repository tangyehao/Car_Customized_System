package cn.com.actions;

import java.awt.Container;
import java.awt.Frame;
import java.awt.Window;
import java.util.EventObject;

import cn.com.views.inventoryselectview.btnSearchJFrame;



public class PnlStoreView_btnSearch_Action implements Action {

	@Override
	public void execute(Object e, Container w, Object... params) {
		// TODO Auto-generated method stub
		 new btnSearchJFrame(new Frame(),"ø‚¥Ê≤È—Ø",true);
	}

}
