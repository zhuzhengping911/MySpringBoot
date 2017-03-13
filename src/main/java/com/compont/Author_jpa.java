package com.compont;

import javax.persistence.*;

/**
 * Created by zhuzhengping on 2017/3/13.
 */

@Entity
@Table(name = "tp_author")
public class Author_jpa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "real_name")
    private String realname;

    @Column(name = "nick_name")
    private String nickName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
