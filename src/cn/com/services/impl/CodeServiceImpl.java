package cn.com.services.impl;

import cn.com.dao.CodeDAOInf;
import cn.com.dao.impl.CodeDAOImpl;
import cn.com.listeners.FindPwdView_btnSendCodeActionListener;
import cn.com.services.CodeServiceInf;
import cn.com.views.loginview.FindPwdView;

public class CodeServiceImpl implements CodeServiceInf {
    private FindPwdView fpv;
    private CodeDAOInf dao;

    public CodeServiceImpl(FindPwdView fpv){
        this.fpv = fpv;
        dao = new CodeDAOImpl(fpv);
    }
    @Override
    public boolean validateByCode(String code) {
        boolean bool = false;
        String value = FindPwdView_btnSendCodeActionListener.getStringBuilder();
        if(dao.validateByCode(value)){
            bool = true;
        }
        return bool;
    }
}
