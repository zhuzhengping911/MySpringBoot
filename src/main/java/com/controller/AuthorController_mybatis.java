package com.controller;

import com.compont.Author;
import com.service.AuthorService_mybatis;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhuzhengping on 2017/3/10.
 * 使用mybatis时，要注明扫描的包
 *
 * 
 */
@RestController
@RequestMapping(value = "/data/mybatis/author")
@MapperScan("com.dao")
public class AuthorController_mybatis {

    @Autowired
    private AuthorService_mybatis authorServiceMybatis;

    @RequestMapping(method = RequestMethod.GET)
    public Map<String,Object> getAuthorList(HttpServletRequest request){

        List<Author> authorList = this.authorServiceMybatis.findAuthorList();

        Map<String,Object> param = new HashMap<String,Object>();

        param.put("total",authorList.size());

        param.put("rows",authorList);

        return param;
    }

    @RequestMapping(value = "/{userId}",method = RequestMethod.GET)
    public Author getAuthor(@PathVariable("userId") int userId, HttpServletRequest request){
        Author author = this.authorServiceMybatis.findAuthor((long) userId);
        if(author == null){
            throw new RuntimeException("查询错误");
        }
        return author;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody Map<String,Object> request){
        String userId = (String) request.get("user_id");
        String realName = (String) request.get("real_name");
        String nickName = (String) request.get("nick_name");
        try {
            this.authorServiceMybatis.add(realName,nickName);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "/{userId}",method = RequestMethod.PUT)
    public void update(@PathVariable("userId") Long userId,@RequestBody Map<String,Object> request){
        Author author = this.authorServiceMybatis.findAuthor(userId);
        String realName = (String) request.get("real_name");
        String nickName = (String) request.get("nick_name");
        try {
            this.authorServiceMybatis.update(realName,nickName,author.getId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/{userId}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("userId") Long userId){
        try {
            this.authorServiceMybatis.delete(userId);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
