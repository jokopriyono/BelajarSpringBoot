package com.jo.bookingdemo.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class HotelBooking(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val id: Long,
        @JsonProperty("hotel_name")
        val hotelName: String,
        @JsonProperty("price_per_night")
        val pricePerNight: Double,
        @JsonProperty("number_of_night")
        val nbOfNights: Int
) {
    constructor(hotelName: String, pricePerNight: Double, nbOfNights: Int) : this(0, hotelName, pricePerNight, nbOfNights)

    fun getTotalPrice(): Double = pricePerNight * nbOfNights
}