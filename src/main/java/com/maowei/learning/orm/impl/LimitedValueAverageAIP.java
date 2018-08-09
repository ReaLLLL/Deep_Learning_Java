package com.maowei.learning.orm.impl;

import com.maowei.learning.orm.Config;
import com.maowei.learning.orm.FundAIPCalculateInf;
import com.maowei.learning.orm.FundAIPResult;
import com.maowei.learning.orm.FundInfo;

import java.text.SimpleDateFormat;

public class LimitedValueAverageAIP implements FundAIPCalculateInf {
    public FundAIPResult doCalculate(FundAIPResult old, FundInfo fundInfo) {
        FundAIPResult newAIP = new FundAIPResult();
        newAIP.setDate(new SimpleDateFormat("yyyy/MM/dd").format(fundInfo.getDate()));
        newAIP.setCurrNetValue(fundInfo.getNetValue().doubleValue());

        //目标市值
        double targetValue = Config.perInput + old.getTargetValue() * Config.perYieldRate;
        newAIP.setTargetValue(targetValue);

        //差异金额
        double different= targetValue - old.getTotalShare() * fundInfo.getNetValue().doubleValue();

        //当期赎回金额
        double currSold = Math.max(Math.min(Config.MAX_SOLD,0-different), 0);
        double totalSold = old.getTotalSold() + currSold;
        newAIP.setCurrSold(currSold);

        //当期投入金额
        double currInput = Math.max(Math.min(Config.MAX_INPUT, different), 0);
        double actualInput = Math.max(currInput - totalSold, 0);
        newAIP.setCurrInput(actualInput);

        //累计赎回金额
        totalSold = Math.max(totalSold - currInput, 0);
        newAIP.setTotalSold(totalSold);

        //当期买入份额
        double currShare = (different > 0 ? Math.min(Config.MAX_INPUT, different) : 0-Math.min(Config.MAX_SOLD, 0-different))/fundInfo.getNetValue().doubleValue();
        newAIP.setCurrShare(currShare);

        //总投入
        double totalInput = actualInput + old.getTotalInput();
        newAIP.setTotalInput(totalInput);

        //总份额
        double totalShare = currShare + old.getTotalShare();
        newAIP.setTotalShare(totalShare);

        //总市值
        double totalValue = fundInfo.getNetValue().doubleValue() * totalShare;
        newAIP.setTotalValue(totalValue);

        //收益率
        newAIP.setBenefitRate((totalValue+totalSold)/totalInput-1.0);

        return newAIP;
    }
}
