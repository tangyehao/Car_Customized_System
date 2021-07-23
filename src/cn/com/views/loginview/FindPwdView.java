package cn.com.views.loginview;

import cn.com.beans.EmailBean;
import cn.com.beans.User;
import cn.com.listeners.*;
import cn.com.utils.Center;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FindPwdView extends JDialog{
    public  static  long date1;
    private User ub;
    private EmailBean eb;
    private FindPwdView_btnSendCodeActionListener f;
    private JPanel pnlMain;
    private JPanel pnlS;
    private JPanel pnlC;
    private JLabel lblMsgFromUserNo;
    private JLabel lblMsgFromUserEmail;
    private JLabel lblMsgCode;
    private JLabel lblMsgNewPwd;
    private JLabel lblMsgConfirmed;
    private JLabel lblMsgTime;
    private JLabel lblUserId;
    private JTextField txtUserNo;
    private JLabel lblUserEmail;
    private JTextField txtUserEmail;
    private JLabel lblInputCode;
    private JTextField txtCode;//用户输入接收到的验证码

    private JLabel lblNewPwd;
    private JPasswordField txtNewPwd;

    private JLabel lblConfirmedPwd;
    private JPasswordField txtConfirmedPwd;
    private JButton btnUpdate;
    private JButton btnCancel;
    private JButton btnVerificationCode;//验证码按钮

    public FindPwdView(){
        pnlMain = new JPanel(new BorderLayout());
        pnlS = new JPanel();
        pnlC = new JPanel(null);
        this.lblMsgFromUserNo = new JLabel();
        this.lblMsgFromUserEmail = new JLabel();
        this.lblMsgCode = new JLabel();
        this.lblMsgNewPwd = new JLabel();
        this.lblMsgConfirmed = new JLabel();
        this.lblMsgTime = new JLabel();
        lblUserId = new JLabel("请输入你的帐号");
        txtUserNo = new JTextField();
        lblUserEmail = new JLabel("请输入你的邮箱");
        txtUserEmail = new JTextField();
        btnVerificationCode = new JButton("发送验证码");
        lblInputCode = new JLabel("输入验证码");
        txtCode = new JTextField();
        lblNewPwd = new JLabel("输入新密码");
        txtNewPwd = new JPasswordField();
        lblConfirmedPwd = new JLabel("确认新密码");
        txtConfirmedPwd = new JPasswordField();
        btnUpdate = new JButton("确认修改");
        btnCancel = new JButton("取消修改");
        init();
    }
    public FindPwdView(User ub){
        this.ub = ub;
    }
    public FindPwdView(EmailBean eb){
        this.eb = eb;
    }
    public FindPwdView(FindPwdView_btnSendCodeActionListener f){
        this.f = f;
    }

    public JLabel getLblMsgFromUserNo() {
        return lblMsgFromUserNo;
    }

    public JLabel getLblMsgFromUserEmail() {
        return lblMsgFromUserEmail;
    }

    public JLabel getLblMsgCode() {
        return lblMsgCode;
    }

    public JLabel getLblMsgNewPwd() {
        return lblMsgNewPwd;
    }

    public JLabel getLblMsgConfirmed() {
        return lblMsgConfirmed;
    }

    public JLabel getLblMsgTime() {
        return lblMsgTime;
    }

    public JTextField getTxtUserNo() {
        return txtUserNo;
    }

    public JTextField getTxtUserEmail() {
        return txtUserEmail;
    }

    public JTextField getTxtCode() {
        return txtCode;
    }

    public JPasswordField getTxtNewPwd() {
        return txtNewPwd;
    }

    public JPasswordField getTxtConfirmedPwd() {
        return txtConfirmedPwd;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public JButton getBtnVerificationCode() {
        return btnVerificationCode;
    }

    private void init() {


        this.setResizable(false);

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(400,600);

        Center.centerByWindow(this);

        lblMsgFromUserNo.setBounds(280,60,210,25);
        lblMsgFromUserEmail.setBounds(280,110,210,25);
        lblMsgCode.setBounds(320,160,210,25);
        lblMsgConfirmed.setBounds(280,260,210,25);

        lblUserId.setBounds(30,60,120,25);
        txtUserNo.setBounds(120,60,150,25);

        lblUserEmail.setBounds(30,110,120,25);
        txtUserEmail.setBounds(120,110,150,25);

        lblInputCode.setBounds(30,160,120,25);
        txtCode.setBounds(120,160,80,25);

        lblNewPwd.setBounds(30,210,120,25);
        txtNewPwd.setBounds(120,210,150,25);

       lblConfirmedPwd.setBounds(30,260,120,25);
       txtConfirmedPwd.setBounds(120,260,150,25);

       lblMsgTime.setBounds(30,300,120,25);

       btnVerificationCode.setBounds(210,160,100,25);
       btnVerificationCode.addActionListener(new FindPwdView_btnSendCodeActionListener(this,ub));



        btnUpdate.addActionListener(new FindPwdView_btnUpDate_ActionLitener(this));


       btnCancel.addActionListener(new FindPwdView_btnUpDate_ActionLitener(this));

        this.addWindowListener(new LoginView_btnFindPwd_WindowListener(this));
//        this.lv.getBtnFind().(new FindPwdView_btnFindPwd_DocumentListener(this));

        this.setTitle("找回密码");

        txtUserNo.getDocument().addDocumentListener(new FindPwdView_btnFindPwd_DocumentListener(this));
        txtUserEmail.getDocument().addDocumentListener(new FindPwdView_btnFindPwdEmail_DocumentListener(this));
        txtCode.getDocument().addDocumentListener(new FindPwdView_btnCode_DocumentListener(this,eb));
        txtNewPwd.getDocument().addDocumentListener(new FindPwdView_btnNewPwd_DocumentListener(this,eb));
        txtConfirmedPwd.getDocument().addDocumentListener(new FindPwdVIew_btnConfirmed_DocumentListener(this,eb));

        pnlC.add(lblMsgFromUserNo);
        pnlC.add(lblMsgFromUserEmail);
        pnlC.add(lblMsgCode);
        pnlC.add(lblMsgNewPwd);
        pnlC.add(lblMsgConfirmed);
        pnlC.add(lblMsgTime);
        pnlMain.add(btnVerificationCode);
        pnlC.add(lblUserId);
        pnlC.add(txtUserNo);
        pnlC.add(lblUserEmail);
        pnlC.add(txtUserEmail);
        pnlC.add(lblInputCode);
        pnlC.add(txtCode);
        pnlC.add(lblNewPwd);
        pnlC.add(txtNewPwd);
        pnlC.add(lblConfirmedPwd);
        pnlC.add(txtConfirmedPwd);

        pnlS.add(btnUpdate);
        pnlS.add(btnCancel);

        pnlMain.add(pnlS,BorderLayout.SOUTH);
        pnlMain.add(pnlC,BorderLayout.CENTER);

        this.add(pnlMain);
        this.setVisible(true);
    }
}
