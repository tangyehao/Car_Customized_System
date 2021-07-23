package cn.com.actions;


import cn.com.views.loginview.LoginView;

import java.awt.*;

public class LoginView_BtnLoginButtonMouseAction implements Action {
    private LoginView lv;
    public  LoginView_BtnLoginButtonMouseAction(LoginView lv){
        this.lv=lv;
    }
    @Override
    public void execute(Object e, Container c, Object... params) {
        lv.getTxtUserNo().setText("");
    }
}
