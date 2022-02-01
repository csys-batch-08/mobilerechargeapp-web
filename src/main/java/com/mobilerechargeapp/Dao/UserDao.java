package com.mobilerechargeapp.Dao;

import java.sql.ResultSet;
import java.util.List;

import com.mobilerechargeapp.model.User;

public interface UserDao {
	public boolean insertUser(User user);
	public User validiateUser(String Emailid, String password);
	public int findUserId(User user);
	public  User findUser(String emailId);
	public int updateuserWallet(User user);
//	public int updateuserWallet(User user,double amount);
    public boolean rechargeWalletupdate(double planPrice, User user);
    public List<Object> history(int userId) ;
}