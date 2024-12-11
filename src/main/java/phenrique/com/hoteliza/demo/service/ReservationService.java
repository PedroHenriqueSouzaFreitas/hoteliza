// ReservationService.java
package phenrique.com.hoteliza.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import phenrique.com.hoteliza.demo.domain.dto.Reservation.ReservationInputDTO;
import phenrique.com.hoteliza.demo.domain.model.Reservation;
import phenrique.com.hoteliza.demo.domain.model.Room;
import phenrique.com.hoteliza.demo.repository.ReservationRepository;
import phenrique.com.hoteliza.demo.repository.RoomRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class ReservationService {
    
    ReservationRepository reservationRepository;
    RoomRepository roomRepository;
   
@Transactional
public Reservation createReservation(ReservationInputDTO reservationInput) {
    String userEmail = reservationInput.getUserEmail();
    Long roomId = reservationInput.getRoom().getId();
    LocalDate checkIn = reservationInput.getCheckIn();
    LocalDate checkOut = reservationInput.getCheckOut();


    if (!isRoomAvailable(userEmail, roomId, checkIn, checkOut)) {
        throw new RuntimeException("Room is not available for the selected dates");
    }

    Reservation reservation = new Reservation();

    Room room = roomRepository.findById(roomId).orElseThrow(() -> new RuntimeException("Room not found"));
    room.setAvailable(false); 
    roomRepository.save(room);

    return reservation; 
}

@Transactional(readOnly = true)
    public boolean isRoomAvailable(String userEmail, Long roomId, LocalDate checkIn, LocalDate checkOut) {
      
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found"));

                if (!room.isAvailable()) {
                    return false; 
                }

        List<Reservation> reservations = reservationRepository.findByRoomIdAndCheckInLessThanEqualAndCheckOutGreaterThanEqual(roomId, checkIn, checkOut);
        return reservations.isEmpty() && room.isAvailable(); 
    }

    // Método para buscar todas as reservas
    @Transactional(readOnly = true)
    public List<Reservation> findAllReservations() {
        return reservationRepository.findAll();
    }

 
    @Transactional(readOnly = true)
    public List<Reservation> findByUserId(UUID userId) {
        return reservationRepository.findByUserId(userId);
    }

}