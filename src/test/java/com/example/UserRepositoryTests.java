package com.example;

import com.DemoApplication;
import com.compont.User;
import com.dao.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by zhuzhengping on 2017/2/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;
    @Test
    public void test(){
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
        String formattedDate = dateFormat.format(date);
        userRepository.save(new User("aa1","123","aa@163.com","aa",formattedDate));
        userRepository.save(new User("bb2","321","bb@163.com","bb",formattedDate));
        userRepository.save(new User("cc3","231","cc@163.com","cc",formattedDate));

        Assert.assertEquals(3,userRepository.findAll().size());
        Assert.assertEquals("bb",userRepository.findByUserNameOrEmail("bb","bb@163.com").getNickName());
        userRepository.delete(userRepository.findByUserName("aa1"));

    }


}
