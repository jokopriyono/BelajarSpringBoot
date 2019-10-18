package com.jo.bookingdemo.controller

import com.jo.bookingdemo.model.HotelBooking
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.stream.Collectors

@RestController
@RequestMapping(value = ["/bookings"])
class BookingController {
    private final val bookings: ArrayList<HotelBooking> = arrayListOf()

    init {
        bookings.add(HotelBooking("Marriot", 200.5, 3))
        bookings.add(HotelBooking("Ibis", 90.0, 4))
        bookings.add(HotelBooking("Novotel", 40.74, 1))
    }

    @RequestMapping(value = ["/all"], method = [RequestMethod.GET])
    fun getAll(): List<HotelBooking> = bookings

    @RequestMapping(value = ["/affordable/{price}"], method = [RequestMethod.GET])
    fun getAffordable(@PathVariable price: Double): List<HotelBooking> =
            bookings.stream().filter {
                it.pricePerNight <= price
            }.collect(Collectors.toList())

    @RequestMapping(value = ["/create"], method = [RequestMethod.POST])
    fun create(@RequestBody body: HotelBooking): List<HotelBooking> {
        bookings.add(body)
        return bookings
    }
}