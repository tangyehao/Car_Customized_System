package cn.com.views.loginview;

import cn.com.listeners.*;
import cn.com.utils.Center;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    private FindPwdView fpv;
    private JPanel pnlMain;
    private JPanel pnlN;
    private JPanel pnlS;
    private JPanel pnlC;
    private JPanel pnlfind;
    private JLabel lblMsg;
    private JLabel lblTitle;
    private JLabel lblUserId;
    private JLabel lbluserPwd;
    private JTextField txtUserNo;
    private JPasswordField UserPwd;
    private JButton btnLogin;
    private JButton btnQuit;
    private JButton btnFind;

    public LoginView(){
        initObject();
        init();
    }
    public LoginView(String title){
        super(title);
        initObject();
        init();
    }
    public LoginView(FindPwdView fpv){
        this.fpv = fpv;
    }

    private void initObject() {
        pnlMain = new JPanel(new BorderLayout());
        pnlN = new JPanel();
        pnlS = new JPanel(null);
        pnlC = new JPanel(null);
        pnlfind = new JPanel(null);
        this.lblMsg = new JLabel();
        lblTitle = new JLabel("用户登录");
        lblUserId = new JLabel("帐号:");
        lbluserPwd = new JLabel("密码:");
        txtUserNo = new JTextField();
        UserPwd = new JPasswordField();
        btnLogin = new JButton("登录");

        btnQuit = new JButton("退出");
        btnFind = new JButton("忘记密码");

    }

    public JTextField getTxtUserNo() {
        return txtUserNo;
    }

    public JPasswordField getUserPwd() {
        return UserPwd;
    }

    public JLabel getLblMsg() {
        return lblMsg;
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public JButton getBtnQuit() {
        return btnQuit;
    }

    public JButton getBtnFind() {
        return btnFind;
    }

    private void init() {

        this.setSize(new Dimension(500,360));//设置窗口大小
        this.setIconImage(new ImageIcon("images/图标.png").getImage());//设置图标
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置默认关闭操作
        Center.centerByWindow(this);
        this.setResizable(false);

        pnlS.setPreferredSize(new Dimension(440,100));

        lblUserId.setBounds(100,60,70,30);
        lbluserPwd.setBounds(100,120,70,30);

        txtUserNo.setBounds(180,60,160,30);
        UserPwd.setBounds(180,155,160,30);
        lblMsg.setBounds(350,60,210,25);

        btnFind.setBounds(80,20,100,25);
        btnLogin.setBounds(200,20,100,25);
        btnQuit.setBounds(320,20,80,25);

        btnLogin.setEnabled(true);//设置是否启用控件，默认true
        btnLogin.setToolTipText("我是登录按钮哦~");//悬屏提示
        btnFind.setToolTipText("忘记密码了？点我试试~");
        btnQuit.setToolTipText("点我就要说再见了哦~");

        txtUserNo.setHorizontalAlignment(JTextField.CENTER);//输入居中对齐
        UserPwd.setHorizontalAlignment(JTextField.CENTER);//输入居中对齐
        txtUserNo.setForeground(Color.blue);
        txtUserNo.setFont(new Font("宋体",Font.BOLD,16));
        UserPwd.setFont(new Font("宋体",Font.BOLD,16));

        lblTitle.setFont(new Font("宋体",Font.BOLD,20));
        lblUserId.setFont(new Font("宋体",Font.BOLD,16));
        lbluserPwd.setFont(new Font("宋体",Font.BOLD,16));
        btnLogin.setFont(new Font("宋体",Font.BOLD,16));
        btnQuit.setFont(new Font("宋体",Font.BOLD,16));
        btnFind.setFont(new Font("宋体",Font.BOLD,16));

        btnQuit.addActionListener(new LoginView_btnLogin_ActionListener(this));
        btnLogin.addActionListener(new LoginView_btnLogin_ActionListener(this));
        btnFind.addActionListener(new FindPwdView_btnFindPwd_ActionListener());
        txtUserNo.addMouseListener(new LoginView_btnLogin_MouseListener(this));
        txtUserNo.getDocument().addDocumentListener(new LoginView_btnLogin_DocumentListener(this));

        lblMsg.setForeground(Color.RED);
        pnlC.add(lblUserId);
        pnlC.add(txtUserNo);
        pnlC.add(lbluserPwd);
        pnlC.add(lblMsg);
        pnlMain.add(UserPwd);

        pnlN.add(lblTitle);
        pnlS.add(btnFind);
        pnlS.add(btnLogin);
        pnlS.add(btnQuit);

        pnlMain.add(pnlN,BorderLayout.NORTH);
        pnlMain.add(pnlS,BorderLayout.SOUTH);
        pnlMain.add(pnlC,BorderLayout.CENTER);

        this.add(pnlMain);//压入面板
        this.setVisible(true);//是否可见
//        String s = new String(UserPwd.getPassword()); //获得自定义的密码
//        System.out.println(s);
    }

    //窗口上压面板，面板上压面板或控件
}
