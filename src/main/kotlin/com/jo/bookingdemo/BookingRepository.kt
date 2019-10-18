package com.jo.bookingdemo

import com.jo.bookingdemo.model.HotelBooking
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookingRepository : JpaRepository<HotelBooking, Long> {
    fun findByPricePerNightLessThan(price: Double): List<HotelBooking>
}