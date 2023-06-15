package com.qinchao.cms.service;

import com.qinchao.cms.entity.DbMetadatas;
import com.qinchao.cms.entity.custom.DataLibrarysManageSearchBean;
import com.qinchao.cms.utils.ActionResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
public interface PersonalService {

    ActionResult uploadFile(MultipartFile uploadFile);

    ActionResult importFile(MultipartFile file, DataLibrarysManageSearchBean searchBean, HttpServletRequest request);

    void exportModelExcel(List<DbMetadatas> list, HttpServletResponse response, HttpServletRequest request,
                          String tablecname, String type, String databaseName, String mouldId);

    ActionResult updateResByFiledBatch(DataLibrarysManageSearchBean searchBean, String fieldval, String fieldname, HttpServletRequest request);

    boolean checkunique(String columnname, String value, Integer seqid, String databasename);

    HashMap<String, Object> uploadkindeditor(MultipartFile file);

    String getfileServerUrl();

}
