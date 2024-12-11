package phenrique.com.hoteliza.demo.domain.dto.room;

import lombok.Getter;
import lombok.Setter;
import phenrique.com.hoteliza.demo.domain.model.Enums.RoomType;

@Getter
@Setter
public class RoomOutDTO {
    private Long id; 
    private String number; 
    private RoomType type; 
    private boolean available;
    private String hotelName; 
    private String hotelAddress; 

    // Construtor
    public RoomOutDTO(Long id, String number, RoomType type, boolean available, String hotelName, String hotelAddress) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.available = available;
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
    }

    public Long getId() {
        return id;
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

    public String getHotelName() {
        return hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

}