package com.controller;

import com.compont.User;
import com.compont.ZzpProperties;
import com.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Created by zhuzhengping on 2017/2/1.
 * 第一个helloworld类
 */
@SpringBootApplication
@RestController //注解-该类返回的都是json格式
public class HelloWordController {

    @Autowired
    private ZzpProperties zzpProperties;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String HelloWorld(){
        return "HelloWorld,SpringBoot!!!";
    }


    @RequestMapping(value = "/zzp",method = RequestMethod.GET)
    public Page<User> Zzp(){

        int page = 0,size = 10;
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(page,size,sort);
        Page<User> a = userRepository.findAll(pageable);
        Page<User> b = userRepository.findByUserName("bb2",pageable);
        return  b;
//        Date date = new Date();
//        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
//        String formattedDate = dateFormat.format(date);
//        userRepository.save(new User("aa1","123","aa@163.com","aa",formattedDate));
//        userRepository.save(new User("bb2","321","bb@163.com","bb",formattedDate));
//        userRepository.save(new User("cc3","231","cc@163.com","cc",formattedDate));
//
////        Assert(9,userRepository.findAll().size());
////        Assert.assertEquals("bb",userRepository.findByUserNameOrEmail("bb","cc@163.com").getNickName());
//        userRepository.delete(userRepository.findByUserName("aa1"));
//        String a = zzpProperties.getDescription() + zzpProperties.getTitle();
//        return userRepository.findAll();
    }

    @RequestMapping("/getuser")
    @Cacheable(value = "user-key",keyGenerator = "keyGenerator")
    public User getuser(){
        User user = userRepository.findByUserName("bb2");
        System.out.println("若下面没有出现无缓存字样并且能打印出数据表示测试成功");
        return user;
    }

    @RequestMapping("/uid")
    String uid(HttpSession session){
        UUID uid = (UUID) session.getAttribute("uid");
        if(uid == null){
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid",uid);
        return session.getId();
    }
}

