package phenrique.com.hoteliza.demo.domain.dto.room;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomBaseDTO {

    @NotNull
    private Long id;

}
