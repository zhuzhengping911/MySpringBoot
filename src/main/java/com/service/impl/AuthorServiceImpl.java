package com.service.impl;

import com.compont.Author;
import com.dao.AuthorDao_jdbc;
import com.service.AuthorService_jdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhuzhengping on 2017/3/7.
 */
@Service("authorService_jdbc")
public class AuthorServiceImpl implements AuthorService_jdbc {

    @Autowired
    private AuthorDao_jdbc authorDao_jdbc;

    @Override
    public int add(Author author) {
        return this.authorDao_jdbc.add(author);
    }

    @Override
    public int update(Author author) {
        return this.authorDao_jdbc.update(author);
    }

    @Override
    public int delete(Long id) {
        return this.authorDao_jdbc.delete(id);
    }

    @Override
    public Author findAuthor(Long id) {
        return this.authorDao_jdbc.findAuthor(id);
    }

    @Override
    public List<Author> findAuthorList() {
        return this.authorDao_jdbc.findAuthorList();
    }
}
