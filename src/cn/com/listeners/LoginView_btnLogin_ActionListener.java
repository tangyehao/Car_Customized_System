package cn.com.listeners;

import cn.com.actions.Action;
import cn.com.actions.ActionFactory;
import cn.com.views.loginview.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView_btnLogin_ActionListener implements ActionListener {
    private LoginView lv;
    private Action action;
    public LoginView_btnLogin_ActionListener(LoginView lv){
        this.lv = lv;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //e.getActionCommand():当事件触发时获得触发事件的事件源对象的文本，例如"登录"
        //e.getSource():当事件触发时获得触发事件的事件源对象本身
        Object obj = e.getSource();
        if(obj == lv.getBtnLogin()){
            action= ActionFactory.createLoginAction();
        }else{
            action= ActionFactory.createQuitAction();
        }
        action.execute(e,lv);
    }
}
