package cn.com.dao.impl;

import cn.com.beans.User;
import cn.com.dao.UserDAOInf;
import cn.com.db.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBaseDAOImpl implements UserDAOInf {
    @Override
    public boolean validateByUserNoAndPwdAndState(Connection c, String sql, String userNo, String userPwd,String uState) {
        boolean bool = false;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = c.prepareStatement(sql);
            pstm.setString(1, userNo);
            pstm.setString(2, userPwd);
            pstm.setString(3,uState);
            rs = pstm.executeQuery();
            bool = rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                DBUtil.freeResultSet(rs);
                DBUtil.freeStatement(pstm);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return bool;
    }

    @Override
    public User getUserBaseByUserNo(Connection c, String sql, String userNo) {
        User ub = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = c.prepareStatement(sql);
            pstm.setString(1, userNo);
            rs = pstm.executeQuery();
            if (rs.next()) {
                ub = new User();
                ub.setuNo(rs.getString("user_no"));
                ub.setuName(rs.getString("user_name"));
                ub.setuPwd(rs.getString("user_password"));
                ub.setuJob(rs.getString("job_name"));
                ub.setuAge(rs.getString("user_age"));
                ub.setuSex(rs.getString("user_sex"));
                ub.setuAddress(rs.getString("user_address"));
                ub.setuPhone(rs.getString("user_phone"));
                ub.setuEmail(rs.getString("user_email"));
                ub.setuState(rs.getString("user_state"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                DBUtil.freeResultSet(rs);
                DBUtil.freeStatement(pstm);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return ub;
        }
    }

    @Override
    public boolean validateByUserNo(Connection c, String sql, String userNo) {
        boolean bool = false;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = c.prepareStatement(sql);
            pstm.setString(1, userNo);
            rs = pstm.executeQuery();
            bool = rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                DBUtil.freeResultSet(rs);
                DBUtil.freeStatement(pstm);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return bool;
    }

    @Override
    public boolean validateByUserEmail(Connection c, String sql, String userEmail) {
        boolean bool = false;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = c.prepareStatement(sql);
            pstm.setString(1, userEmail);
            rs = pstm.executeQuery();
            bool = rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                DBUtil.freeResultSet(rs);
                DBUtil.freeStatement(pstm);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return bool;
    }

    @Override
    public List<User> getAllUser(Connection c, String sql) {
        List<User> list = new ArrayList<User>();
        User ub = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = c.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ub = new User();
                ub.setuNo(rs.getString("user_no"));
                ub.setuName(rs.getString("user_name"));
                ub.setuPwd(rs.getString("user_password"));
                ub.setuJob(rs.getString("job_name"));
                ub.setuAge(rs.getString("user_age"));
                ub.setuSex(rs.getString("user_sex"));
                ub.setuAddress(rs.getString("user_address"));
                ub.setuPhone(rs.getString("user_phone"));
                ub.setuEmail(rs.getString("user_email"));
                ub.setuState(rs.getString("user_state"));
                list.add(ub);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                DBUtil.freeResultSet(rs);
                DBUtil.freeStatement(pstm);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return list;
        }
    }


    @Override
    public boolean updateUserPwd(Connection c, String sql, String userPwd,String uID) {
        boolean bool = false;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = c.prepareStatement(sql);
            pstm.setString(1, userPwd);
            pstm.setString(2,uID);
            rs = pstm.executeQuery();
            bool = rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                DBUtil.freeResultSet(rs);
                DBUtil.freeStatement(pstm);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return bool;
        }
    }
}