package com.qinchao.cms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/**
 * description
 *
 * @author qinc
 * @since 2018/12/11
 */
@SpringBootApplication
@MapperScan("com.qinchao.cms.mapper")
public class CmsApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CmsApplication.class);
    }
}
