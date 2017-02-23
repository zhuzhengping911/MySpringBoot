package com.dao;

/**
 * Created by zhuzhengping on 2017/2/23.
 */
public interface HotelSummary {


    String getName();
    Double getAverageRating();
    default Integer getAverageRatingRounded(){
        return getAverageRating() == null ? null : (int)Math.round(getAverageRating());
    }

}
