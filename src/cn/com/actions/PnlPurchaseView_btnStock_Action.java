package cn.com.actions;

import cn.com.views.stockview.StockView;

import java.awt.Container;
import java.awt.Frame;

public class PnlPurchaseView_btnStock_Action implements Action{

	@Override
	public void execute(Object e, Container c, Object... params) {
		// TODO Auto-generated method stub
		new StockView(new Frame(),"²É¹º½ø»õ",true);
				
	}

}
