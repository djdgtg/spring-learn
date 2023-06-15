package com.qinchao.gateway.controller;

import com.qinchao.gateway.pojo.User;
import com.qinchao.gateway.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Controller
@RequestMapping("/page")
public class PageController {


    @GetMapping("{page}")
    public String page(@PathVariable String page) {
        return page;
    }

}
