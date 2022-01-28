package com.mobilerechargeapp.Dao;


import java.util.List;

import com.mobilerechargeapp.model.BsnlUser;

public interface BsnlDao {
	public boolean insertBsnlnetwork(BsnlUser bsnl);
	public boolean updateBsnl(String planName, Double price, String validity, String benefits, int bsnlId);
	public boolean deleteBsnl(int bsnlId);
	public int findbsnlId(String planName, Double price);
	public List<BsnlUser> showBsnlplan();
	public List<BsnlUser> showBsnlplan(String search);
//	public ResultSet  findBsnlvalidity() ;
	public BsnlUser findPlan(int id);
	public int  findBsnlvalidity(BsnlUser bsnlUser);

}
