package com.qinchao.cms.mapper;

import com.qinchao.cms.entity.BaseManagers;
import com.qinchao.cms.entity.BaseManagersExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface BaseManagersMapper {
    int countByExample(BaseManagersExample example);

    int deleteByExample(BaseManagersExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(BaseManagers record);

    int insertSelective(BaseManagers record);

    List<BaseManagers> selectByExampleWithRowbounds(BaseManagersExample example, RowBounds rowBounds);

    List<BaseManagers> selectByExample(BaseManagersExample example);

    BaseManagers selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") BaseManagers record, @Param("example") BaseManagersExample example);

    int updateByExample(@Param("record") BaseManagers record, @Param("example") BaseManagersExample example);

    int updateByPrimaryKeySelective(BaseManagers record);

    int updateByPrimaryKey(BaseManagers record);
}
