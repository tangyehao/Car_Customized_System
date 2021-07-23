package cn.com.actions;


import cn.com.views.loginview.FindPwdView;

import java.awt.*;

public class FindPwdView_BtnCancelAction implements Action {
    @Override
    public void execute(Object e, Container fpv, Object... params) {
        FindPwdView f = (FindPwdView)fpv;
        f.dispose();
    }
}
