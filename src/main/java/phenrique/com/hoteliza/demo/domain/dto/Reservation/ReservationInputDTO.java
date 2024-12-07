package phenrique.com.hoteliza.demo.domain.dto.Reservation;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import phenrique.com.hoteliza.demo.domain.model.Room;
import phenrique.com.hoteliza.demo.domain.model.User;
import phenrique.com.hoteliza.demo.domain.model.Enums.RoomType;


@Getter
@Setter
public class ReservationInputDTO {
    
    @NotNull
    private String userEmail; // Email do usuário que está fazendo a reserva

    @NotNull
    private Long roomId; // ID do quarto

    @NotNull
    private LocalDate checkIn; // Data de check-in

    @NotNull
    private LocalDate checkOut; // Data de check-out

    // Getters e Setters
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }
}
