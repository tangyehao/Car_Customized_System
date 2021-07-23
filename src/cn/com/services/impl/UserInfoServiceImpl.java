package cn.com.services.impl;

import cn.com.beans.User;
import cn.com.dao.UserInfoDaoInf;
import cn.com.dao.impl.UserBaseDAOImpl;
import cn.com.dao.impl.UserInfoDAOImpl;
import cn.com.db.DBUtil;
import cn.com.services.UserBaseServiceInf;
import cn.com.services.UserInfoServiceInf;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserInfoServiceImpl implements UserInfoServiceInf {
    private UserInfoDaoInf dao;
    private UserBaseDAOImpl dao1;
    public UserInfoServiceImpl(){
        dao = new UserInfoDAOImpl();
        dao1 = new UserBaseDAOImpl();
    }
    @Override
    public List<User> getUserInfo() {
        Connection conn = null;
        List<User> list = null;
        String sql = "select user_name,job_name,user_phone,user_address from tb_user";
        try {
            conn = DBUtil.getConn();
            conn.setAutoCommit(false);
            list = dao.getUserAllInfo(conn,sql);
            conn.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } finally {
            try {
                DBUtil.freeConnection(conn);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public List<User> getUserInfoByName(String name) {
        Connection conn = null;
        List<User> list = null;
        String sql = "select user_name,job_name,user_phone,user_address from tb_user where user_name = ?";
        try {
            conn = DBUtil.getConn();
            conn.setAutoCommit(false);
            list = dao.getUserInfoByName(conn,sql,name);
            conn.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } finally {
            try {
                DBUtil.freeConnection(conn);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;
    }

}
