package cn.com.listeners;

import cn.com.actions.Action;
import cn.com.actions.FindPwdVIew_BtnNewPwdAction;
import cn.com.beans.EmailBean;
import cn.com.views.loginview.FindPwdView;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class FindPwdView_btnNewPwd_DocumentListener implements DocumentListener {

    private FindPwdView fpv;
    private EmailBean eb;
    private Action action;
    public FindPwdView_btnNewPwd_DocumentListener(FindPwdView fpv, EmailBean eb){
        this.fpv = fpv;
        this.eb = eb;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        validatePwd(e);
    }
    @Override
    public void removeUpdate(DocumentEvent e) {
        validatePwd(e);

    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        validatePwd(e);

    }
    private void validatePwd(DocumentEvent e) {
        action = new FindPwdVIew_BtnNewPwdAction(eb,fpv);
        action.execute(e,fpv);
    }
}
