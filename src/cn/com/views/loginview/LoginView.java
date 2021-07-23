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
        lblTitle = new JLabel("�û���¼");
        lblUserId = new JLabel("�ʺ�:");
        lbluserPwd = new JLabel("����:");
        txtUserNo = new JTextField();
        UserPwd = new JPasswordField();
        btnLogin = new JButton("��¼");

        btnQuit = new JButton("�˳�");
        btnFind = new JButton("��������");

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

        this.setSize(new Dimension(500,360));//���ô��ڴ�С
        this.setIconImage(new ImageIcon("images/ͼ��.png").getImage());//����ͼ��
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����Ĭ�Ϲرղ���
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

        btnLogin.setEnabled(true);//�����Ƿ����ÿؼ���Ĭ��true
        btnLogin.setToolTipText("���ǵ�¼��ťŶ~");//������ʾ
        btnFind.setToolTipText("���������ˣ���������~");
        btnQuit.setToolTipText("���Ҿ�Ҫ˵�ټ���Ŷ~");

        txtUserNo.setHorizontalAlignment(JTextField.CENTER);//������ж���
        UserPwd.setHorizontalAlignment(JTextField.CENTER);//������ж���
        txtUserNo.setForeground(Color.blue);
        txtUserNo.setFont(new Font("����",Font.BOLD,16));
        UserPwd.setFont(new Font("����",Font.BOLD,16));

        lblTitle.setFont(new Font("����",Font.BOLD,20));
        lblUserId.setFont(new Font("����",Font.BOLD,16));
        lbluserPwd.setFont(new Font("����",Font.BOLD,16));
        btnLogin.setFont(new Font("����",Font.BOLD,16));
        btnQuit.setFont(new Font("����",Font.BOLD,16));
        btnFind.setFont(new Font("����",Font.BOLD,16));

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

        this.add(pnlMain);//ѹ�����
        this.setVisible(true);//�Ƿ�ɼ�
//        String s = new String(UserPwd.getPassword()); //����Զ��������
//        System.out.println(s);
    }

    //������ѹ��壬�����ѹ����ؼ�
}
