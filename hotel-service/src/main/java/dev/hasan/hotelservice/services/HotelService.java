package dev.hasan.hotelservice.services;

import dev.hasan.hotelservice.entities.Hotel;

import java.util.List;

public interface HotelService {
    Hotel createHotel(Hotel hotel);
    List<Hotel> getAllHotel();
    Hotel getHotelById(String id);
}
