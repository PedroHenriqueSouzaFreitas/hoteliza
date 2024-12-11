package phenrique.com.hoteliza.demo.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import phenrique.com.hoteliza.demo.domain.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {

UserDetails findByEmail(String email);

Optional<User> findUserByEmail(String email);

}
