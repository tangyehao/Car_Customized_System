package cn.com.listeners;

import cn.com.actions.Action;
import cn.com.actions.ActionFactory;
import cn.com.views.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView_BtnChange_ActionListener implements ActionListener {
    private MainView mv;
    private Action action;
    public MainView_BtnChange_ActionListener(MainView mv){
        this.mv = mv;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        action = ActionFactory.createChangeAction();
        action.execute(e,mv);
    }
}
