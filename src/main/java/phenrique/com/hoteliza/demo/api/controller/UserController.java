package phenrique.com.hoteliza.demo.api.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import phenrique.com.hoteliza.demo.domain.dto.User.UserOutDTO;
import phenrique.com.hoteliza.demo.domain.model.User;
import phenrique.com.hoteliza.demo.service.UserService;



@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private final UserService userService;

     public UserController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint para buscar informações do usuário pelo e-mail
    @GetMapping("/by-email/{email}")
    public ResponseEntity<UserOutDTO> getUserByEmail(@PathVariable String email) {
        User user = userService.findUserByEmail(email);
        UserOutDTO userOutDTO = new UserOutDTO();
        userOutDTO.setId(user.getId());
        userOutDTO.setName(user.getName());
        userOutDTO.setEmail(user.getEmail());
        return ResponseEntity.ok(userOutDTO);
    }
}
