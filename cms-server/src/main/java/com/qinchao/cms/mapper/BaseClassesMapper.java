package com.qinchao.cms.mapper;

import com.qinchao.cms.entity.BaseClasses;
import com.qinchao.cms.entity.BaseClassesExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface BaseClassesMapper {
    int countByExample(BaseClassesExample example);

    int deleteByExample(BaseClassesExample example);

    int deleteByPrimaryKey(Integer classid);

    int insert(BaseClasses record);

    int insertSelective(BaseClasses record);

    List<BaseClasses> selectByExampleWithRowbounds(BaseClassesExample example, RowBounds rowBounds);

    List<BaseClasses> selectByExample(BaseClassesExample example);

    BaseClasses selectByPrimaryKey(Integer classid);

    int updateByExampleSelective(@Param("record") BaseClasses record, @Param("example") BaseClassesExample example);

    int updateByExample(@Param("record") BaseClasses record, @Param("example") BaseClassesExample example);

    int updateByPrimaryKeySelective(BaseClasses record);

    int updateByPrimaryKey(BaseClasses record);
}
