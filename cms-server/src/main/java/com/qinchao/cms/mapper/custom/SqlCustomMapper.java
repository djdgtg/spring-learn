package com.qinchao.cms.mapper.custom;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
public interface SqlCustomMapper {

    int createNewTable(@Param("sql") String sql);

    int alterTable(@Param("sql") String sql);

    int dropTable(@Param("tableName") String tableName);

    List<String> showColumns(String tableName);

    int getResCount(@Param("sql") String sql);

    List<Map<String, Object>> getResList(@Param("sql") String sql);

}
