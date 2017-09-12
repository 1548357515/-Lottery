package com.Pojo;

import java.util.Date;

public class PlanPk10 {
    private Long id;

    private Long planid;

    private Integer state;

    private Long expect;

    private String plannumber;

    private Long amount;

    private Long profit;

    private Date opentime;

    private Date createtime;

    private Date updatetime;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlanid() {
        return planid;
    }

    public void setPlanid(Long planid) {
        this.planid = planid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getExpect() {
        return expect;
    }

    public void setExpect(Long expect) {
        this.expect = expect;
    }

    public String getPlannumber() {
        return plannumber;
    }

    public void setPlannumber(String plannumber) {
        this.plannumber = plannumber == null ? null : plannumber.trim();
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getProfit() {
        return profit;
    }

    public void setProfit(Long profit) {
        this.profit = profit;
    }

    public Date getOpentime() {
        return opentime;
    }

    public void setOpentime(Date opentime) {
        this.opentime = opentime;
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