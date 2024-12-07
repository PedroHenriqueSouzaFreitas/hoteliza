package phenrique.com.hoteliza.demo.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import phenrique.com.hoteliza.demo.domain.model.Enums.RoomType;

@Entity(name="rooms")
@Table(name="rooms")
public class Room {
    
    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id")
    private Long id;

    @Column(name = "number")
    private String number;

    @Column(name = "type")
    private RoomType type;  

    @Column(name = "status")
    private boolean status;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "hotel_id")
private Hotel hotel;

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public RoomType getType() {
        return type;
    }

    public boolean isStatus() {
        return status;
    }
    
    public Hotel getHotel() {
        return hotel;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}


