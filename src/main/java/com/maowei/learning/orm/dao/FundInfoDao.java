package com.maowei.learning.orm.dao;

import com.maowei.learning.orm.FundInfo;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FundInfoDao {
    List<FundInfo> getFundInfoByFundCode(@Param("fundCode") String fundCode);
}
