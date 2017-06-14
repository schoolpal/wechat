package com.github.db.inf;

import com.github.db.model.TMarketTracking;

public interface TMarketTrackingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TMarketTracking record);

    int insertSelective(TMarketTracking record);

    TMarketTracking selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TMarketTracking record);

    int updateByPrimaryKey(TMarketTracking record);
}