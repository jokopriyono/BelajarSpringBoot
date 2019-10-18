package com.jo.bookingdemo.model

import com.fasterxml.jackson.annotation.JsonProperty

data class HotelBooking(
        @JsonProperty("hotel_name")
        val hotelName: String,
        @JsonProperty("price_per_night")
        val pricePerNight: Double,
        @JsonProperty("number_of_night")
        val nbOfNights: Int
) {
    fun getTotalPrice(): Double = pricePerNight * nbOfNights
}