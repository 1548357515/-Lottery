package com.Service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EntityUtil.UtilAcountFund;
import com.Mapper.AcountFundMapper;
import com.Pojo.AcountFund;
import com.Service.AcountFund_Service;
import com.util.JsonUtils;
@Service
public class AcountFund_Service_Im implements AcountFund_Service {
	@Autowired
	private AcountFundMapper acountFundMapper;
	public int insertAcountFund(int id , Date creatDate , Date upDate) {
		AcountFund acountFund = new AcountFund();
		acountFund.setAccountid(id);
		acountFund.setBalance(0L);
		acountFund.setCreatetime(creatDate);
		acountFund.setWithdrawlimit(0L);
		acountFund.setUpdatetime(upDate);
		int insert = acountFundMapper.insert(acountFund);
		return insert;
	}
	public UtilAcountFund selectBycount(Integer count_id) {
		UtilAcountFund uFund = new UtilAcountFund();
		AcountFund seFund = acountFundMapper.selectByCountId(count_id);
		BeanUtils.copyProperties(seFund, uFund, new String[] { "createtime" , "updatetime"});
		uFund.setUpdatetime(JsonUtils.dateToStrLong(seFund.getUpdatetime()));
		uFund.setCreatetime(JsonUtils.dateToStrLong(seFund.getCreatetime()));
		return uFund;
	}

}
