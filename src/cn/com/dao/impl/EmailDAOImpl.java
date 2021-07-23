package cn.com.dao.impl;

import cn.com.dao.EmailDAOInf;
import cn.com.db.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmailDAOImpl implements EmailDAOInf {

    @Override
    public boolean validateByUserEmail(Connection c, String sql,String uID, String uEmail) {
        boolean bool = false;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = c.prepareStatement(sql);
            pstm.setString(1, uID);
            pstm.setString(2, uEmail);
            rs = pstm.executeQuery();
            bool = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                DBUtil.freeResultSet(rs);
                DBUtil.freeStatement(pstm);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return bool;
    }
}
