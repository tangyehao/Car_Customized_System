package cn.com.dao;

import java.sql.Connection;

public interface EmailDAOInf {
    boolean validateByUserEmail(Connection c, String sql,String userNo,String userEmail);
}
