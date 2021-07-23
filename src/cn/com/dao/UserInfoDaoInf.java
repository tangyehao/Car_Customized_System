package cn.com.dao;

import cn.com.beans.User;

import java.sql.Connection;
import java.util.List;

public interface UserInfoDaoInf {
	List<User> getUserAllInfo(Connection conn, String sql);

	List<User> getUserInfoByName(Connection conn, String sql, String name);


}
