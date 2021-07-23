package cn.com.listeners;

import cn.com.actions.Action;
import cn.com.actions.ActionFactory;
import cn.com.views.firmview.FirmView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FirmInfoAddView_MouseListener implements MouseListener{
	private FirmView sv;
	private Action action;
	
	public FirmInfoAddView_MouseListener(FirmView sv){
		this.sv = sv;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		action = ActionFactory.createFirmAddView_Action();
		action.execute(e, sv);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
