package cn.com.listeners;

import cn.com.actions.Action;
import cn.com.actions.ActionFactory;
import cn.com.views.loginview.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView_btnLogin_ActionListener implements ActionListener {
    private LoginView lv;
    private Action action;
    public LoginView_btnLogin_ActionListener(LoginView lv){
        this.lv = lv;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //e.getActionCommand():���¼�����ʱ��ô����¼����¼�Դ������ı�������"��¼"
        //e.getSource():���¼�����ʱ��ô����¼����¼�Դ������
        Object obj = e.getSource();
        if(obj == lv.getBtnLogin()){
            action= ActionFactory.createLoginAction();
        }else{
            action= ActionFactory.createQuitAction();
        }
        action.execute(e,lv);
    }
}
