package phenrique.com.hoteliza.demo.assembler;


import java.util.stream.Collectors;
import java.util.List;

import org.modelmapper.ModelMapper;

import phenrique.com.hoteliza.demo.domain.dto.User.UserInputDTO;
import phenrique.com.hoteliza.demo.domain.dto.User.UserOutDTO;
import phenrique.com.hoteliza.demo.domain.model.User;



public class UserAssembler {
    
    private ModelMapper modelMapper;
	
	public User toUser(final UserInputDTO UserInputDTO) {
		return modelMapper.map(UserInputDTO, User.class);
	}
	
	public UserOutDTO toDto(final User user) {
		return modelMapper.map(user, UserOutDTO.class);
	}
	
	public List<UserOutDTO> toCollectionDto(final List<User> users){
		return users.stream().map(this::toDto).collect(Collectors.toList());
	}

}