package com.qinchao.cms.mapper;

import com.qinchao.cms.entity.BaseMgrole;
import com.qinchao.cms.entity.BaseMgroleExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface BaseMgroleMapper {
    int countByExample(BaseMgroleExample example);

    int deleteByExample(BaseMgroleExample example);

    int insert(BaseMgrole record);

    int insertSelective(BaseMgrole record);

    List<BaseMgrole> selectByExampleWithRowbounds(BaseMgroleExample example, RowBounds rowBounds);

    List<BaseMgrole> selectByExample(BaseMgroleExample example);

    int updateByExampleSelective(@Param("record") BaseMgrole record, @Param("example") BaseMgroleExample example);

    int updateByExample(@Param("record") BaseMgrole record, @Param("example") BaseMgroleExample example);
}
