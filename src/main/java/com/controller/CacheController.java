package com.controller;

import com.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhuzhengping on 2017/3/15.
 */
@RestController
@RequestMapping(value = "/concurrenmapcache/cache")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String getByCache(){
        long startTme = System.currentTimeMillis();
        long timeTme = this.cacheService.getByCache();
        long endTme = System.currentTimeMillis();
        System.out.println("耗时:" + (endTme - startTme));
        return timeTme + "";
    }
}
