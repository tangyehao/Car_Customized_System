package cn.com.actions;


import cn.com.views.inventoryselectview.btnSearchJFrame;

import java.awt.*;

public class PnlSellView_BtnSellStoreAction implements Action {
    @Override
    public void execute(Object e, Container c, Object... params) {
        new btnSearchJFrame(new Frame(),"µ±«∞ø‚¥Ê≤È—Ø",true);
    }
}
