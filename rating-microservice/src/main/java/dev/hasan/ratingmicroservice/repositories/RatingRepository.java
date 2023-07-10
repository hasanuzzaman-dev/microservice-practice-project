package dev.hasan.ratingmicroservice.repositories;

import dev.hasan.ratingmicroservice.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating,String> {

    List<Rating> findByUserId(String userid);
    List<Rating> findByHotelId(String hotelId);
}
