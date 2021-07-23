package cn.com.listeners;

import cn.com.beans.EmailBean;
import cn.com.beans.User;

import cn.com.services.UserBaseServiceInf;
import cn.com.services.impl.UserBaseServiceImpl;
import cn.com.utils.SendEmail;
import cn.com.views.loginview.FindPwdView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindPwdView_btnSendCodeActionListener implements ActionListener {
    private FindPwdView fpv;
    private User ub;
    private UserBaseServiceInf service;
    private static String stringBuilder="";

    public FindPwdView_btnSendCodeActionListener(FindPwdView fpv, User ub) {
        this.fpv = fpv;
        this.ub = ub;
        service = new UserBaseServiceImpl();
    }

    public static String getStringBuilder() {
        return stringBuilder;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FindPwdView.date1 = System.currentTimeMillis();
        fpv.getTxtCode().setEditable(true);
        sendEmail();


    }

    private void sendEmail() {
        if(service.validateByUserEmail(fpv.getTxtUserEmail().getText())) {
            String[] letters = new String[]{
                    "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
            for (int i = 0; i < 6; i++) {
                stringBuilder += letters[(int) Math.floor(Math.random() * letters.length)];
            }
            EmailBean email = new EmailBean();
            email.setFrom("2996257494@qq.com");
            email.setPassword("durwbyjsjeuqddff");
            email.setRecipient("" + fpv.getTxtUserEmail().getText());
            email.setSubject("����������������һ�");
            email.setText("�����ε���֤��Ϊ:\n" + stringBuilder + "\n����ظ�������");
            SendEmail.SendMsg(email);
            stringBuilder = "";
        }else{
            this.fpv.getLblMsgFromUserEmail().setText("���䲻����!");
            this.fpv.getLblMsgFromUserEmail().setForeground(Color.red);
        }
    }
}