package com.qinchao.cms.mapper;

import com.qinchao.cms.entity.BaseDics;
import com.qinchao.cms.entity.BaseDicsExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface BaseDicsMapper {
    int countByExample(BaseDicsExample example);

    int deleteByExample(BaseDicsExample example);

    int deleteByPrimaryKey(Integer dicid);

    int insert(BaseDics record);

    int insertSelective(BaseDics record);

    List<BaseDics> selectByExampleWithRowbounds(BaseDicsExample example, RowBounds rowBounds);

    List<BaseDics> selectByExample(BaseDicsExample example);

    BaseDics selectByPrimaryKey(Integer dicid);

    int updateByExampleSelective(@Param("record") BaseDics record, @Param("example") BaseDicsExample example);

    int updateByExample(@Param("record") BaseDics record, @Param("example") BaseDicsExample example);

    int updateByPrimaryKeySelective(BaseDics record);

    int updateByPrimaryKey(BaseDics record);
}
