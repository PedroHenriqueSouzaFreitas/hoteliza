package phenrique.com.hoteliza.demo.domain.dto.room;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomOutDTO extends RoomBaseDTO {
    
    private String number;

    private Boolean status;

    private String type;

    private Long hotelId;
}
