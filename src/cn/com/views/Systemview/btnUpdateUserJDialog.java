package cn.com.views.Systemview;

import cn.com.beans.User;
import cn.com.services.UserChangeServiceInf;
import cn.com.services.UserInfoServiceInf;
import cn.com.services.impl.UserChangeServiceImpl;
import cn.com.services.impl.UserInfoServiceImpl;
import cn.com.utils.Center;
import cn.com.utils.CheckEmail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class btnUpdateUserJDialog extends JDialog{

    private JLabel lblUserName;
    private JLabel lblJob;
    private JLabel lblPhone;
    private JLabel lblUserAddress;
    private JLabel lblUserEmail;
    private JLabel lblUserState;

    private JTextField txtUserName;
    private JTextField txtPhone;
    private JTextField txtUserAddress;
    private JTextField txtUserEmail;

    private JButton btnSave;
    private JButton btnQuit;
    private UserChangeServiceInf serviceChange;
    private UserInfoServiceInf service;
    private User u;

    private JComboBox<String> cmbJob;
    private DefaultComboBoxModel<String> dcmbJob;

    private JComboBox<String> cmbState;
    private DefaultComboBoxModel<String> dcmbState;

    private JPanel pnlMain;


    public btnUpdateUserJDialog(Frame f, String title, boolean bool, User u){
        super(f,title,bool);
        this.u = u;
        pnlMain = new JPanel(null);
        serviceChange = new UserChangeServiceImpl();
        service = new UserInfoServiceImpl();
        lblUserName = new JLabel("员工姓名:");
        lblJob = new JLabel("职务:");
        lblPhone = new JLabel("联系电话:");
        lblUserAddress = new JLabel("联系地址:");
        lblUserEmail = new JLabel("邮箱");
        lblUserState = new JLabel("状态");

        txtUserName = new JTextField(u.getuName(),10);

        txtPhone = new JTextField(u.getuPhone(),10);
        txtUserAddress = new JTextField(u.getuAddress(),10);
        txtUserEmail = new JTextField(u.getuEmail(),10);

        cmbJob = new JComboBox<>();
        dcmbJob = new DefaultComboBoxModel<String>();

        cmbState = new JComboBox<String>();
        dcmbState = new DefaultComboBoxModel<String>();

        btnSave = new JButton("保存");
        btnQuit = new JButton("退出");

        init();
    }

    private void init() {
        // TODO Auto-generated method stub
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setSize(800, 600);
        this.setResizable(false);

        Center.centerByWindow(this);
        setCmbStateData();
        setCmbJobData();

        lblUserName.setBounds(40, 130, 75, 30);
        lblUserName.setFont(new Font("宋体",Font.BOLD,15));
        txtUserName.setBounds(150,130,130,25);

        txtUserName.setEditable(false);

        lblJob.setBounds(40, 170, 75, 30);
        lblJob.setFont(new Font("宋体",Font.BOLD,15));
        cmbJob.setBounds(150,170,130,25);

        lblPhone.setBounds(40,250,75,30);
        lblPhone.setFont(new Font("宋体",Font.BOLD,15));
        txtPhone.setBounds(150,250,130,25);

        lblUserAddress.setBounds(40,290,75,30);
        lblUserAddress.setFont(new Font("宋体",Font.BOLD,15));
        txtUserAddress.setBounds(150,290,130,25);

        lblUserState.setBounds(40,330,75,30);
        lblUserState.setFont(new Font("宋体",Font.BOLD,15));
        cmbState.setBounds(150,330,75,30);


        lblUserEmail.setBounds(40,410,75,25);
        lblUserEmail.setFont(new Font("宋体",Font.BOLD,15));
        txtUserEmail.setBounds(150,410,130,25);

        btnSave.setBounds(200,500,75,25);
        btnSave.setFont(new Font("宋体",Font.BOLD,15));

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateUser();
            }
        });

        btnQuit.setBounds(320,500,75,25);
        btnQuit.setFont(new Font("宋体",Font.BOLD,15));

        pnlMain.add(lblUserName);
        pnlMain.add(lblJob);
        pnlMain.add(lblPhone);
        pnlMain.add(lblUserAddress);
        pnlMain.add(lblUserState);
        pnlMain.add(lblUserEmail);
        pnlMain.add(txtUserName);
        pnlMain.add(cmbJob);
        pnlMain.add(cmbState);
        pnlMain.add(txtPhone);
        pnlMain.add(txtUserAddress);
        pnlMain.add(txtUserEmail);
        pnlMain.add(btnSave);
        pnlMain.add(btnQuit);
        this.add(pnlMain);
        this.setVisible(true);
    }

    private void setCmbStateData() {
        this.dcmbState.addElement("正常");
        this.dcmbState.addElement("禁用");
        cmbState.setModel(dcmbState);
    }

    private void setCmbJobData() {
        this.dcmbJob.addElement("管理员");
        this.dcmbJob.addElement("采购员");
        this.dcmbJob.addElement("销售员");
        this.dcmbJob.addElement("仓管");
        this.dcmbJob.addElement("财务员");
        cmbJob.setModel(dcmbJob);
    }

    private void updateUser() {
    	if(txtUserName.getText().equals("")){
        	JOptionPane.showMessageDialog(this,"姓名不能为空","错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(txtUserName.getText().length() >10){
			JOptionPane.showMessageDialog(this,"姓名长度非法","错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
        u.setuName(txtUserName.getText());
        
        u.setuJob(String.valueOf(cmbJob.getSelectedItem()));
        
		if(txtPhone.getText().length() != 11){
			JOptionPane.showMessageDialog(this,"请设置11位电话号码","错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
        u.setuPhone(txtPhone.getText());
        
        u.setuAddress(txtUserAddress.getText());
        
        u.setuState(String.valueOf(cmbState.getSelectedItem()));
        
        if(!CheckEmail.CheckEmail(txtUserEmail.getText())){
        	JOptionPane.showMessageDialog(this,"邮箱非法","错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
        u.setuEmail(txtUserEmail.getText());
        if(txtUserName.getText().equals("") || txtUserAddress.equals("") || txtPhone.getText().equals("")|| txtUserEmail.getText().equals("")){
            JOptionPane.showMessageDialog(this,"请填写每一项","错误",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(serviceChange.UserUpdate(u)){
            List<User> list = service.getUserInfo();
            btnUserJDialog.setTabData(list);
            this.dispose();
        }
    }

}
