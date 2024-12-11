package phenrique.com.hoteliza.demo.api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import phenrique.com.hoteliza.demo.domain.dto.Reservation.ReservationInputDTO;
import phenrique.com.hoteliza.demo.domain.dto.Reservation.ReservationOutDTO;
import phenrique.com.hoteliza.demo.domain.dto.room.RoomOutDTO;
import phenrique.com.hoteliza.demo.domain.model.Reservation;
import phenrique.com.hoteliza.demo.repository.RoomRepository;
import phenrique.com.hoteliza.demo.service.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private RoomRepository roomRepository;

    @PostMapping("/register")
    public ResponseEntity<ReservationOutDTO> createReservation(@RequestBody @Valid ReservationInputDTO reservationInput) {
        // Verifica se o quarto está disponível
        boolean isAvailable = reservationService.isRoomAvailable(reservationInput.getUserEmail(), 
                                                                reservationInput.getRoom().getId(), 
                                                                reservationInput.getCheckIn(), 
                                                                reservationInput.getCheckOut());
        
        if (!isAvailable) {
            return ResponseEntity.status(400).body(null); // Retorna 400 Bad Request se o quarto não estiver disponível
        }

        // Se o quarto estiver disponível, cria a reserva
        Reservation createdReservation = reservationService.createReservation(reservationInput);
        
        RoomOutDTO roomOut = new RoomOutDTO(
        createdReservation.getRoom().getId(),
        createdReservation.getRoom().getNumber(),
        createdReservation.getRoom().getType(),
        createdReservation.getRoom().isAvailable(),
        createdReservation.getRoom().getHotelName(), // Nome do hotel
        createdReservation.getRoom().getHotelAddress() // Endereço do hotel
    );

        ReservationOutDTO reservationOut = new ReservationOutDTO(
            createdReservation.getId(),
            createdReservation.getUser ().getEmail(),
            roomOut, // Passando o RoomOutDTO
            createdReservation.getCheckIn(),
            createdReservation.getCheckOut()
        );

        return ResponseEntity.ok(reservationOut); // Retorna a reserva criada com status 200 OK
    }

    @GetMapping("/list")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.findAllReservations();
        return ResponseEntity.ok(reservations);
    }

    // Endpoint para listar reservas feitas por um usuário específico
    @GetMapping("/list/{userId}")
    public ResponseEntity<List<Reservation>> getReservationsByUser (@PathVariable UUID userId) {
        List<Reservation> reservations = reservationService.findByUserId(userId);
        return ResponseEntity.ok(reservations);
    }
}

