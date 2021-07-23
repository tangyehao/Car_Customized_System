package cn.com.views.sellview;

import cn.com.utils.Center;

import javax.swing.*;
import java.awt.*;

public class PartsInfoView extends JDialog {
    private JPanel pnlMain;

    public PartsInfoView(Frame f, String title, boolean bool){
        super(f,title,bool);
        pnlMain = new JPanel(null);
        init();
    }

    private void init() {
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setSize(1000,650);
        this.add(pnlMain);
        Center.centerByWindow(this);
        this.setVisible(true);
    }
}
