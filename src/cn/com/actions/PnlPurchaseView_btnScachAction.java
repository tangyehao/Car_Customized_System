package cn.com.actions;

import cn.com.views.stockview.StockTableView;

import java.awt.Container;
import java.awt.Frame;

public class PnlPurchaseView_btnScachAction implements Action {

	@Override
	public void execute(Object e, Container c, Object... params) {
		// TODO Auto-generated method stub
		new StockTableView(new Frame(),"±Ìµ•≤È—Ø",true);
	}

}
