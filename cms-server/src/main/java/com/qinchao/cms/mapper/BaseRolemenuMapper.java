package com.qinchao.cms.mapper;

import com.qinchao.cms.entity.BaseRolemenu;
import com.qinchao.cms.entity.BaseRolemenuExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface BaseRolemenuMapper {
    int countByExample(BaseRolemenuExample example);

    int deleteByExample(BaseRolemenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseRolemenu record);

    int insertSelective(BaseRolemenu record);

    List<BaseRolemenu> selectByExampleWithRowbounds(BaseRolemenuExample example, RowBounds rowBounds);

    List<BaseRolemenu> selectByExample(BaseRolemenuExample example);

    BaseRolemenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseRolemenu record, @Param("example") BaseRolemenuExample example);

    int updateByExample(@Param("record") BaseRolemenu record, @Param("example") BaseRolemenuExample example);

    int updateByPrimaryKeySelective(BaseRolemenu record);

    int updateByPrimaryKey(BaseRolemenu record);
}
