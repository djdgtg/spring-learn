package com.qinchao.cms.mapper;

import com.qinchao.cms.entity.BaseRoles;
import com.qinchao.cms.entity.BaseRolesExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface BaseRolesMapper {
    int countByExample(BaseRolesExample example);

    int deleteByExample(BaseRolesExample example);

    int deleteByPrimaryKey(Integer roleid);

    int insert(BaseRoles record);

    int insertSelective(BaseRoles record);

    List<BaseRoles> selectByExampleWithRowbounds(BaseRolesExample example, RowBounds rowBounds);

    List<BaseRoles> selectByExample(BaseRolesExample example);

    BaseRoles selectByPrimaryKey(Integer roleid);

    int updateByExampleSelective(@Param("record") BaseRoles record, @Param("example") BaseRolesExample example);

    int updateByExample(@Param("record") BaseRoles record, @Param("example") BaseRolesExample example);

    int updateByPrimaryKeySelective(BaseRoles record);

    int updateByPrimaryKey(BaseRoles record);
}
