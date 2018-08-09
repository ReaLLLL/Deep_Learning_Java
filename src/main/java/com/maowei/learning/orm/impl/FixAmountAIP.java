package com.maowei.learning.orm.impl;

import com.maowei.learning.orm.Config;
import com.maowei.learning.orm.FundAIPCalculateInf;
import com.maowei.learning.orm.FundAIPResult;
import com.maowei.learning.orm.FundInfo;

import java.text.SimpleDateFormat;

public class FixAmountAIP implements FundAIPCalculateInf {
    public FundAIPResult doCalculate(FundAIPResult old, FundInfo fundInfo) {
        FundAIPResult newAIP = new FundAIPResult();
        newAIP.setDate(new SimpleDateFormat("yyyy/MM/dd").format(fundInfo.getDate()));
        newAIP.setCurrNetValue(fundInfo.getNetValue().doubleValue());

        //目标市值

        //当期赎回金额

        //当期投入金额
        newAIP.setCurrInput(Config.perInput);

        //累计赎回金额

        //当期买入份额
        double currShare = Config.perInput/fundInfo.getNetValue().doubleValue();
        newAIP.setCurrShare(currShare);

        //总投入
        double totalInput = Config.perInput + old.getTotalInput();
        newAIP.setTotalInput(totalInput);

        //总份额
        double totalShare = currShare + old.getTotalShare();
        newAIP.setTotalShare(totalShare);

        //总市值
        double totalValue = fundInfo.getNetValue().doubleValue() * totalShare;
        newAIP.setTotalValue(totalValue);

        //收益率
        newAIP.setBenefitRate(totalValue/totalInput-1.0);

        return newAIP;
    }
}
