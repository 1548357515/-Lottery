package com.Pojo;

import java.util.Date;

public class AcountFund {
    private Integer id;

    private Integer accountid;

    private Long balance;

    private Long withdrawlimit;

    private Date createtime;

    private Date updatetime;

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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}