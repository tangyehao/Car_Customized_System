package cn.com.actions;

import cn.com.beans.EmailBean;
import cn.com.views.loginview.FindPwdView;

import java.awt.*;

public class FindPwdVIew_BtnNewPwdAction implements Action {
    private EmailBean eb;
    private FindPwdView fpv;
    public FindPwdVIew_BtnNewPwdAction(EmailBean eb, FindPwdView fpv) {
        this.eb = eb;
        this.fpv = fpv;
    }

    @Override
    public void execute(Object e, Container c, Object... params) {
        newPwdAndConfirmPwd();

    }

    public void newPwdAndConfirmPwd() {
        String pwd1 = this.fpv.getTxtNewPwd().getText();
        String pwd2 = this.fpv.getTxtConfirmedPwd().getText();
        if(!pwd1.equals(pwd2)){
            this.fpv.getLblMsgConfirmed().setText("两次输入密码不一致");
            this.fpv.getLblMsgConfirmed().setForeground(Color.red);
        }else if(pwd1.length()<6){
            this.fpv.getLblMsgConfirmed().setText("密码长度必须大于6位");
            this.fpv.getLblMsgConfirmed().setForeground(Color.red);
        }
    }
}
