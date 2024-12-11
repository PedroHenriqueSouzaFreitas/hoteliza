package phenrique.com.hoteliza.demo.domain.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Reservations")
@Getter
@Setter
@Table(name = "reservations")
public class Reservation {
    
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="user_email")
    private User userEmail;

    @Column(name = "checkin")
    private LocalDate checkIn;

    @Column(name = "checkout")
    private LocalDate checkOut;

    public Long getId() {
        return id;
    }

    public Room getRoom() {
        return room;
    }

    public User getUser() {
        return user;
    }

    public User getUserEmail() {
        return userEmail;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUserEmail(User userEmail) {
        this.userEmail = userEmail;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    
}
