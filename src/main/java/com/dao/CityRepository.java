package com.dao;

import com.compont.City;
import com.compont.HotelSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by zhuzhengping on 2017/2/24.
 */
public interface CityRepository extends JpaRepository<City,Long> {

    @Query(value = "select h.hotelName as name,avg(h.rating) as averageRating from Hotel h, City c where h.cityId = c.id and c.id = ?1 group by h")
    Page<HotelSummary> findByCity (Long id, Pageable pageable);
}
