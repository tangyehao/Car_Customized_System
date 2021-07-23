package cn.com.actions;

import cn.com.views.warehouseview.btnWareJDialog;

import java.awt.Container;
import java.awt.Frame;


public class PnlStoreView_btnWare_Action implements Action {

	@Override
	public void execute(Object e, Container c, Object... params) {
		// TODO Auto-generated method stub
		new btnWareJDialog(new Frame(),"≤÷ø‚…Ë÷√",true);
	}

}
