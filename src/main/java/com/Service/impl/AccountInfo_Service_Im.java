package com.Service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EntityUtil.UtilAccountInfo;
import com.Mapper.AccountInfoMapper;
import com.Pojo.AccountInfo;
import com.Service.AccountInfo_Service;
import com.util.JsonUtils;
@Service
public class AccountInfo_Service_Im implements AccountInfo_Service {
	@Autowired
	private AccountInfoMapper accountInfoMapper;
	public int insertAccountInfo(AccountInfo accountInfo) {
		
		return accountInfoMapper.insert(accountInfo);
	}

	public AccountInfo selectByNameKey(String phoneNumber) {
		
		return accountInfoMapper.selectByName(phoneNumber);
	}
	
	public UtilAccountInfo selectByLogin(String username ,	String password) {
		UtilAccountInfo uInfo = new UtilAccountInfo();
		AccountInfo logInfo = accountInfoMapper.selectByLogin(username, password);
		BeanUtils.copyProperties(logInfo, uInfo, new String[] { "createtime" , "updatetime"});
		uInfo.setUpdatetime(JsonUtils.dateToStrLong(logInfo.getUpdatetime()));
		uInfo.setCreatetime(JsonUtils.dateToStrLong(logInfo.getCreatetime()));
		return uInfo;
	}

	public AccountInfo selectPwd(int id) {
		
		return accountInfoMapper.selectByPrimaryKey(id);
	}

	public int updateAccount(AccountInfo account) {
		
		return accountInfoMapper.updateByPrimaryKeySelective(account);
	}

}
