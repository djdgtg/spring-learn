package com.qinchao.cms.mapper;

import com.qinchao.cms.entity.DbLibrarynexus;
import com.qinchao.cms.entity.DbLibrarynexusExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface DbLibrarynexusMapper {
    int countByExample(DbLibrarynexusExample example);

    int deleteByExample(DbLibrarynexusExample example);

    int deleteByPrimaryKey(Integer nexusid);

    int insert(DbLibrarynexus record);

    int insertSelective(DbLibrarynexus record);

    List<DbLibrarynexus> selectByExampleWithRowbounds(DbLibrarynexusExample example, RowBounds rowBounds);

    List<DbLibrarynexus> selectByExample(DbLibrarynexusExample example);

    DbLibrarynexus selectByPrimaryKey(Integer nexusid);

    int updateByExampleSelective(@Param("record") DbLibrarynexus record, @Param("example") DbLibrarynexusExample example);

    int updateByExample(@Param("record") DbLibrarynexus record, @Param("example") DbLibrarynexusExample example);

    int updateByPrimaryKeySelective(DbLibrarynexus record);

    int updateByPrimaryKey(DbLibrarynexus record);
}
