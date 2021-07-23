package cn.com.actions;


import cn.com.views.sellview.btnAccount_JDialog;

import java.awt.*;

public class PnlSellView_BtnAccountAction implements Action {
    @Override
    public void execute(Object e,Container c, Object... params) {
        new btnAccount_JDialog(new Frame(),"Õ˘¿¥’ ŒÒ",true);
    }
}
