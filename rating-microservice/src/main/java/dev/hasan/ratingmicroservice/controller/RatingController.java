package dev.hasan.ratingmicroservice.controller;


import dev.hasan.ratingmicroservice.entities.Rating;
import dev.hasan.ratingmicroservice.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/create")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        Rating savedRating = ratingService.createRating(rating);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedRating);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
        List<Rating> allRating = ratingService.getRatingsByUserId(userId);

        if (allRating.isEmpty()){
            return ResponseEntity.status(HttpStatus.FOUND).body(allRating);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(allRating);
    }



    @GetMapping
    public ResponseEntity<List<Rating>> getAllRating(){
        List<Rating> allRating = ratingService.getAllRating();
        if (allRating.isEmpty()){
            return ResponseEntity.status(HttpStatus.FOUND).body(allRating);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(allRating);
    }

    // Gat all rating by Hotel
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
        return  ResponseEntity.ok(ratingService.getRatingsByHotelId(hotelId));
    }


}
