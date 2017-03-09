package com.service;

import com.compont.Author;
import com.dao.AuthorMapper_mybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhuzhengping on 2017/3/10.
 */

@Service
public class AuthorService_mybatis {

    @Autowired
    private AuthorMapper_mybatis authorMapperMybatis;


    public int add(String realName,String nickName) {
        return this.authorMapperMybatis.add(realName,nickName);
    }


    public int update(String realName,String nickName,Long id) {
        return this.authorMapperMybatis.update(realName,nickName,id);
    }


    public int delete(Long id) {
        return this.authorMapperMybatis.delete(id);
    }


    public Author findAuthor(Long id) {
        return this.authorMapperMybatis.findAuthor(id);
    }


    public List<Author> findAuthorList() {
        return this.authorMapperMybatis.findAuthorList();
    }
}
