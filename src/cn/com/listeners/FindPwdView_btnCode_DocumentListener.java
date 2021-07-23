package cn.com.listeners;

import cn.com.actions.Action;
import cn.com.actions.FindPwdView_BtnCodeValidateAction;
import cn.com.beans.EmailBean;
import cn.com.views.loginview.FindPwdView;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class FindPwdView_btnCode_DocumentListener implements DocumentListener {

    private FindPwdView fpv;
    private EmailBean eb;
    private Action action;
    public FindPwdView_btnCode_DocumentListener(FindPwdView fpv, EmailBean eb){
        this.fpv = fpv;
        this.eb = eb;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        validateCode(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        validateCode(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        validateCode(e);
    }

    private void validateCode(DocumentEvent e) {
        action = new FindPwdView_BtnCodeValidateAction(eb,fpv);
        action.execute(e,fpv);
    }

}
