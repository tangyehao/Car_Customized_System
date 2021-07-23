package cn.com.actions;

import java.awt.Container;
import java.awt.Window;
import java.util.EventObject;

import javax.swing.JOptionPane;


public class CloseView_Action implements Action{
	public void execute(Object e, Container c, Object... params) {
		// TODO Auto-generated method stub
		Window w = (Window) c;
		int result = JOptionPane.showConfirmDialog(w, "是否退出？", "提示", JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.YES_OPTION) {
			//this.dispose();
			w.dispose();
		}	
	}
}
