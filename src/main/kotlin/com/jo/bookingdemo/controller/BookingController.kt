package com.jo.bookingdemo.controller

import com.jo.bookingdemo.BookingRepository
import com.jo.bookingdemo.model.HotelBooking
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.RequestMethod.POST
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/bookings"])
class BookingController(private val bookingRepository: BookingRepository) {

    @RequestMapping(value = ["/all"], method = [GET])
    fun getAll(): List<HotelBooking> =
            bookingRepository.findAll()

    @RequestMapping(value = ["/affordable/{price}"], method = [GET])
    fun getAffordable(@PathVariable price: Double): List<HotelBooking> =
            bookingRepository.findByPricePerNightLessThan(price)

    @RequestMapping(value = ["/create"], method = [POST])
    fun create(@RequestBody body: HotelBooking): List<HotelBooking> =
            bookingRepository.save(body).run { return getAll() }

    @RequestMapping(value = ["/delete/{id}"], method = [GET])
    fun delete(@PathVariable id: Long): List<HotelBooking> =
            bookingRepository.deleteById(id).run { return getAll() }
}