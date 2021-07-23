package cn.com.actions;

import cn.com.views.MainView;
import cn.com.views.loginview.LoginView;

import java.awt.*;

public class MainView_BtnChangeAction implements Action {
    @Override
    public void execute(Object e, Container c, Object... params) {
        MainView m = (MainView)c;
        m.dispose();
        new LoginView();
    }
}
