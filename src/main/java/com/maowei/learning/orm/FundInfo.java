package com.maowei.learning.orm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;


public class FundInfo implements Serializable {
    private Integer id;
    private String fundCode;
    private Date date;
    private BigDecimal netValue;
    private BigDecimal totalNetValue;
    private BigDecimal dayInc;
    private BigDecimal bouns;
    private String fundName;

    public FundInfo(Integer id, String fundCode, Date date, BigDecimal netValue, BigDecimal totalNetValue, BigDecimal dayInc, BigDecimal bouns, String fundName) {
        this.id = id;
        this.fundCode = fundCode;
        this.date = date;
        this.netValue = netValue;
        this.totalNetValue = totalNetValue;
        this.dayInc = dayInc;
        this.bouns = bouns;
        this.fundName = fundName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getNetValue() {
        return netValue;
    }

    public void setNetValue(BigDecimal netValue) {
        this.netValue = netValue;
    }

    public BigDecimal getTotalNetValue() {
        return totalNetValue;
    }

    public void setTotalNetValue(BigDecimal totalNetValue) {
        this.totalNetValue = totalNetValue;
    }

    public BigDecimal getDayInc() {
        return dayInc;
    }

    public void setDayInc(BigDecimal dayInc) {
        this.dayInc = dayInc;
    }

    public BigDecimal getBouns() {
        return bouns;
    }

    public void setBouns(BigDecimal bouns) {
        this.bouns = bouns;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }
}
