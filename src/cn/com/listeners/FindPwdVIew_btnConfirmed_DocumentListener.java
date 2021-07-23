package cn.com.listeners;

import cn.com.actions.Action;
import cn.com.actions.FindPwdVIew_BtnConfirmedAction;
import cn.com.beans.EmailBean;
import cn.com.views.loginview.FindPwdView;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class FindPwdVIew_btnConfirmed_DocumentListener implements DocumentListener {
    private FindPwdView fpv;
    private EmailBean eb;
    private Action action;
    public FindPwdVIew_btnConfirmed_DocumentListener(FindPwdView fpv, EmailBean eb){
        this.fpv = fpv;
        this.eb = eb;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        validateConfirmedPwd(e);
    }
    @Override
    public void removeUpdate(DocumentEvent e) {
        validateConfirmedPwd(e);

    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        validateConfirmedPwd(e);

    }
    private void validateConfirmedPwd(DocumentEvent e) {
        action = new FindPwdVIew_BtnConfirmedAction(eb,fpv);
        action.execute(e,fpv);
    }
}
