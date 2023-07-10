package dev.hasan.hotelservice.controller;


import dev.hasan.hotelservice.entities.Hotel;
import dev.hasan.hotelservice.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/create")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel savedHotel = hotelService.createHotel(hotel);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedHotel);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getSingleHotel(@PathVariable String hotelId) {
        Hotel hotel = hotelService.getHotelById(hotelId);
        return ResponseEntity.status(HttpStatus.FOUND).body(hotel);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotel(){
        List<Hotel> allUser = hotelService.getAllHotel();

        if (allUser.isEmpty()){
            return ResponseEntity.status(HttpStatus.FOUND).body(allUser);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(allUser);
    }
}
