package com.dao;

import com.compont.Author;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zhuzhengping on 2017/3/7.
 * jdbc链接数据库dao层
 */
@Component
public interface AuthorDao_jdbc {

    int add(Author author);

    int update(Author author);

    int delete(Long id);

    Author findAuthor(Long id);

    List<Author> findAuthorList();
}
