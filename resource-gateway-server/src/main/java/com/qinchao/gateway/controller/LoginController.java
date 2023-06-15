/*
 * Copyright 2020-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qinchao.gateway.controller;

import lombok.AllArgsConstructor;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author Joe Grandja
 * @since 0.0.1
 */
@RestController
@RequestMapping("login")
@AllArgsConstructor
public class LoginController {

    private final WebClient webClient;

    @GetMapping(value = "oauth2/code")
    public Mono<String> login(String code) {
        String url = "http://localhost:9000/oauth2/token?grant_type=authorization_code" +
                "&scope=learn.read&redirect_uri=http://127.0.0.1:7000/login/oauth2/code&code=" + code;
        String authorization = "Basic " + Base64Utils.encodeToString("learn-resource-gateway:111111".getBytes());  //username  password 自行修改  中间":"不可少
        return webClient.post().uri(url).header("Authorization", authorization).retrieve().bodyToMono(String.class);
    }

}
