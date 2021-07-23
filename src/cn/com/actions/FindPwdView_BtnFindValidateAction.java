package cn.com.actions;


import cn.com.services.UserBaseServiceInf;
import cn.com.services.impl.UserBaseServiceImpl;
import cn.com.views.loginview.FindPwdView;
import java.awt.*;
import java.util.EventObject;

public class FindPwdView_BtnFindValidateAction implements Action {
    private FindPwdView fpv;
    private UserBaseServiceInf service;
    public FindPwdView_BtnFindValidateAction(FindPwdView fpv){
        this.fpv=fpv;
        service = new UserBaseServiceImpl();
    }


    @Override
    public void execute(Object e, Container c, Object... params) {
        String value = fpv.getTxtUserNo().getText();
        if(service.validateByUserNo(value)){
            this.fpv.getLblMsgFromUserNo().setText("’ ∫≈¥Ê‘⁄");
            this.fpv.getLblMsgFromUserNo().setForeground(Color.green);
        }else{
            this.fpv.getLblMsgFromUserNo().setText("’ ∫≈≤ª¥Ê‘⁄!");
            this.fpv.getLblMsgFromUserNo().setForeground(Color.red);
        }
    }

}
