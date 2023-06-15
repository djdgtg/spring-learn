package com.qinchao.cms.controller;

import com.qinchao.cms.aspect.LogAnnotation;
import com.qinchao.cms.aspect.LogType;
import com.qinchao.cms.entity.BaseClasses;
import com.qinchao.cms.service.ClassesService;
import com.qinchao.cms.utils.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
@Controller
@RequestMapping("/classes")
public class ClassesController {

    @Autowired
    private ClassesService classesService;


    @RequestMapping("/listCustom")
    @ResponseBody
    @LogAnnotation(logtype = LogType.OPERATION_5, logdetail = "分类查询")
    public ActionResult listCustom() {
        return classesService.listCustom();
    }

    @RequestMapping("/add")
    @ResponseBody
    @LogAnnotation(logtype = LogType.OPERATION_2, logdetail = "新增分类")
    public ActionResult add(BaseClasses baseClasses) {
        if (classesService.checkUniqueness(baseClasses)) {
            ActionResult.build(400, "该分类已存在！");
        }
        return classesService.add(baseClasses);
    }

    @RequestMapping("/update")
    @ResponseBody
    @LogAnnotation(logtype = LogType.OPERATION_3, logdetail = "更新分类")
    public ActionResult update(BaseClasses baseClasses) {
        return classesService.update(baseClasses);
    }

    @RequestMapping("/del")
    @ResponseBody
    @LogAnnotation(logtype = LogType.OPERATION_4, logdetail = "删除分类")
    public ActionResult del(Integer classid) {
        return classesService.del(classid);
    }

    @RequestMapping("/treeList")
    @ResponseBody
    @LogAnnotation(logtype = LogType.OPERATION_5, logdetail = "分类查询")
    public ActionResult treeList() {
        return classesService.treeList();
    }

}
