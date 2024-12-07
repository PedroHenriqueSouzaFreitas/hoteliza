package phenrique.com.hoteliza.demo.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import phenrique.com.hoteliza.demo.domain.model.User;
import phenrique.com.hoteliza.demo.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
	public User update(final User user, UUID userId) {
		User findUser = search(userId);

		findUser.setName(user.getName());
		findUser.setEmail(user.getEmail());
		findUser.setPassword(user.getPassword());

		return userRepository.save(findUser);
	}

	@Transactional
	public User search(final UUID userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

		if (user instanceof User) {
			return (User) user;
		} else {
			throw new EntityNotFoundException("O usuário encontrado não é um cliente");
		}
	}

}
