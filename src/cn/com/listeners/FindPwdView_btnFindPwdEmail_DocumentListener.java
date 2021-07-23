package cn.com.listeners;

import cn.com.actions.Action;
import cn.com.actions.FindPwdView_BtnFindByEmailValidateAction;
import cn.com.views.loginview.FindPwdView;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class FindPwdView_btnFindPwdEmail_DocumentListener implements DocumentListener {
    private FindPwdView fpv;
    private Action action;
    public FindPwdView_btnFindPwdEmail_DocumentListener(FindPwdView fpv){
        this.fpv = fpv;
    }
    @Override
    public void insertUpdate(DocumentEvent e) {
        validateUserEmail(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        validateUserEmail(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        validateUserEmail(e);
    }

    private void validateUserEmail(DocumentEvent e) {
        action = new FindPwdView_BtnFindByEmailValidateAction(fpv);
        action.execute(e,fpv);
    }
}
