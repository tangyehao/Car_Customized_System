package cn.com.listeners;

import cn.com.actions.Action;
import cn.com.actions.ActionFactory;
import cn.com.views.Systemview.btnAddUserJDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PnlSellView_BtnUserActionListener implements ActionListener {
    private Action action;
    private btnAddUserJDialog btnAdd;
    public PnlSellView_BtnUserActionListener(btnAddUserJDialog btnAdd){
        this.btnAdd = btnAdd;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        action = ActionFactory.createSellStaffAction();
        action.execute(e,btnAdd);
    }
}
