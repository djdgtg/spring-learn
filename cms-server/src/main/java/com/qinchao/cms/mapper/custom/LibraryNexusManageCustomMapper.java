package com.qinchao.cms.mapper.custom;


import com.qinchao.cms.entity.DbLibrarynexus;

import java.util.List;


/**

 *@description

 *@author qinc

 *@date 2018/12/11

 */
public interface LibraryNexusManageCustomMapper {
	/**
	 * 根据资源库查询关系
	 * @param databaseId
	 * @return
	 */
	List<DbLibrarynexus> selectByDbId(String databaseId);
    /**
     * 批量删除资源库关系
     * @param dbids
     * @return
     */
    int deleteBatch(List<String> dbids);
}
