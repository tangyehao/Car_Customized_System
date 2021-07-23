package cn.com.listeners;


import cn.com.views.loginview.FindPwdView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindPwdView_btnFindPwd_ActionListener implements ActionListener {
    public FindPwdView_btnFindPwd_ActionListener() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new FindPwdView();
    }
}