package com.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;


/**
 * Created by zhuzhengping on 2017/3/15.
 */

@Service
public class CacheService {

    @Cacheable(value = "concurrenmapcache")
    public long getByCache(){
        try {
            Thread.sleep(3 *1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Timestamp(System.currentTimeMillis()).getTime();
    }

    @CacheEvict(value = "concurrenmapcache")
    public void delete(){
        System.out.println("删除缓存");
    }

    @CachePut(value = "concurrenmapcache")
    public long save(){
        long timeStamp = new Timestamp(System.currentTimeMillis()).getTime();
        System.out.println("进行缓存" + timeStamp);
        return timeStamp;
    }

}
