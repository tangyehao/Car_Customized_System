package cn.com.actions;

import cn.com.views.sellview.SellBackView;

import java.awt.Container;
import java.awt.Frame;


public class PnlPurchaseView_btnBack_Action implements Action {

	@Override
	public void execute(Object e, Container c, Object... params) {
		// TODO Auto-generated method stub
		new SellBackView(new Frame(),"²É¹ºÍË»õ",true);
	}

}
