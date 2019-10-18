package com.jo.bookingdemo

import com.jo.bookingdemo.model.HotelBooking
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DatabaseSeeder(private val bookingRepository: BookingRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
        val bookings = arrayListOf<HotelBooking>()
        bookings.add(HotelBooking("Marriot", 200.5, 3))
        bookings.add(HotelBooking("Ibis", 90.0, 4))
        bookings.add(HotelBooking("Novotel", 40.74, 1))

        bookingRepository.saveAll(bookings)
    }

}