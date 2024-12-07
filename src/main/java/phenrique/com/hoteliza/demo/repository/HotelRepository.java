package phenrique.com.hoteliza.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import phenrique.com.hoteliza.demo.domain.model.Hotel;


public interface HotelRepository extends JpaRepository<Hotel, Long> {
    
}
