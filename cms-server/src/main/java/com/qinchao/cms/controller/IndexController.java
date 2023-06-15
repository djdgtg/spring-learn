package com.qinchao.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
@Controller
public class IndexController {

    @GetMapping("{page}")
    public String page(@PathVariable String page) {
        return page;
    }

    @GetMapping("db/{page}")
    public String dbPage(@PathVariable String page) {
        return "db/" + page;
    }

}
