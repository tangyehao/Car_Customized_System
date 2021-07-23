package cn.com.dao;

import cn.com.beans.User;

import java.sql.Connection;

//用户的增删改查
public interface UserChangeDAOInf {
    boolean UserAdd(Connection con, String sql, User u);

    boolean UserUpdate(Connection con, String sql, User u);

    boolean UserDel(Connection con, String sql, User u);

//    List<UserInfoDto> UserSearch(Connection con, String sql);

}
