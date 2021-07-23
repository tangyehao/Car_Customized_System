package cn.com.services;

import cn.com.beans.User;

import java.util.List;


public interface UserInfoServiceInf {
	List<User> getUserInfo();

	List<User> getUserInfoByName(String name);

}
