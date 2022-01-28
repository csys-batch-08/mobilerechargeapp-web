package com.mobilerechargeapp.Dao;


import java.util.List;

import com.mobilerechargeapp.model.VodafoneUser;

public interface VodafoneDao {
	public boolean vodafoneNetwork(VodafoneUser vodafone);
	public boolean updateVodafone( String planName, Double price, String validity, String benefits,int vodafoneplanid);
	public boolean deleteVodafone(int vodafoneId);
	public int findvodafoneId(String planName, Double price) ;
	public List<VodafoneUser> showViplan();
	public List<VodafoneUser> showViplan(String search);
//	public ResultSet  findVodafonevalidity();
	public VodafoneUser findPlan(int id);
	public int findVodafonevalidity(VodafoneUser vodafoneUser);
}
