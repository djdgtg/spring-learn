package com.qinchao.cms.controller;

import com.qinchao.cms.entity.custom.OptionsSearchBean;
import com.qinchao.cms.service.OptionsService;
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
@RequestMapping("/options")
public class OptionsController {

    @Autowired
    private OptionsService optionsService;

    @RequestMapping("/getMenuTreeOptionsByRole")
    @ResponseBody
    public ActionResult getMenuTreeOptionsByRole(OptionsSearchBean optionsSearchBean) {
        return optionsService.getMenuTreeOptionsByRole(optionsSearchBean);
    }

    @RequestMapping("/getClassTreeOptionsByParent")
    @ResponseBody
    public ActionResult getClassTreeOptionsByParent(OptionsSearchBean optionsSearchBean) {
        return optionsService.getClassTreeOptionsByParent(optionsSearchBean);
    }

}

