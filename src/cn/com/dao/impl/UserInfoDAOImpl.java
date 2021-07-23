package cn.com.dao.impl;

import cn.com.beans.User;
import cn.com.dao.UserInfoDaoInf;
import cn.com.db.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserInfoDAOImpl implements UserInfoDaoInf {
    @Override
    public List<User> getUserAllInfo(Connection conn, String sql) {
        List<User> list = new ArrayList<User>();
        User sb = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()) {
                sb = new User();
                sb.setuName(rs.getString("user_name"));
                sb.setuJob(rs.getString("job_name"));
                sb.setuPhone(rs.getString("user_phone"));
                sb.setuAddress(rs.getString("user_address"));
                list.add(sb);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                DBUtil.freeResultSet(rs);
                DBUtil.freeStatement(pstm);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public List<User> getUserInfoByName(Connection conn, String sql, String name) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<User>();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,name);
            rs = pstm.executeQuery();
            User u = null;
            while(rs.next()){
                u = new User();
                u.setuName(rs.getString("user_name"));
                u.setuJob(rs.getString("job_name"));
                u.setuPhone(rs.getString("user_phone"));
                u.setuAddress(rs.getString("user_address"));
                list.add(u);
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
        return list;

    }
}
