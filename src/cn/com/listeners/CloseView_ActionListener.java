package cn.com.listeners;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import cn.com.actions.Action;
import cn.com.actions.ActionFactory;

public class CloseView_ActionListener implements ActionListener,MouseListener{
	private Window w;
	private Action action;
	
	public CloseView_ActionListener(Window w) {
		// TODO Auto-generated constructor stub
		this.w = w;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		action = ActionFactory.createClouseView_Action();
		action.execute(e,w);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		action = ActionFactory.createClouseView_Action();
		action.execute(e,w);
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
