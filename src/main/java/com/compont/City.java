package com.compont;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by zhuzhengping on 2017/2/23.
 */
@Entity
public class City {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "city_Name",unique = true,nullable = false)
    private String cityName;
    @Column(name = "city_Code",unique = true,nullable = false)
    private String cityCode;


    public City(String cityName, String cityCode) {
        this.cityName = cityName;
        this.cityCode = cityCode;
    }

    public City() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
}
