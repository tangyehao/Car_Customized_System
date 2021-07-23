package cn.com.dao;

import java.sql.Connection;
import java.util.List;


import cn.com.beans.User;

public interface UserInfoManageDaoInf {
	List<User> userExport(Connection con,String sql);
	boolean userUpdate(Connection con,String sql,User u);
	boolean userAdd(Connection con,String sql,User u);
}
