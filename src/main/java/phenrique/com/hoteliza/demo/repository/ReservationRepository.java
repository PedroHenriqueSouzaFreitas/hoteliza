package phenrique.com.hoteliza.demo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import phenrique.com.hoteliza.demo.domain.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    
    List<Reservation> findByRoomIdAndCheckInLessThanEqualAndCheckOutGreaterThanEqual(
    @Param("roomId") Long roomId, 
    @Param("checkIn") LocalDate checkIn, 
    @Param("checkOut") LocalDate checkOut);

   
    List<Reservation> findByUserId(UUID userId);

}
