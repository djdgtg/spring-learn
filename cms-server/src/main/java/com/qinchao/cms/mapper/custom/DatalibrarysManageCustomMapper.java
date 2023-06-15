package com.qinchao.cms.mapper.custom;

import com.qinchao.cms.entity.custom.DataLibrarysManageSearchBean;
import com.qinchao.cms.entity.custom.DatalibrarysCustomBean;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;
import java.util.List;


/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
public interface DatalibrarysManageCustomMapper {

    List<DatalibrarysCustomBean> selectByExample(DataLibrarysManageSearchBean dataLibrarysManageSearchBean);

    int countByExample(DataLibrarysManageSearchBean dataLibrarysManageSearchBean);

    int checkUniqueness(DatalibrarysCustomBean dbDataLibrarys);

    int deleteBatch(List<String> dbids);

    int insertSelective(DatalibrarysCustomBean record);

    int updateByPrimaryKeySelective(DatalibrarysCustomBean record);

    int createNewTable(@Param("sql") String sql);

    int alterTable(@Param("sql") String sql);

    int dropTable(@Param("tableName") String tableName);

    List<String> showColumns(String tableName);

    int getResCount(@Param("sql") String sql);

    List<LinkedHashMap<String, Object>> getResList(@Param("sql") String sql);

    List<DatalibrarysCustomBean> selectByUserId(String userId);

    int editRes(@Param("sql") String sql);

    int checkunique(@Param("sql") String sql);
}
