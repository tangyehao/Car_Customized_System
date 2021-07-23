package cn.com.actions;


import cn.com.services.impl.UserBaseServiceImpl;
import cn.com.views.loginview.LoginView;

import java.awt.*;

public class LoginView_BtnLoginMouseAction implements Action {
    private UserBaseServiceImpl service;

    public LoginView_BtnLoginMouseAction() {
        service = new UserBaseServiceImpl();
    }

    @Override
    public void execute(Object e, Container c, Object... params) {
        LoginView lv = (LoginView)c;
        String userNo =  lv.getTxtUserNo().getText().trim();
        String userPwd = new String(lv.getUserPwd().getPassword()).trim();
        if(userNo.equals("") || userPwd.equals("")){
            lv.getLblMsg().setText("请检查帐号或密码");
            return;
        }
        if(userNo.length() <= 3){
            lv.getLblMsg().setText("帐号长度最少4位");
            return;
        }
    }
}
