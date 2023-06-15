package com.qinchao.cms.controller;

import com.qinchao.cms.service.LibrarynexusService;
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
@RequestMapping("/librarynexus")
public class LibrarynexusController {

    @Autowired
    private LibrarynexusService librarynexusService;

    @RequestMapping("/listTabdata")
    @ResponseBody
    public ActionResult listTabdata(String mdbname, String mdbfield) {
        return librarynexusService.listTabdata(mdbname, mdbfield);
    }

    @RequestMapping("/listCustom")
    @ResponseBody
    public ActionResult listCustom(Integer mouldId, Integer databaseId) {
        return librarynexusService.listCustom(mouldId, databaseId);
    }

}
