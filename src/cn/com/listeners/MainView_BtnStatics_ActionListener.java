package cn.com.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cn.com.actions.Action;
import cn.com.actions.ActionFactory;
import cn.com.beans.User;
import cn.com.views.MainView;

import javax.swing.*;

public class MainView_BtnStatics_ActionListener implements ActionListener {
	private MainView mv;
	private Action action;
	private User user;
	public MainView_BtnStatics_ActionListener(MainView mv,User user) {
		this.mv = mv;
		this.user = user;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
			String job = user.getuJob();
			if(job.equals("财务员") || job.equals("管理员")) {
				action = ActionFactory.createStatisticAction();
				action.execute(e, mv);
			}else{
				JOptionPane.showMessageDialog(mv,"您没有权限操作","错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
		}

	}
