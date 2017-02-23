package com.example;

import com.DemoApplication;
import com.compont.User;
import com.dao.CityRepository;
import com.dao.HotelSummary;
import com.dao.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by zhuzhengping on 2017/2/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class BaseQueryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CityRepository cityRepository;

    @Test
    public void test(){
        User user = new User();
        userRepository.findAll();
        userRepository.findOne((long) 1);
        userRepository.save(user);
        userRepository.count();
        userRepository.delete((long) 1);
    }

    @Test
    public void testPageQuery(){
        int page = 0,size = 10;
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(page,size,sort);
        Page<User> a = userRepository.findAll(pageable);
        Page<User> b = userRepository.findByUserName("bb2",pageable);
        System.out.println(a.getTotalPages());
        System.out.println(a.getTotalElements());
        List<User> aa = a.getContent();
        for (User u : aa){
            System.out.println(u.getNickName());
        }

    }
    @Test
    public void testQuery2(){
//        Long l = userRepository.deleteById((long) 14);
//        userRepository.delete((long) 14);
        Long ll = userRepository.countByUserName("dd4");
        List<User> list = userRepository.findByEmailLike("%com%");
//        System.out.println(l);
        System.out.println(ll);
        for (User u : list){
            System.out.println(u.getUserName());
        }
    }

    @Test
    public void testQUERY3(){
        int page = 0,size = 10;
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(page,size,sort);
        Page<User> a = userRepository.findUser("%com%",pageable);
        List<User> aa = a.getContent();
        for (User u : aa){
            System.out.println(u.getUserName());
        }
        userRepository.modifyByIdAndUserId("qq3",(long) 15);
    }

    @Test
    public void testHotel(){
//        cityRepository.save(new City("shanghai","021"));
        Page<HotelSummary> hotels = cityRepository.findByCity((long) 1,new PageRequest(0,10, Sort.Direction.ASC,"hotelName"));
        for (HotelSummary hotel : hotels){
            System.out.println(hotel.getName());
        }
    }
}
