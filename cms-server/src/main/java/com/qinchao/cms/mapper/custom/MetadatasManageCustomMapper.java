package com.qinchao.cms.mapper.custom;

import com.qinchao.cms.entity.DbMetadatas;
import com.qinchao.cms.entity.custom.MetadatasCustomBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
public interface MetadatasManageCustomMapper {

    int checkUniqueness(DbMetadatas dbMetadatas);

    int deleteBatch(List<String> metadataids);

    List<MetadatasCustomBean> selectByExample(String mouldid);

    List<DbMetadatas> selectByDbname(@Param("databaseName") String databaseName);
}
