package phenrique.com.hoteliza.demo.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import phenrique.com.hoteliza.demo.domain.dto.room.RoomOutDTO;
import phenrique.com.hoteliza.demo.domain.model.Room;


@Component
@AllArgsConstructor
public class RoomAssembler {
 
    @Autowired
    private ModelMapper modelMapper;

	public RoomOutDTO toDto(final Room rooms) {
		return modelMapper.map(rooms, RoomOutDTO.class);
	}

	public List<RoomOutDTO> toCollectionDto(final List<Room> rooms) {
		return rooms.stream().map(this::toDto).collect(Collectors.toList());
	}
    
}
