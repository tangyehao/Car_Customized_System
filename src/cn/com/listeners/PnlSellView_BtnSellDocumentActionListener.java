package cn.com.listeners;


import cn.com.actions.Action;
import cn.com.actions.ActionFactory;
import cn.com.views.sellview.SellDocumentView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PnlSellView_BtnSellDocumentActionListener implements ActionListener {
    private Action action;
    private SellDocumentView sellDocument;
    public PnlSellView_BtnSellDocumentActionListener(SellDocumentView sellDocument){
        this.sellDocument = sellDocument;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        action = ActionFactory.createSellDocumentAction();
        action.execute(e,sellDocument);
    }
}
