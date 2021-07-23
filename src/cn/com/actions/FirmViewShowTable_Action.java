package cn.com.actions;

import java.awt.Container;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import cn.com.beans.Firm;
import cn.com.services.impl.FirmManageServiseImpl;
import cn.com.views.firmview.FirmView;

public class FirmViewShowTable_Action implements Action {

	@Override
	public void execute(Object e, Container c, Object... params) {
		// TODO Auto-generated method stub
		FirmView fv = (FirmView)c;
		FirmManageServiseImpl service = new FirmManageServiseImpl();
		List<Firm> list = new ArrayList<Firm>();
		list = service.firmExport();
		fv.setTable(list);
	}

}
