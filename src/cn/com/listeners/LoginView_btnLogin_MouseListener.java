package cn.com.listeners;

import cn.com.actions.Action;
import cn.com.actions.LoginView_BtnLoginButtonMouseAction;
import cn.com.actions.LoginView_BtnLoginMouseAction;
import cn.com.views.loginview.LoginView;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginView_btnLogin_MouseListener extends MouseAdapter {
    private LoginView lv;
    private Action action;
    public LoginView_btnLogin_MouseListener(LoginView lv) {
        this.lv=lv;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //e.getButton():获得触发事件的鼠标的哪一个按键
        if(e.getButton() == MouseEvent.BUTTON1){
            action = new LoginView_BtnLoginMouseAction();
            action.execute(e,lv);
        }
        if(e.getClickCount() == 2){
            action = new LoginView_BtnLoginButtonMouseAction(lv);
            action.execute(e,lv);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.lv.getTxtUserNo().setForeground(Color.green);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.lv.getTxtUserNo().setForeground(Color.RED);
    }
}
