package com.maowei.learning.orm;

import java.io.Serializable;

public class FundAIPResult implements Serializable{
    private String date;
    private double currNetValue;
    private double targetValue = 0;
    private double currSold = 0;
    private double currInput;
    private double totalSold = 0;
    private double currShare;
    private double totalInput = 0;;
    private double totalShare = 0;;
    private double totalValue = 0;;
    private double benefitRate = 0;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getCurrNetValue() {
        return currNetValue;
    }

    public void setCurrNetValue(double currNetValue) {
        this.currNetValue = currNetValue;
    }

    public double getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(double targetValue) {
        this.targetValue = targetValue;
    }

    public double getCurrSold() {
        return currSold;
    }

    public void setCurrSold(double currSold) {
        this.currSold = currSold;
    }

    public double getCurrInput() {
        return currInput;
    }

    public void setCurrInput(double currInput) {
        this.currInput = currInput;
    }

    public double getTotalSold() {
        return totalSold;
    }

    public void setTotalSold(double totalSold) {
        this.totalSold = totalSold;
    }

    public double getCurrShare() {
        return currShare;
    }

    public void setCurrShare(double currShare) {
        this.currShare = currShare;
    }

    public double getTotalInput() {
        return totalInput;
    }

    public void setTotalInput(double totalInput) {
        this.totalInput = totalInput;
    }

    public double getTotalShare() {
        return totalShare;
    }

    public void setTotalShare(double totalShare) {
        this.totalShare = totalShare;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public double getBenefitRate() {
        return benefitRate;
    }

    public void setBenefitRate(double benefitRate) {
        this.benefitRate = benefitRate;
    }

    public void refresh(FundInfo fundInfo){
        this.totalShare *=fundInfo.getBouns().doubleValue();
    }
}
