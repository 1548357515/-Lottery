package com.EntityUtil;

import java.util.Date;

public class UtilPlanPk10 {
    private Long id;

    private Long planid;

    private Integer state;

    private Long expect;

    private String plannumber;

    private Long amount;

    private Long profit;

    private String opentime;

    private String createtime;

    private String updatetime;
    
    private String opennumber; 
    
    
    public String getOpennumber() {
		return opennumber;
	}

	public void setOpennumber(String opennumber) {
		this.opennumber = opennumber;
	}

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

	public String getOpentime() {
		return opentime;
	}

	public void setOpentime(String opentime) {
		this.opentime = opentime;
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