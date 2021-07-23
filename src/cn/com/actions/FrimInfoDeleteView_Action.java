package cn.com.actions;

import java.awt.Container;
import java.awt.Frame;
import java.util.EventObject;

import javax.swing.JOptionPane;

import cn.com.beans.Firm;
import cn.com.services.impl.FirmManageServiseImpl;
import cn.com.views.firmview.FirmView;

public class FrimInfoDeleteView_Action implements Action {

	@Override
	public void execute(Object e, Container c, Object... params) {
		// TODO Auto-generated method stub
		FirmView fv = (FirmView)c;
		Firm f = new Firm();
		int row = fv.getTabParts().getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(fv, "请选择要修改的信息", "提示", JOptionPane.ERROR_MESSAGE);
			return;
		}
		f =(Firm)fv.getTabParts().getValueAt(row, 0);
		int result = JOptionPane.showConfirmDialog(fv, "确认删除", "提示", JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.YES_OPTION) {
			//this.dispose();
			FirmManageServiseImpl service = new FirmManageServiseImpl();
			service.firmDelete(f);
			fv.dispose();
			new FirmView(new Frame(),"厂商信息",true);
		}
	}

}
