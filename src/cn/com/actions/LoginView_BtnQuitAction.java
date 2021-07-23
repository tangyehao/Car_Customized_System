package cn.com.actions;


import cn.com.views.loginview.LoginView;

import java.awt.*;

public class LoginView_BtnQuitAction implements Action {
    public void execute(Object e, Container c,Object... params){
        LoginView l = (LoginView)c;
        l.dispose();
    }
}
