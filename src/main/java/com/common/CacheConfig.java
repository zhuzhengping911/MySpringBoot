package com.common;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhuzhengping on 2017/3/15.
 * 使用@EnableCaching开启缓存支持
 * 默认缓存的配置
 */
@Configuration
@EnableCaching
public class CacheConfig {
}
