package cn.com.services.impl;

import cn.com.beans.User;
import cn.com.dao.UserDAOInf;
import cn.com.dao.impl.UserBaseDAOImpl;
import cn.com.db.DBUtil;
import cn.com.services.UserBaseServiceInf;
import cn.com.views.loginview.FindPwdView;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserBaseServiceImpl implements UserBaseServiceInf {

    private UserDAOInf dao;
    private FindPwdView fpv;
    public UserBaseServiceImpl(FindPwdView fpv){
        this.fpv = fpv;
    }
    public UserBaseServiceImpl(){
        dao = new UserBaseDAOImpl();
    }
    @Override
    public boolean validateByUserNoAndPwd(String uID, String uPwd,String uState) {
        boolean bool = false;
        Connection conn = null;
        try {
            conn = DBUtil.getConn();
            conn.setAutoCommit(false);
            String sql = "select * from tb_user where user_no = ? and user_password=? and user_state=?";
            bool = dao.validateByUserNoAndPwdAndState(conn,sql,uID,uPwd,uState);
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

    @Override
    public User getUserBaseByUserNo(String uID) {
        User ub = null;
        Connection conn = null;
        try {
            conn = DBUtil.getConn();
            conn.setAutoCommit(false);
            String sql = "select * from tb_user where user_no = ?";
            ub = dao.getUserBaseByUserNo(conn,sql,uID);
            if(ub != null){
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
        return ub;
    }

    @Override
    public boolean validateByUserNo(String uID) {
        boolean bool = false;
        Connection conn = null;
        try {
            conn = DBUtil.getConn();
            conn.setAutoCommit(false);
            String sql = "select * from tb_user where user_no  = ?";
            bool = dao.validateByUserNo(conn,sql,uID);
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



    @Override
    public List<User> getAllUsers() {
        List<User> list= null;
        Connection conn = null;
        try {
            conn = DBUtil.getConn();
            conn.setAutoCommit(false);
            String sql = "select * from tb_user";
            list = dao.getAllUser(conn,sql);
            conn.commit();
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
        return list;
    }

    @Override
    public boolean validateByUserEmail(String userEmail) {
        boolean bool = false;
        Connection conn = null;
        try {
            conn = DBUtil.getConn();
            conn.setAutoCommit(false);
            String sql = "select * from tb_user where user_email = ?";
            bool = dao.validateByUserEmail(conn,sql,userEmail);
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

    @Override
    public boolean updateUserPwd(String userPwd, String uID) {
        boolean bool = false;
        Connection conn = null;
        try {
            conn = DBUtil.getConn();
            conn.setAutoCommit(false);
            String sql = "update tb_user set user_password = ? where user_no = ?";
            bool = dao.updateUserPwd(conn,sql,userPwd,uID);
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
            } finally {
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
