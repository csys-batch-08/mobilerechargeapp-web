package com.mobilerechargeapp.Dao;


import java.util.List;

import com.mobilerechargeapp.model.AirtelUser;

public interface AirtelDao {
	 public boolean insertAirtelnet(AirtelUser airtel);
	 public boolean updateAirtel(String planname, Double price, String validity, String benefits,int airtelplanId);
	 public boolean deleteAirtel(int airtelplanId);
	 public List<AirtelUser>showAirtelplan();
	 public List<AirtelUser>showAirtelplan(String search);
	 public  int  findairtelId(String planName,Double price);
//	 public ResultSet  findAirtelvalidity();
	  public AirtelUser findPlan(int id);
	  public int findAirtelvalidity(AirtelUser airtelUser);
}