package com.wxplatform.mapper;

import com.wxplatform.pojo.DepartPositionInfo;
import com.wxplatform.pojo.DepartPositionInfoExample;

import java.util.List;

public interface DepartPositionInfoMapper {
    int deleteByPrimaryKey(Integer positionid);

    int insert(DepartPositionInfo record);

    int insertSelective(DepartPositionInfo record);

    List<DepartPositionInfo> selectByExample(DepartPositionInfoExample example);

    DepartPositionInfo selectByPrimaryKey(Integer positionid);

    int updateByPrimaryKeySelective(DepartPositionInfo record);

    int updateByPrimaryKey(DepartPositionInfo record);
}