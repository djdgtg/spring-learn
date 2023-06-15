package com.qinchao.cms.controller;

import com.qinchao.cms.entity.DbMoulds;
import com.qinchao.cms.service.MouldsService;
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
@RequestMapping("/moulds")
public class MouldsController {

    @Autowired
    private MouldsService mouldsService;

    @RequestMapping("/list")
    @ResponseBody
    public ActionResult list() {
        return mouldsService.list();
    }

    @RequestMapping("/add")
    @ResponseBody
    public ActionResult add(DbMoulds dbMoulds) {
        if (mouldsService.checkUniqueness(dbMoulds)) {
            return ActionResult.build(400, "该模型已存在,请输入其他模型名!");
        }
        return mouldsService.add(dbMoulds);

    }

    @RequestMapping("/update")
    @ResponseBody
    public ActionResult update(DbMoulds dbMoulds) {
        if (mouldsService.checkUniqueness(dbMoulds)) {
            return ActionResult.build(400, "该模型已存在,请输入其他模型名!");
        }
        return mouldsService.update(dbMoulds);
    }

    @RequestMapping("/delBatch")
    @ResponseBody
    public ActionResult delBatch(String mouldIds) {
        return mouldsService.delBatch(mouldIds);
    }

}
