package phenrique.com.hoteliza.demo.domain.dto.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserOutDTO extends UserBaseDTO{
    
    private String name;

    private String email;

}
