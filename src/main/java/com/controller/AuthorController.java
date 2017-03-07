package com.controller;

import com.compont.Author;
import com.service.AuthorService_jdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhuzhengping on 2017/3/7.
 */
@RestController
@RequestMapping(value = "/data/jdbc/author")
public class AuthorController {

    @Autowired
    private AuthorService_jdbc authorServiceJdbc;

    @RequestMapping(method = RequestMethod.GET)
    public Map<String,Object> getAuthorList(HttpServletRequest request){

        List<Author> authorList = this.authorServiceJdbc.findAuthorList();

        Map<String,Object> param = new HashMap<String,Object>();

        param.put("total",authorList.size());

        param.put("rows",authorList);

        return param;
    }

    @RequestMapping(value = "/{userId}",method = RequestMethod.GET)
    public Author getAuthor(@PathVariable("userId") int userId,HttpServletRequest request){
        Author author = this.authorServiceJdbc.findAuthor((long) userId);
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
        Author author = new Author();
        if(author != null){
            author.setId(Long.valueOf(userId));
        }
        author.setRealName(realName);
        author.setRealName(nickName);
        try {
            this.authorServiceJdbc.add(author);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "/{userId}",method = RequestMethod.PUT)
    public void update(@PathVariable("userId") Long userId,@RequestBody Map<String,Object> request){
        Author author = this.authorServiceJdbc.findAuthor(userId);
        String realName = (String) request.get("real_name");
        String nickName = (String) request.get("nick_name");
        author.setRealName(realName);
        author.setRealName(nickName);
        try {
            this.authorServiceJdbc.update(author);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/{userId}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("userId") Long userId){
        try {
            this.authorServiceJdbc.delete(userId);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
