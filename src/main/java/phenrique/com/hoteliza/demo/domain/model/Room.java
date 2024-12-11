package phenrique.com.hoteliza.demo.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import phenrique.com.hoteliza.demo.domain.model.Enums.RoomType;

@Entity(name = "rooms")
@Table(name="rooms")
@AllArgsConstructor
public class Room {
    
    @Id
    @NotNull
    @Column(name = "id")
    private Long id;

    @Column(name = "hotel")
    private String hotel;

    @Column(name = "address")
    private String address;

    @Column(name = "number")
    private String number;

    @Column(name = "type")
    private RoomType type;  

    @Column(name = "status")
    private boolean available;

    public Long getId() {
        return id;
    }

    public String getHotelName() {
        return hotel;
    }

    public String getHotelAddress() {
        return address;
    }

    public String getNumber() {
        return number;
    }

    public RoomType getType() {
        return type;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }



}


