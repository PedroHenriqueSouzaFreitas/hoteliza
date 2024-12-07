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

import jakarta.validation.Valid;
import phenrique.com.hoteliza.demo.domain.model.User;
import phenrique.com.hoteliza.demo.service.UserService;



@Controller
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint para atualizar um usuário
    @PutMapping("/userId")
    @Transactional
    public ResponseEntity<User> updateUser(
            @PathVariable UUID userId,
            @RequestBody @Valid User user) {
        User updatedUser = userService.update(user, userId);
        return ResponseEntity.ok(updatedUser);
    }

    // Endpoint para buscar um usuário pelo ID
    @GetMapping("/userId")
    public ResponseEntity<User> getUserById(@PathVariable UUID userId) {
        User user = userService.search(userId);
        return ResponseEntity.ok(user);
    }

}