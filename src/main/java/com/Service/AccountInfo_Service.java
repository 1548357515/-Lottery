package com.Service;

import com.EntityUtil.UtilAccountInfo;
import com.Pojo.AccountInfo;

public interface AccountInfo_Service {
	/**
	 * 插入accountinfo表
	 * @param accountInfo 数据
	 * @return
	 */
	int insertAccountInfo(AccountInfo accountInfo);
	
	/**
	 * 查询手机号是否注册
	 * @param name 手机号
	 * @return
	 */
	AccountInfo selectByNameKey(String phoneNumber);
	/**
	 * 登录
	 * @param username 昵称
	 * @param password 密码
	 * @return
	 */
    UtilAccountInfo selectByLogin(String username ,String password) ;
    
    /**
     * 根据id查询
     * @param id 
     * @return
     */
    AccountInfo selectPwd(int id);
    /**
     * 修改密码
     * @param account
     * @return
     */
    int updateAccount(AccountInfo account);
}
