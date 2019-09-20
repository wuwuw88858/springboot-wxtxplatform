package com.wxplatform.mapper;

import com.wxplatform.pojo.DepartmentPositionInfo;
import com.wxplatform.pojo.DepartmentPositionInfoExample;

import java.util.List;

public interface DepartmentPositionInfoMapper {
    int deleteByPrimaryKey(Integer positionid);

    int insert(DepartmentPositionInfo record);

    int insertSelective(DepartmentPositionInfo record);

    List<DepartmentPositionInfo> selectByExample(DepartmentPositionInfoExample example);

    DepartmentPositionInfo selectByPrimaryKey(Integer positionid);

    int updateByPrimaryKeySelective(DepartmentPositionInfo record);

    int updateByPrimaryKey(DepartmentPositionInfo record);
}