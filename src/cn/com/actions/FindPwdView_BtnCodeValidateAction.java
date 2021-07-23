package cn.com.actions;

import cn.com.beans.EmailBean;
import cn.com.listeners.FindPwdView_btnSendCodeActionListener;
import cn.com.services.CodeServiceInf;
import cn.com.services.impl.CodeServiceImpl;
import cn.com.views.loginview.FindPwdView;


import java.awt.*;

public class FindPwdView_BtnCodeValidateAction implements Action {
    private FindPwdView fpv;
    private CodeServiceInf service;

    public FindPwdView_BtnCodeValidateAction(EmailBean eb, FindPwdView fpv){
        this.fpv = fpv;
        service = new CodeServiceImpl(fpv);
    }
    @Override
    public void execute(Object e, Container c, Object... params) {
        String value = FindPwdView_btnSendCodeActionListener.getStringBuilder().trim();
        if(service.validateByCode(value)){
            this.fpv.getLblMsgCode().setText("验证码正确");
            this.fpv.getLblMsgCode().setForeground(Color.green);
        }else{

            this.fpv.getLblMsgCode().setText("验证码错误");
            this.fpv.getLblMsgCode().setForeground(Color.red);
        }
    }
}
