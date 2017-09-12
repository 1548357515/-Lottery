package com.Service;

import java.util.Date;

import com.EntityUtil.UtilAcountFund;


public interface AcountFund_Service {
	int insertAcountFund (int id , Date creatDate , Date upDate);
	
	/**
	 * 根据个人id查询资产
	 * @param count_id
	 * @return
	 */
	UtilAcountFund selectBycount(Integer count_id);
}
