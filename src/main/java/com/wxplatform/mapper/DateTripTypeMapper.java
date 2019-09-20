package com.wxplatform.mapper;

import com.wxplatform.pojo.DateTripType;
import com.wxplatform.pojo.DateTripTypeExample;

import java.util.List;

public interface DateTripTypeMapper {
    int deleteByPrimaryKey(Integer datetriptypeid);

    int insert(DateTripType record);

    int insertSelective(DateTripType record);

    List<DateTripType> selectByExample(DateTripTypeExample example);

    DateTripType selectByPrimaryKey(Integer datetriptypeid);

    int updateByPrimaryKeySelective(DateTripType record);

    int updateByPrimaryKey(DateTripType record);
}