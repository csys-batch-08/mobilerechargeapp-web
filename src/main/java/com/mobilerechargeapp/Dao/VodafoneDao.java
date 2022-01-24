package com.mobilerechargeapp.Dao;

import java.sql.ResultSet;
import java.util.List;

import com.mobilerechargeapp.model.VodafoneUser;

public interface VodafoneDao {
	public boolean vodafoneNetwork(VodafoneUser vodafone);
	public boolean updateVodafone( String planName, Double price, String validity, String benefits,int vodafoneplanid);
	public boolean deleteVodafone(int vodafoneId);
	public int findvodafoneId(String planName, Double price) ;
	public List<VodafoneUser> showViplan();
	public ResultSet  findVodafonevalidity();

}
