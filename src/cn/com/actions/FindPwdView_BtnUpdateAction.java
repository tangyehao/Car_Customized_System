package cn.com.actions;


import cn.com.services.UserBaseServiceInf;
import cn.com.services.impl.UserBaseServiceImpl;
import cn.com.utils.KeyCode;
import cn.com.views.loginview.FindPwdView;


import javax.swing.*;
import java.awt.*;

/*
ȷ���޸��������
 */
public class FindPwdView_BtnUpdateAction implements Action {
    private UserBaseServiceInf service;
    private FindPwdView fpv;
    public FindPwdView_BtnUpdateAction(){
        service = new UserBaseServiceImpl();
    }

    @Override
    public void execute(Object e, Container c, Object... params) {
        fpv  = (FindPwdView) c;
        String uID =  fpv.getTxtUserNo().getText().trim();
        String userPwd = new String(fpv.getTxtConfirmedPwd().getPassword()).trim();
        String pwd =  KeyCode.getKeyCodeMsg(userPwd);
        if(service.updateUserPwd(pwd,uID)){
           JOptionPane.showMessageDialog(this.fpv,"�޸ĳɹ������뱣�ܺ���������Ӵ ( ^_^ )","��ʾ",JOptionPane.PLAIN_MESSAGE);
               this.fpv.dispose();
        }

    }
}
