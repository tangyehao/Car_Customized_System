package cn.com.actions;

import java.awt.Container;
import java.awt.Frame;
import java.util.EventObject;

import cn.com.views.inventoryselectview.btnStatJDialog;



public class PnlStoreView_btnStat_Action implements Action {

	@Override
	public void execute(Object e, Container c, Object... params) {
		// TODO Auto-generated method stub
		new btnStatJDialog(new Frame(),"库存成本统计",true);
	}

}
