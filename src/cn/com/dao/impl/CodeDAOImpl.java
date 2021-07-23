package cn.com.dao.impl;

import cn.com.dao.CodeDAOInf;
import cn.com.listeners.FindPwdView_btnSendCodeActionListener;
import cn.com.views.loginview.FindPwdView;

public class CodeDAOImpl implements CodeDAOInf {
    private FindPwdView fpv;

    public CodeDAOImpl(FindPwdView fpv){
        this.fpv = fpv;
    }
    @Override
    public boolean validateByCode(String code) {
        boolean bool = false;
        code = FindPwdView_btnSendCodeActionListener.getStringBuilder();
        if(this.fpv.getTxtCode().getText().equals(code)){
            bool = true;
        }
        return bool;
    }
}
