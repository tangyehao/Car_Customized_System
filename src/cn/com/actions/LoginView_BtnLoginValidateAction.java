package cn.com.actions;


import cn.com.services.UserBaseServiceInf;
import cn.com.services.impl.UserBaseServiceImpl;
import cn.com.views.loginview.LoginView;

import java.awt.*;

public class LoginView_BtnLoginValidateAction implements Action {
    private LoginView lv;
    private UserBaseServiceInf service;
    public  LoginView_BtnLoginValidateAction(LoginView lv){
        this.lv=lv;
        service = new UserBaseServiceImpl();
        lv.getLblMsg().setFont(new Font("����",Font.BOLD,18));
    }
    @Override
    public void execute(Object e, Container c, Object... params) {
        UserNoValidate();
    }

    public void UserNoValidate() {
        String value = lv.getTxtUserNo().getText();
        if(service.validateByUserNo(value)){

           lv.getLblMsg().setText("�ʺŴ���");
           lv.getLblMsg().setForeground(Color.green);
        }else{
            this.lv.getLblMsg().setText("�ʺŲ�����");
            this.lv.getLblMsg().setForeground(Color.red);
        }

    }
}
