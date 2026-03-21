package org.hotelbooking.hotelservice.service;

import lombok.RequiredArgsConstructor;
import org.hotelbooking.hotelservice.model.Hotel;
import org.hotelbooking.hotelservice.repo.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
    }

    public List<Hotel> searchByLocation(String location) {
        return hotelRepository.findByLocationContainingIgnoreCase(location);
    }
}
