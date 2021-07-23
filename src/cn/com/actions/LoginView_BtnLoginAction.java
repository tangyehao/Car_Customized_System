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
            //JOptionPane.showMessageDialog(lv,"�ʺű�������","����",JOptionPane.ERROR_MESSAGE);
            lv.getLblMsg().setText("�����ʺŻ�����");
            return;
        }
        if (uID.length() < 4) {
            //  JOptionPane.showMessageDialog(lv,"�ʺų���Ҫ�����3λ","����",JOptionPane.ERROR_MESSAGE);
            lv.getLblMsg().setText("�ʺų�������4λ");
            return;
        }
        User user = service.getUserBaseByUserNo(uID);
        if (service.validateByUserNo(uID)) {
            String uState = user.getuState();
                if (service.validateByUserNoAndPwd(uID, valPwd, uState)) {
                    if (uState.equals("����")) {
                        new MainView(user);
                        lv.dispose();
                    } else {
                        lv.getLblMsg().setText("���ʺ��ѱ����ã�");
                        lv.getLblMsg().setForeground(Color.RED);
                        return;
                    }
                }else {
                    lv.getLblMsg().setText("�ʺŻ��������");
                    lv.getLblMsg().setForeground(Color.RED);
                    return;
                }
            }else{
            lv.getLblMsg().setText("�ʺŻ��������");
            lv.getLblMsg().setForeground(Color.RED);
            return;
        }
        }
    }