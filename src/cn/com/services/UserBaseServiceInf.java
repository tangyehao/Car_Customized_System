package cn.com.services;

import cn.com.beans.User;

import java.util.List;

public interface UserBaseServiceInf {
    boolean validateByUserNoAndPwd(String uID, String uPwd,String uState);
    User getUserBaseByUserNo(String uNo);
    boolean validateByUserNo(String uNo);
    List<User> getAllUsers();
    boolean validateByUserEmail(String userEmail);
    boolean updateUserPwd(String userPassword,String uNo);


}
