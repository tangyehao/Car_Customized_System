package cn.com.actions;

import cn.com.beans.EmailBean;
import cn.com.services.CodeServiceInf;
import cn.com.services.impl.CodeServiceImpl;
import cn.com.views.loginview.FindPwdView;


import java.awt.*;

public class FindPwdVIew_BtnConfirmedAction implements Action {
    private FindPwdView fpv;
    private CodeServiceInf service;
    FindPwdVIew_BtnNewPwdAction np;

    public FindPwdVIew_BtnConfirmedAction(EmailBean eb, FindPwdView fpv){
        this.fpv = fpv;
        service = new CodeServiceImpl(fpv);
        np = new FindPwdVIew_BtnNewPwdAction(eb,fpv);
    }
    @Override
    public void execute(Object e,Container c, Object... params) {
        np.newPwdAndConfirmPwd();
    }
}
