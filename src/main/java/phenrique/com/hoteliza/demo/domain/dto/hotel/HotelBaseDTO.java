package phenrique.com.hoteliza.demo.domain.dto.hotel;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelBaseDTO {
    
    @NotNull
    private Long id;

}