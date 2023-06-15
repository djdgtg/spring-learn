package com.qinchao.common.cache.caffeine;

import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description
 *
 * @author qinchao
 * @since 2023/3/12 10:45
 */
@Configuration
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        return new CaffeineCacheManager();
    }

}
