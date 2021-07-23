package cn.com.listeners;

import cn.com.actions.Action;
import cn.com.actions.LoginView_BtnLoginValidateAction;
import cn.com.views.loginview.LoginView;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class LoginView_btnLogin_DocumentListener implements DocumentListener {
    private LoginView lv;
    private Action action;
    public LoginView_btnLogin_DocumentListener(LoginView lv){
        this.lv = lv;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        validateUserNo(e);

    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        validateUserNo(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        validateUserNo(e);
    }
    private void validateUserNo(DocumentEvent e) {
        action = new LoginView_BtnLoginValidateAction(lv);
        action.execute(e,lv);
    }
}
