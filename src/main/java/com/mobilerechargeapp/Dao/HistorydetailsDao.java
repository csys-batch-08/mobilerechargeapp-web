package com.mobilerechargeapp.Dao;

import java.sql.ResultSet;
import java.util.List;

import com.mobilerechargeapp.model.HistoryDetails;
import com.mobilerechargeapp.model.User;

public interface HistorydetailsDao {
	 public boolean insertDetails(HistoryDetails historyDetails);
// 	public HistoryDetails rechargeRemainder(User user);
	 public List<HistoryDetails> showHistoryDetails();
	 public List<HistoryDetails> findUserHis(User user);
	public List<HistoryDetails> findUserHistory(User user);
	
}
