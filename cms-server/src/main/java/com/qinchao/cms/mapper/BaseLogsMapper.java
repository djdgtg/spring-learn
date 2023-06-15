package com.qinchao.cms.mapper;

import com.qinchao.cms.entity.BaseLogs;
import com.qinchao.cms.entity.BaseLogsExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface BaseLogsMapper {
    int countByExample(BaseLogsExample example);

    int deleteByExample(BaseLogsExample example);

    int deleteByPrimaryKey(Integer logid);

    int insert(BaseLogs record);

    int insertSelective(BaseLogs record);

    List<BaseLogs> selectByExampleWithRowbounds(BaseLogsExample example, RowBounds rowBounds);

    List<BaseLogs> selectByExample(BaseLogsExample example);

    BaseLogs selectByPrimaryKey(Integer logid);

    int updateByExampleSelective(@Param("record") BaseLogs record, @Param("example") BaseLogsExample example);

    int updateByExample(@Param("record") BaseLogs record, @Param("example") BaseLogsExample example);

    int updateByPrimaryKeySelective(BaseLogs record);

    int updateByPrimaryKey(BaseLogs record);
}
