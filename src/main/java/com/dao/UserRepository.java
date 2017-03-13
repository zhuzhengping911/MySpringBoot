package com.dao;

import com.compont.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by zhuzhengping on 2017/2/14.
 * jpa 的实现方式有良知，一种是继承jparepository的方法
 * 还有一种是调用entitymanage的方法
 */
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserName(String userName);

    User findByUserNameOrEmail(String username,String email);

//    Long deleteById(Long id);

    Long countByUserName(String userName);

    List<User> findByEmailLike(String email);

    Page<User> findAll(Pageable pageable);

    Page<User> findByUserName(String userName,Pageable pageable);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update User t set t.user_name = :username where t.id = :id",nativeQuery = true)
    void modifyByIdAndUserId(@Param("username") String username, @Param("id") long id);

    @Query(value = "select t.userName from User t where t.email like ?1")
    Page<User> findUser(String email,Pageable pageable);
}
