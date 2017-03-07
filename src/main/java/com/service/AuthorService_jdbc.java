package com.service;

import com.compont.Author;

import java.util.List;

/**
 * Created by zhuzhengping on 2017/3/7.
 */
public interface AuthorService_jdbc {
    int add(Author author);

    int update(Author author);

    int delete(Long id);

    Author findAuthor(Long id);

    List<Author> findAuthorList();
}
