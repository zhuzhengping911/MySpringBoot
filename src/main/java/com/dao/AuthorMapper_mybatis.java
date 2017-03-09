package com.dao;

import com.compont.Author;
import org.apache.ibatis.annotations.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zhuzhengping on 2017/3/10.
 */
@Component
@Mapper
public interface AuthorMapper_mybatis {

    @Insert("NSERT INTO tp_author(real_name,nick_name) VALUES (#{real_name},#{nick_name})")
    int add(@Param("realName") String realName,@Param("nick_name") String nickName);

    @Update("UPDATE tp_author SET real_name = #{real_name},nick_name = #{nick_name} WHERE id = #{id}")
    int update(@Param("realName") String realName,@Param("nick_name") String nickName,@Param("id") Long id);

    @Delete("DELETE FROM tp_author WHERE id = #{id}")
    int delete(Long id);

    @Select("select id,real_name as realName,nick_name as nickName from tp_author where id = #{id}")
    Author findAuthor(@Param("id") Long id);

    @Select("select id,real_name as realName,nick_name as nickName from tp_author")
    List<Author> findAuthorList();
}
