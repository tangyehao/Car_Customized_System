package cn.com.actions;

import cn.com.views.Systemview.BtnClientView;

import java.awt.Container;
import java.awt.Frame;


public class PnlSystemView_btnClient_Action implements Action {

	@Override
	public void execute(Object e, Container c, Object... params) {
		// TODO Auto-generated method stub
		new BtnClientView(new Frame(),"øÕªß…Ë÷√",true);
	}

}
