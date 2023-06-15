package com.qinchao.cms.mapper;

import com.qinchao.cms.entity.BaseMenus;
import com.qinchao.cms.entity.BaseMenusExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface BaseMenusMapper {
    int countByExample(BaseMenusExample example);

    int deleteByExample(BaseMenusExample example);

    int deleteByPrimaryKey(Integer menuid);

    int insert(BaseMenus record);

    int insertSelective(BaseMenus record);

    List<BaseMenus> selectByExampleWithRowbounds(BaseMenusExample example, RowBounds rowBounds);

    List<BaseMenus> selectByExample(BaseMenusExample example);

    BaseMenus selectByPrimaryKey(Integer menuid);

    int updateByExampleSelective(@Param("record") BaseMenus record, @Param("example") BaseMenusExample example);

    int updateByExample(@Param("record") BaseMenus record, @Param("example") BaseMenusExample example);

    int updateByPrimaryKeySelective(BaseMenus record);

    int updateByPrimaryKey(BaseMenus record);
}
