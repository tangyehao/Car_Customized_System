package cn.com.actions;


import cn.com.views.sellview.SellDocumentView;

import java.awt.*;

public class PnlSellView_BtnSellDocumentAction implements Action {
    @Override
    public void execute(Object e, Container c, Object... params) {
        new SellDocumentView(new Frame(),"���۵��ݲ�ѯ",true);
    }
}
