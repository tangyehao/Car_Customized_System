package cn.com.dao;

import cn.com.beans.User;

import java.sql.Connection;
import java.util.List;

public interface UserDAOInf {
    boolean validateByUserNoAndPwdAndState(Connection c, String sql, String uID, String uPwd,String uState);

    User getUserBaseByUserNo(Connection c, String sql, String uNo);

    boolean validateByUserNo(Connection c, String sql, String uNo);

    boolean validateByUserEmail(Connection c, String sql, String uEmail);

    List<User> getAllUser(Connection c, String sql);

    boolean updateUserPwd(Connection c,String sql,String uPwd,String uNo);

}