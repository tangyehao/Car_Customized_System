package cn.com.views.sellview;

import cn.com.utils.Center;

import javax.swing.*;
import java.awt.*;

public class AccountView extends JDialog {
    private JPanel pnlMain;
    private JTabbedPane all;//�ͻ����е���
    private JTabbedPane custom;//�ͻ��������
    private JTabbedPane account;//�ͻ�������Ϣ
    private btnAccount_CustomSituationPanel btnAccount_customSituationPane;
    public AccountView(Frame f,String title,boolean bool){
        super(f,title,bool);
        pnlMain = new JPanel(null);
        all = new JTabbedPane();
        custom = new JTabbedPane();
        account  = new JTabbedPane();
        init();
    }

    private void init() {
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setSize(1100,700);

        pnlMain.add(all);
        this.add(pnlMain);
        Center.centerByWindow(this);
        this.setVisible(true);

    }
}
