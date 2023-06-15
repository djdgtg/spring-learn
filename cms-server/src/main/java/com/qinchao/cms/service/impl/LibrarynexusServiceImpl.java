package com.qinchao.cms.service.impl;

import com.qinchao.cms.entity.DbLibrarynexus;
import com.qinchao.cms.entity.DbLibrarynexusExample;
import com.qinchao.cms.entity.DbMetadatas;
import com.qinchao.cms.entity.DbMetadatasExample;
import com.qinchao.cms.entity.custom.Constants;
import com.qinchao.cms.mapper.DbLibrarynexusMapper;
import com.qinchao.cms.mapper.DbMetadatasMapper;
import com.qinchao.cms.mapper.custom.DatalibrarysManageCustomMapper;
import com.qinchao.cms.mapper.custom.LibraryNexusManageCustomMapper;
import com.qinchao.cms.service.LibrarynexusService;
import com.qinchao.cms.utils.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
@Service
public class LibrarynexusServiceImpl implements LibrarynexusService {

    @Autowired
    private DbMetadatasMapper metadatasMapper;

    @Autowired
    private LibraryNexusManageCustomMapper libraryNexusCustomMapper;

    @Autowired
    private DbLibrarynexusMapper librarynexusMapper;

    @Autowired
    private DatalibrarysManageCustomMapper datalibrarysCustomMapper;

    public ActionResult listTabdata(String mdbname, String mdbfield) {
        DbLibrarynexusExample example = new DbLibrarynexusExample();
        example.createCriteria().andMdbfieldEqualTo(mdbfield).andMdbnameEqualTo(mdbname);
        List<DbLibrarynexus> nexus = librarynexusMapper.selectByExample(example);
        List<LinkedHashMap<String, Object>> nexusSqlList = null;
        if (nexus != null) {
            nexusSqlList = datalibrarysCustomMapper.getResList(nexus.get(0).getSdbsql());

        }
        return ActionResult.ok(nexusSqlList);
    }

    public ActionResult listCustom(Integer mouldId, Integer databaseId) {
        List<DbLibrarynexus> nexusList = null;
        if (databaseId != null) {
            nexusList = libraryNexusCustomMapper.selectByDbId(databaseId.toString());
        }
        DbMetadatasExample example = new DbMetadatasExample();
        example.createCriteria().andMouldidEqualTo(mouldId);
        List<DbMetadatas> metadatas = metadatasMapper.selectByExample(example);
        List<DbMetadatas> metaDbList = new ArrayList<>();

        for (DbMetadatas dbMetadatas : metadatas) {
            if (dbMetadatas.getColumnsource() != null && dbMetadatas.getColumnsource() == Constants.COlUMNSOURCE_DB) {
                metaDbList.add(dbMetadatas);
            }
        }
        List<DbLibrarynexus> nexusMeList = new ArrayList<>();
        DbLibrarynexus nexus = null;
        for (DbMetadatas dbMetadatas : metaDbList) {
            String columnName = dbMetadatas.getColumnname();
            if (nexusList != null) {
                for (DbLibrarynexus dbLibraryNexus : nexusList) {
                    if (dbLibraryNexus.getMdbfield().equals(columnName)) {
                        nexus = dbLibraryNexus;
                    }
                }
            } else {
                nexus = null;
            }
            if (nexus == null) {
                nexus = new DbLibrarynexus();
                nexus.setMdbfield(columnName);
            }

            nexusMeList.add(nexus);
        }
        return ActionResult.ok(nexusMeList);
    }

}
