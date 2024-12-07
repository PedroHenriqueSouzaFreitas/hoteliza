package phenrique.com.hoteliza.demo.domain.dto.Reservation;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import phenrique.com.hoteliza.demo.domain.model.Room;
import phenrique.com.hoteliza.demo.domain.model.User;

@Getter
@Setter
public class ReservationOutDTO extends ReservationBaseDTO{
    

    private Long id; // ID da reserva
    private String userEmail; // Email do usuário
    private Long roomId; // ID do quarto
    private LocalDate checkIn; // Data de check-in
    private LocalDate checkOut; // Data de check-out

    // Construtor
    public ReservationOutDTO(Long id, String userEmail, Long roomId, LocalDate checkIn, LocalDate checkOut) {
        this.id = id;
        this.userEmail = userEmail;
        this.roomId = roomId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public Long getRoomId() {
        return roomId;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }
}


