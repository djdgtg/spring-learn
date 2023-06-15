package com.qinchao.boot.integration.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Description
 *
 * @author djdgt
 * @since 2023/3/28 10:56
 */
@Controller
@Slf4j
public class IndexController {

    @GetMapping("{page}.html")
    public String page(@PathVariable String page) {
        return page;
    }

    @PostMapping("loginSuccess")
    public String loginSuccess() {
        return "redirect:index.html";
    }

}
