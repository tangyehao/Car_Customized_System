package cn.com.listeners;

import cn.com.actions.Action;
import cn.com.actions.ActionFactory;
import cn.com.views.stockview.StockView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PnlSellView_BtnstoreActionListener implements ActionListener {

    private Action action;
    private StockView storeView;
    public PnlSellView_BtnstoreActionListener(StockView storeView){
        this.storeView = storeView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        action = ActionFactory.createStockView_btnStock_Action();
        action.execute(e,storeView);
    }
}
