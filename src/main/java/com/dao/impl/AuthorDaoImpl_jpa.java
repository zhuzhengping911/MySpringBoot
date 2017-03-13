package com.dao.impl;

import com.compont.Author;
import com.dao.AuthorDao_jdbc;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by zhuzhengping on 2017/3/13.
 * jpa 的实现方式有良知，一种是继承jparepository的方法
 * 还有一种是调用entitymanage的方法
 *
 * 值得注意的是，这个的from对象名，而不是具体的表名
 */
@Repository
public class AuthorDaoImpl_jpa implements AuthorDao_jdbc {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public int add(Author author) {
        return 0;
    }

    @Override
    public int update(Author author) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public Author findAuthor(Long id) {
        return this.entityManager.createQuery("select t from Author t where id = ?1",Author.class).setParameter(1,id).getSingleResult();
    }

    @Override
    public List<Author> findAuthorList() {
        return this.entityManager.createQuery("select t from Author t",Author.class).getResultList();
    }
}
