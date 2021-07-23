package cn.com.actions;

import java.awt.Container;
import java.awt.Frame;
import java.util.EventObject;

import cn.com.views.firmview.FirmAddView;

public class FirmInfoAdd_Action implements Action{
	public void execute(Object e, Container c, Object... params) {
		// TODO Auto-generated method stub
		new FirmAddView(new Frame(),"厂商信息增加",true);
				
	}
}
