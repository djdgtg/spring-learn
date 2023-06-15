package com.qinchao.boot.integration.controller;

import com.qinchao.boot.integration.config.WebSocketServer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Description
 *
 * @author djdgt
 * @since 2023/3/28 10:56
 */
@RestController
@AllArgsConstructor
public class ApiController {


    @GetMapping("api/{api}")
    public String api(@PathVariable String api) {
        return api;
    }

    //推送数据接口
    @GetMapping("/wsSend/{message}")
    public String pushToWeb(@PathVariable String message, String toUserId) throws IOException {
        WebSocketServer.sendInfo(message, toUserId);
        return message;
    }
}
