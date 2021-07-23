package cn.com.listeners;

import cn.com.actions.Action;
import cn.com.actions.ActionFactory;
import cn.com.beans.User;
import cn.com.views.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView_BtnSell_ActionListener implements ActionListener {
	private MainView mv;
	private Action action;
	private User user;
	
	public MainView_BtnSell_ActionListener(MainView mv,User user) {
		// TODO Auto-generated constructor stub
		this.mv = mv;
		this.user = user;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String Job = user.getuJob();
		if(Job.equals("����Ա") || Job.equals("����Ա")){
			action = ActionFactory.createMainView_BtnSell_Action();
			action.execute(e,mv);
		}else{
			JOptionPane.showMessageDialog(mv,"��û��Ȩ�޲���","����",JOptionPane.ERROR_MESSAGE);
			return;
		}
	}
}
