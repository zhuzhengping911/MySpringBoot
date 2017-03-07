package com.dao.impl;

import com.compont.Author;
import com.dao.AuthorDao_jdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhuzhengping on 2017/3/7.
 */
@Repository
public class AuthorDaoImpl implements AuthorDao_jdbc {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Author author) {
        return jdbcTemplate.update("INSERT INTO tp_author(real_name,nick_name) VALUES (?,?)",author.getRealName(),author.getNickName());
    }

    @Override
    public int update(Author author) {
        return jdbcTemplate.update("UPDATE tp_author SET real_name = ?,nick_name = ? WHERE id = ?",new Object[]{author.getRealName(),author.getNickName(),author.getId()});
    }

    @Override
    public int delete(Long id) {
        return jdbcTemplate.update("DELETE FROM tp_author WHERE id = ?",id);
    }

    @Override
    public Author findAuthor(Long id) {
        List<Author> list = jdbcTemplate.query("select * from tp_author where id = ?",new Object[]{id},new BeanPropertyRowMapper(Author.class));
        if (null != list && list.size() > 0){
            Author author = list.get(0);
            return author;
        }else {
            return null;
        }
    }

    @Override
    public List<Author> findAuthorList() {
        List<Author> list = jdbcTemplate.query("select * from tp_author",new Object[]{},new BeanPropertyRowMapper(Author.class));
        return list;
    }
}
