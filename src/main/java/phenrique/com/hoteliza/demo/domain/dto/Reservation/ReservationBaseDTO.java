package phenrique.com.hoteliza.demo.domain.dto.Reservation;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationBaseDTO {
    
    @NotNull
    private Long id;

}
