package cn.com.services;

import cn.com.beans.User;


public interface UserChangeServiceInf {
    boolean addUserInfo(User u);

    boolean UserUpdate(User u);

    boolean UserDel(User u);

//    List<User> UserSearch(String userName);

}
