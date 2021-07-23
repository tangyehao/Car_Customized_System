package cn.com.services.impl;



import cn.com.beans.User;
import cn.com.dao.UserChangeDAOInf;
import cn.com.dao.impl.UserChangeDAOImpl;
import cn.com.db.DBUtil;
import cn.com.services.UserChangeServiceInf;

import java.sql.Connection;
import java.sql.SQLException;

public class UserChangeServiceImpl implements UserChangeServiceInf {
    private UserChangeDAOInf dao;
    public UserChangeServiceImpl(){
        dao = new UserChangeDAOImpl();
    }
    @Override
    public boolean addUserInfo(User u) {
        boolean bool = false;
        Connection con = null;
        String sql = "insert into tb_user values(seq_tb_user.nextval,?,?,?,?,?,?,?,?,?,?)";
        try {
            con = DBUtil.getConn();
            con.setAutoCommit(false);
            bool = dao.UserAdd(con,sql,u);
            if(bool) {
                con.commit();
            } else {
                con.rollback();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            try {
                DBUtil.freeConnection(con);
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return bool;
    }

    @Override
    public boolean UserUpdate(User u) {
        boolean bool = false;
        Connection con = null;

        String sql = "update tb_user set job_name = ?,user_phone = ?,user_address = ?,user_email = ?,user_state = ? where user_name = ?";
        try {
            con = DBUtil.getConn();
            con.setAutoCommit(false);
            bool = dao.UserUpdate(con,sql,u);
            if(bool) {
                con.commit();
            } else {
                con.rollback();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            try {
                DBUtil.freeConnection(con);
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return bool;
    }

    @Override
    public boolean UserDel(User u) {
        boolean bool = false;
        Connection con = null;

        String sql = "update tb_user set user_state = '½ûÓÃ' where user_name = ?";
        try {
            con = DBUtil.getConn();
            con.setAutoCommit(false);
            bool = dao.UserDel(con,sql,u);
            if(bool) {
                con.commit();
            } else {
                con.rollback();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            try {
                DBUtil.freeConnection(con);
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return bool;
    }
}
