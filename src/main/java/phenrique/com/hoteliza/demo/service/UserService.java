package phenrique.com.hoteliza.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import phenrique.com.hoteliza.demo.domain.model.User;
import phenrique.com.hoteliza.demo.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserService {

     @Autowired
    private UserRepository userRepository;

    @Transactional
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email)
            .orElseThrow(() -> new EntityNotFoundException("User  not found with email: " + email));
    }
}


