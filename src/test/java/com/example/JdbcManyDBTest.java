package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by zhuzhengping on 2017/3/8.
 * 多数据源配置测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JdbcManyDBTest {

    @Resource(name = "oneJdbcTemplate")
    protected JdbcTemplate jdbcTemplate1;

    @Resource(name = "twoJdbcTemplate")
    protected JdbcTemplate jdbcTemplate2;

    @Test
    public void test(){
        jdbcTemplate1.update("INSERT INTO tp_author(id,real_name,nick_name) VALUES (?,?,?)",3,"tt","tom");

        jdbcTemplate1.update("INSERT INTO dbgirl.girl(id,age,cupsize) VALUES (?,?,?)",10,"88","tom");

    }
}
