package com.mobilerechargeapp.Dao;

import java.sql.ResultSet;
import java.util.List;

import com.mobilerechargeapp.model.JioUser;

public interface JioDao {
	public boolean insertJionet(JioUser jio);
	public boolean updateJio(String planName1, Double price1, String validity1, String benefits1, int jioplanId);
	public boolean deleteJio(int jioplanId);
	public List<JioUser> showJioplan();
	public  int findjioId(String planName, Double price);
	public int  findJiovalidity(JioUser jioUser);
}
