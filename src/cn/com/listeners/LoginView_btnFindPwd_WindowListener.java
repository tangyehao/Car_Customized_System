package cn.com.listeners;


import cn.com.views.loginview.FindPwdView;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginView_btnFindPwd_WindowListener extends WindowAdapter {
    private FindPwdView fpv;
    public LoginView_btnFindPwd_WindowListener(FindPwdView fpv) {
        this.fpv=fpv;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        loginViewClosing(e);
    }

    private void loginViewClosing(WindowEvent e) {
       this.fpv.dispose();
    }

}
