package cn.com.services.impl;

import cn.com.dao.EmailDAOInf;
import cn.com.dao.impl.EmailDAOImpl;
import cn.com.db.DBUtil;
import cn.com.services.EmailServiceInf;

import java.sql.Connection;
import java.sql.SQLException;

public class EmailServiceImpl implements EmailServiceInf {
    private EmailDAOInf dao;
    public EmailServiceImpl(){
        dao = new EmailDAOImpl();
    }
    @Override
    public boolean validateByUserEmail(String userNo,String userEmail) {
        boolean bool = false;
        Connection conn = null;
        try {
            conn = DBUtil.getConn();
            conn.setAutoCommit(false);
            String sql = "select * from tb_user where user_no = ? and user_email = ?";
            bool = dao.validateByUserEmail(conn,sql,userNo,userEmail);
            if(bool){
                conn.commit();
            }else{
                conn.rollback();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    DBUtil.freeConnection(conn);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return bool;
    }
}
