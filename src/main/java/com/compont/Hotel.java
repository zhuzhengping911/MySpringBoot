package com.compont;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by zhuzhengping on 2017/2/23.
 */
@Entity
public class Hotel {

    @Id
    @GeneratedValue
    private Long hotelId;
    @Column(name = "hotel_Name",unique = false,nullable = true)
    private String hotelName;
    @Column(name = "hotel_address")
    private String hotelAddress;
    @Column(name = "hotel_Tel")
    private String hotelTel;
    @Column(name = "hotel_Rating")
    private Double rating;
    @Column(name = "city_Id")
    private Long cityId;

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelTel() {
        return hotelTel;
    }

    public void setHotelTel(String hotelTel) {
        this.hotelTel = hotelTel;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Hotel() {
    }

    public Hotel(String hotelName, String hotelAddress, String hotelTel, Double rating, Long cityId) {
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.hotelTel = hotelTel;
        this.rating = rating;
        this.cityId = cityId;
    }
}
