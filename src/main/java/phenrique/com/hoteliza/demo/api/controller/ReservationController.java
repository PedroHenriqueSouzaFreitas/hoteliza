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
import phenrique.com.hoteliza.demo.domain.model.Reservation;
import phenrique.com.hoteliza.demo.service.ReservationService;


@RestController
@RequestMapping("/reservation")
public class ReservationController {
    
 @Autowired
    private ReservationService reservationService;

   @PostMapping("/registrar")
    public ResponseEntity<ReservationOutDTO> createReservation(@RequestBody @Valid ReservationInputDTO reservationInput) {
        Reservation createdReservation = reservationService.createReservation(reservationInput);
        
        // Criar o ReservationOutDTO a partir da reserva criada
        ReservationOutDTO reservationOut = new ReservationOutDTO(
            createdReservation.getId(),
            createdReservation.getUser ().getEmail(),
            createdReservation.getRoom().getId(),
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

