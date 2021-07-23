package cn.com.services;

import java.util.List;

import cn.com.beans.User;

public interface UserManageServiseInf {
	List<User> userExport();
	boolean userUpdate(User u);
	boolean userAdd(User u);
	List<User>  userExportByName(String uName);
	List<User>  userExportByPhone(String uPhone);
	List<User>  userExportByJob(String uJob);
}
