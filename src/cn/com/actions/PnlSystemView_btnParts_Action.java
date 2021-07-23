package cn.com.actions;

import java.awt.Container;
import java.awt.Frame;
import java.util.EventObject;

import cn.com.views.Systemview.BtnPartsView;



public class PnlSystemView_btnParts_Action implements Action {

	@Override
	public void execute(Object e, Container c, Object... params) {
		// TODO Auto-generated method stub
		new BtnPartsView(new Frame(),"≈‰º˛π‹¿Ì",true);
	}

}
