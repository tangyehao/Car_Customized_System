package cn.com.actions;


import cn.com.views.Systemview.btnUserJDialog;

import java.awt.*;

public class PnlSellView_BtnSellStaffAction implements Action {
    @Override
    public void execute(Object e, Container c, Object... params) {
        new btnUserJDialog(new Frame(),"Ա����Ϣ",true);
    }
}
