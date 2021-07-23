package cn.com.actions;



import cn.com.services.EmailServiceInf;
import cn.com.services.impl.EmailServiceImpl;
import cn.com.views.loginview.FindPwdView;

import java.awt.*;

public class FindPwdView_BtnFindByEmailValidateAction implements Action {

    private FindPwdView fpv;
    private EmailServiceInf service;
    public FindPwdView_BtnFindByEmailValidateAction(FindPwdView fpv){
        this.fpv=fpv;
        service = new EmailServiceImpl();
    }

    @Override
    public void execute(Object e, Container c, Object... params) {
        String valNo = fpv.getTxtUserNo().getText();
        String valEmail = fpv.getTxtUserEmail().getText();
        if(service.validateByUserEmail(valNo,valEmail)){
            this.fpv.getLblMsgFromUserEmail().setText("�������");
            this.fpv.getLblMsgFromUserEmail().setForeground(Color.green);
        }else{
            this.fpv.getLblMsgFromUserEmail().setText("���䲻����!");
            this.fpv.getLblMsgFromUserEmail().setForeground(Color.red);
        }
    }
}
