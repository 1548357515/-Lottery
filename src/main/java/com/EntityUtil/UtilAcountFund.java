package com.EntityUtil;

import java.util.Date;

public class UtilAcountFund {
    private Integer id;

    private Integer accountid;

    private Long balance;

    private Long withdrawlimit;

    private String createtime;

    private String updatetime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAccountid() {
		return accountid;
	}

	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public Long getWithdrawlimit() {
		return withdrawlimit;
	}

	public void setWithdrawlimit(Long withdrawlimit) {
		this.withdrawlimit = withdrawlimit;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

   
}