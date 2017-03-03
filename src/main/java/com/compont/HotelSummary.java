package com.compont;

/**
 * Created by zhuzhengping on 2017/2/23.
 *
 * 使用interface将返回的数据封装成一个实体类
 */
public interface HotelSummary {


    String getName();
    Double getAverageRating();
    default Integer getAverageRatingRounded(){
        return getAverageRating() == null ? null : (int)Math.round(getAverageRating());
    }

}
