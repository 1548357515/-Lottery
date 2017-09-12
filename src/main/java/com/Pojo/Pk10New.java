package com.Pojo;

import java.util.Date;

public class Pk10New {
    private Long id;

    private Long expect;

    private String number;

    private Date time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExpect() {
        return expect;
    }

    public void setExpect(Long expect) {
        this.expect = expect;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}