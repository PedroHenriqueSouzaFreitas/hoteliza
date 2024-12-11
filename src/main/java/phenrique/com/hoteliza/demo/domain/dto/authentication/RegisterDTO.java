package phenrique.com.hoteliza.demo.domain.dto.authentication;

import phenrique.com.hoteliza.demo.domain.model.Enums.Role;

public record RegisterDTO(String name, String email, String password, Role role) {
    
}
