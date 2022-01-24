package com.mobilerechargeapp.Dao;

import java.sql.ResultSet;

import com.mobilerechargeapp.model.User;

public interface UserDao {
	public boolean insertUser(User user);
	public User validiateUser(String Emailid, String password);
	public int findUserId(User user);
	public  User findUser(String emailId);
	public int updateuserWallet(User user);
    public boolean rechargeWalletupdate(double planPrice, User user);
    public ResultSet history(int userId);
}