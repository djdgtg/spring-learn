package com.qinchao.cms.mapper;

import com.qinchao.cms.entity.DbDatalibrarys;
import com.qinchao.cms.entity.DbDatalibrarysExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface DbDatalibrarysMapper {
    int countByExample(DbDatalibrarysExample example);

    int deleteByExample(DbDatalibrarysExample example);

    int deleteByPrimaryKey(Integer databaseid);

    int insert(DbDatalibrarys record);

    int insertSelective(DbDatalibrarys record);

    List<DbDatalibrarys> selectByExampleWithRowbounds(DbDatalibrarysExample example, RowBounds rowBounds);

    List<DbDatalibrarys> selectByExample(DbDatalibrarysExample example);

    DbDatalibrarys selectByPrimaryKey(Integer databaseid);

    int updateByExampleSelective(@Param("record") DbDatalibrarys record, @Param("example") DbDatalibrarysExample example);

    int updateByExample(@Param("record") DbDatalibrarys record, @Param("example") DbDatalibrarysExample example);

    int updateByPrimaryKeySelective(DbDatalibrarys record);

    int updateByPrimaryKey(DbDatalibrarys record);
}
