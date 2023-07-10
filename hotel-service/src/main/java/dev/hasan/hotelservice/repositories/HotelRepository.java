package dev.hasan.hotelservice.repositories;

import dev.hasan.hotelservice.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface HotelRepository extends JpaRepository<Hotel,String> {
}
