package cn.com.listeners;


import cn.com.views.loginview.LoginView;

import java.awt.event.KeyAdapter;

public class LoginView_btnLoginValidate_ActionListener extends KeyAdapter {
    private LoginView lv;

    public LoginView_btnLoginValidate_ActionListener(LoginView lv) {
        this.lv=lv;
    }
}
