package cn.com.listeners;

import cn.com.actions.Action;
import cn.com.actions.FindPwdView_BtnFindValidateAction;
import cn.com.views.loginview.FindPwdView;


import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class FindPwdView_btnFindPwd_DocumentListener implements DocumentListener {
    private FindPwdView fpv;
    private Action action;
    public FindPwdView_btnFindPwd_DocumentListener(FindPwdView fpv){
        this.fpv = fpv;
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
        action = new FindPwdView_BtnFindValidateAction(fpv);
        action.execute(e,fpv);
    }

}
