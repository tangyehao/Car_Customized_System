package cn.com.listeners;

import cn.com.actions.Action;
import cn.com.actions.ActionFactory;
import cn.com.views.sellview.AccountView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PnlSellView_BtnAccountActionListener implements ActionListener {
    private Action action;
    private AccountView accountView;
    public PnlSellView_BtnAccountActionListener(AccountView accountView){
        this.accountView = accountView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        action = ActionFactory.createAccountAction();
        action.execute(e,accountView);
    }
}
