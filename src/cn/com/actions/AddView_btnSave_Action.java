package cn.com.actions;

import java.awt.Container;
import java.util.EventObject;

import javax.swing.JOptionPane;

import cn.com.beans.Firm;
import cn.com.services.impl.FirmManageServiseImpl;
import cn.com.views.firmview.FirmAddView;
import cn.com.views.firmview.FirmView;

public class AddView_btnSave_Action implements Action {
	@Override
	public void execute(Object e, Container c, Object... params) {
		// TODO Auto-generated method stub
		FirmManageServiseImpl service = new FirmManageServiseImpl();
		FirmAddView f = (FirmAddView)c;
		Firm firm = new Firm();
		String address = f.getTxtAddress().getText().trim();
		
		
		String name = f.getTxtFirm().getText().trim();
		if(name.equals("")||name.length()>32) {
			JOptionPane.showMessageDialog(f, "姓名不能为空或长度过长", "提示", JOptionPane.ERROR_MESSAGE);
			return;
		}
		firm.setfName(name);
		String phone = f.getTxtPhone().getText().trim();
		firm.setfNote(f.getTxtNote().getText());
		
		if(phone.length()!=11) {
			JOptionPane.showMessageDialog(f, "电话必须为11位", "提示", JOptionPane.ERROR_MESSAGE);
			return;
		}
		firm.setfPhone(phone);
		
		firm.setfAddress(address);
		
		if(service.firmAdd(firm)){
			JOptionPane.showConfirmDialog(f, "保存成功", "提示",JOptionPane.PLAIN_MESSAGE);
			f.dispose();
			FirmView.setTable(service.firmExport());
		}else{
			JOptionPane.showMessageDialog(f, "保存失败", "提示", JOptionPane.ERROR_MESSAGE);
		}
	}

}
