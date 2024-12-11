package phenrique.com.hoteliza.demo.domain.dto.Reservation;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import phenrique.com.hoteliza.demo.domain.dto.room.RoomOutDTO;

@Getter
@Setter
public class ReservationOutDTO extends ReservationBaseDTO {
    
    private Long id; // ID da reserva
    private String userEmail; // Email do usuário
    private RoomOutDTO room; // Objeto RoomOutDTO
    private LocalDate checkIn; // Data de check-in
    private LocalDate checkOut; // Data de check-out

    // Construtor
    public ReservationOutDTO(Long id, String userEmail, RoomOutDTO room, LocalDate checkIn, LocalDate checkOut) {
        this.id = id;
        this.userEmail = userEmail;
        this.room = room;
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

    public RoomOutDTO getRoom() {
        return room;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }
}


