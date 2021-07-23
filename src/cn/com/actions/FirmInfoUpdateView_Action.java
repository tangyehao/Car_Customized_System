package cn.com.actions;

import java.awt.Container;
import java.awt.Frame;
import java.util.EventObject;

import javax.swing.JOptionPane;

import cn.com.beans.Firm;
import cn.com.views.firmview.FirmUpdateView;
import cn.com.views.firmview.FirmView;

public class FirmInfoUpdateView_Action implements Action {
	@Override
	public void execute(Object e, Container c, Object... params) {
		// TODO Auto-generated method stub
		
		FirmView fv = (FirmView)c;
		Firm f = new Firm();
		int row = fv.getTabParts().getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(fv, "��ѡ��Ҫ�޸ĵ���Ϣ", "��ʾ", JOptionPane.ERROR_MESSAGE);
			return;
		}
		f =(Firm)fv.getTabParts().getValueAt(row, 0);
		new FirmUpdateView(new Frame(),"������Ϣ�޸�",true,f);
	}

}