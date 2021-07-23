package cn.com.actions;

import cn.com.beans.User;
import cn.com.services.UserBaseServiceInf;
import cn.com.services.impl.UserBaseServiceImpl;
import cn.com.utils.KeyCode;
import cn.com.views.MainView;
import cn.com.views.loginview.LoginView;


import java.awt.*;

public class LoginView_BtnLoginAction implements Action {
    private UserBaseServiceInf service;
    private LoginView lv;
    public  LoginView_BtnLoginAction(){
        service = new UserBaseServiceImpl();
    }
    public void execute(Object e, Container c,Object... params) {
        lv = (LoginView) c;
        String uID = lv.getTxtUserNo().getText().trim();
        String userPwd = new String(lv.getUserPwd().getPassword()).trim();
        String valPwd = KeyCode.getKeyCodeMsg(userPwd);
        if (uID.equals("") || valPwd.equals("")) {
            //JOptionPane.showMessageDialog(lv,"帐号必须输入","错误",JOptionPane.ERROR_MESSAGE);
            lv.getLblMsg().setText("请检查帐号或密码");
            return;
        }
        if (uID.length() < 4) {
            //  JOptionPane.showMessageDialog(lv,"帐号长度要求大于3位","错误",JOptionPane.ERROR_MESSAGE);
            lv.getLblMsg().setText("帐号长度最少4位");
            return;
        }
        User user = service.getUserBaseByUserNo(uID);
        if (service.validateByUserNo(uID)) {
            String uState = user.getuState();
                if (service.validateByUserNoAndPwd(uID, valPwd, uState)) {
                    if (uState.equals("正常")) {
                        new MainView(user);
                        lv.dispose();
                    } else {
                        lv.getLblMsg().setText("该帐号已被禁用！");
                        lv.getLblMsg().setForeground(Color.RED);
                        return;
                    }
                }else {
                    lv.getLblMsg().setText("帐号或密码错误！");
                    lv.getLblMsg().setForeground(Color.RED);
                    return;
                }
            }else{
            lv.getLblMsg().setText("帐号或密码错误！");
            lv.getLblMsg().setForeground(Color.RED);
            return;
        }
        }
    }