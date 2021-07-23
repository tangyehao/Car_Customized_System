package cn.com.listeners;

import cn.com.actions.Action;
import cn.com.actions.ActionFactory;
import cn.com.views.loginview.FindPwdView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
    忘记密码的确认修改类
 */
public class FindPwdView_btnUpDate_ActionLitener implements ActionListener {
    private FindPwdView fpv;
    private Action action;
    public FindPwdView_btnUpDate_ActionLitener(FindPwdView fpv) {
        this.fpv = fpv;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        long date2 = System.currentTimeMillis();
        if(date2 - FindPwdView.date1  > 60000){
            fpv.getTxtCode().setEditable(false);
            JOptionPane.showMessageDialog(fpv,"验证码已过期，请重新发送！","提示",JOptionPane.YES_OPTION);
            return;
        }
        if(obj == this.fpv.getBtnUpdate()){
            action= ActionFactory.createUpdateAction();
        }else{
            action= ActionFactory.createCancelAction();
        }
        action.execute(e,fpv);
    }
}
