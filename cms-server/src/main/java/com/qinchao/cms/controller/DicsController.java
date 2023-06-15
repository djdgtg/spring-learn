package com.qinchao.cms.controller;

import com.qinchao.cms.aspect.LogAnnotation;
import com.qinchao.cms.aspect.LogType;
import com.qinchao.cms.entity.BaseDics;
import com.qinchao.cms.service.DicsService;
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
@RequestMapping("/dics")
public class DicsController {

    @Autowired
    private DicsService dicsService;

    @RequestMapping("/list")
    @ResponseBody
    public ActionResult list(BaseDics baseDics) {
        return dicsService.list(baseDics);
    }

    @RequestMapping("/add")
    @ResponseBody
    @LogAnnotation(logtype = LogType.OPERATION_2, logdetail = "新增字典")
    public ActionResult add(BaseDics baseDics) {
        if (dicsService.checkUniquenessByTypeOrName(baseDics)) {
            return ActionResult.build(400, "该字典已存在！");
        }
        return dicsService.add(baseDics);
    }

    @RequestMapping("/update")
    @ResponseBody
    @LogAnnotation(logtype = LogType.OPERATION_3, logdetail = "更新字典")
    public ActionResult update(BaseDics baseDics) {
        if (dicsService.checkUniqueness(baseDics)) {
            return ActionResult.build(400, "该字典已存在！");
        }
        return dicsService.update(baseDics);
    }

    @RequestMapping("/del")
    @ResponseBody
    @LogAnnotation(logtype = LogType.OPERATION_4, logdetail = "删除字典类型")
    public ActionResult del(BaseDics baseDics) {
        return dicsService.del(baseDics);
    }

    @RequestMapping("/delBatch")
    @ResponseBody
    @LogAnnotation(logtype = LogType.OPERATION_4, logdetail = "删除字典")
    public ActionResult delBatch(String dicIds) {
        return dicsService.delBatch(dicIds);
    }

}
