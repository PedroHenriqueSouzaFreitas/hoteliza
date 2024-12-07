package phenrique.com.hoteliza.demo.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import phenrique.com.hoteliza.demo.domain.dto.hotel.HotelOutDTO;
import phenrique.com.hoteliza.demo.domain.model.Hotel;

@Component
@AllArgsConstructor
public class HotelAssembler {
 
    @Autowired
    private ModelMapper modelMapper;

	public HotelOutDTO toDto(final Hotel hotel) {
		return modelMapper.map(hotel, HotelOutDTO.class);
	}

	public List<HotelOutDTO> toCollectionDto(final List<Hotel> hotels) {
		return hotels.stream().map(this::toDto).collect(Collectors.toList());
	}

}
