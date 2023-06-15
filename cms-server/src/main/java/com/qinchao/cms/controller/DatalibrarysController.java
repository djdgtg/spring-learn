package com.qinchao.cms.controller;

import com.qinchao.cms.aspect.LogAnnotation;
import com.qinchao.cms.aspect.LogType;
import com.qinchao.cms.entity.custom.DataLibrarysManageSearchBean;
import com.qinchao.cms.entity.custom.DatalibrarysCustomBean;
import com.qinchao.cms.entity.custom.QueryList;
import com.qinchao.cms.service.DatalibrarysService;
import com.qinchao.cms.utils.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
@Controller
@RequestMapping("/datalibrarys")
public class DatalibrarysController {

    @Autowired
    private DatalibrarysService datalibrarysService;

    @RequestMapping("/listCustom")
    @ResponseBody
    @LogAnnotation(logtype = LogType.OPERATION_5, logdetail = "资源库查看")
    public ActionResult listCustom(DataLibrarysManageSearchBean searchBean) {
        return datalibrarysService.listCustom(searchBean);
    }

    @RequestMapping("/list")
    @ResponseBody
    @LogAnnotation(logtype = LogType.OPERATION_5, logdetail = "资源库查看")
    public ActionResult list(String mouldId) {
        return datalibrarysService.list(mouldId);
    }

    @RequestMapping("/add")
    @ResponseBody
    @LogAnnotation(logtype = LogType.OPERATION_2, logdetail = "新增资源库")
    public ActionResult add(DatalibrarysCustomBean customBean) {
        if (datalibrarysService.checkUniqueness(customBean)) {
            return ActionResult.build(400, "该资源库已存在！");
        }
        return datalibrarysService.add(customBean);
    }

    @RequestMapping("/update")
    @ResponseBody
    @LogAnnotation(logtype = LogType.OPERATION_3, logdetail = "更新资源库")
    public ActionResult update(DatalibrarysCustomBean customBean) {
        if (datalibrarysService.checkUniqueness(customBean)) {
            return ActionResult.build(400, "该资源库已存在！");
        }
        return datalibrarysService.update(customBean);
    }

    @RequestMapping("/updateStatus")
    @ResponseBody
    @LogAnnotation(logtype = LogType.OPERATION_2, logdetail = "更新资源库状态")
    public ActionResult updateStatus(String databaseid, String status) {
        return datalibrarysService.updateStatus(databaseid, status);
    }

    @RequestMapping("/getSelfDataList")
    @ResponseBody
    public ActionResult getSelfDataList(DataLibrarysManageSearchBean searchBean, QueryList queryList) {
        return datalibrarysService.getSelfDataList(searchBean, queryList.getQueryList());
    }

    @RequestMapping("/updateEditableField")
    @ResponseBody
    public ActionResult updateEditableField(Integer seqid,
                                            String field, String value, String databasename, String mouldId, HttpServletRequest request) {
        return datalibrarysService.updateEditableField(seqid, field, value, databasename, mouldId, request);
    }

    @RequestMapping("/getSelfDbInfo")
    @ResponseBody
    public ActionResult getSelfDbInfo(Integer seqId, String databaseName) {
        return datalibrarysService.getSelfDbInfo(seqId, databaseName);
    }

    @RequestMapping("/addRes")
    @ResponseBody
    public ActionResult addRes(DataLibrarysManageSearchBean searchBean, QueryList queryList, HttpServletRequest request) throws Exception {
        return datalibrarysService.addRes(searchBean, queryList, request);
    }

    @RequestMapping("/updateRes")
    @ResponseBody
    public ActionResult updateRes(DataLibrarysManageSearchBean searchBean, QueryList queryList, HttpServletRequest request) throws Exception {
        return datalibrarysService.updateRes(searchBean, queryList, request);
    }


    @RequestMapping("/delResBatch")
    @ResponseBody
    public ActionResult delResBatch(DataLibrarysManageSearchBean searchBean, HttpServletRequest request) {
        return datalibrarysService.delResBatch(searchBean, request);
    }

    @RequestMapping("/delBatch")
    @ResponseBody
    @LogAnnotation(logtype = LogType.OPERATION_4, logdetail = "删除资源库")
    public ActionResult delBatch(String databaseIds) {
        return datalibrarysService.delBatch(databaseIds);
    }

}
