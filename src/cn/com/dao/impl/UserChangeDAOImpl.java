package cn.com.dao.impl;

import cn.com.beans.User;
import cn.com.dao.UserChangeDAOInf;
import cn.com.db.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserChangeDAOImpl implements UserChangeDAOInf {
    @Override
    public boolean UserAdd(Connection con, String sql, User u) {
        boolean bool = false;
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1,u.getuNo());
            pstm.setString(2,u.getuName());
            pstm.setString(3,u.getuPwd());
            pstm.setString(4,u.getuJob());
            pstm.setString(5,u.getuAge());
            pstm.setString(6,u.getuSex());
            pstm.setString(7,u.getuAddress());
            pstm.setString(8,u.getuPhone());
            pstm.setString(9,u.getuEmail());
            pstm.setString(10,u.getuState());
            int len = pstm.executeUpdate();
            if(len >0) {
                bool = true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                DBUtil.freeStatement(pstm);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return bool;
    }

    @Override
    public boolean UserUpdate(Connection con, String sql, User u) {
        boolean bool = false;
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1,u.getuJob());
            pstm.setString(2,u.getuPhone());
            pstm.setString(3,u.getuAddress());
            pstm.setString(4,u.getuEmail());
            pstm.setString(5,u.getuState());
            pstm.setString(6,u.getuName());
            int len = pstm.executeUpdate();
            if(len >0) {
                bool = true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                DBUtil.freeStatement(pstm);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return bool;
    }

    @Override
    public boolean UserDel(Connection con, String sql, User u) {
        boolean bool = false;
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1,u.getuName());
            int len = pstm.executeUpdate();
            if(len >0) {
                bool = true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                DBUtil.freeStatement(pstm);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return bool;
    }
}
