package phenrique.com.hoteliza.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import phenrique.com.hoteliza.demo.domain.model.Hotel;
import phenrique.com.hoteliza.demo.repository.HotelRepository;



@Service
public class HotelService {
    
    @Autowired
    private HotelRepository hotelRepository;

    @Transactional
	public Hotel register(final Hotel hotel) {
		return hotelRepository.save(hotel);
	}

    
    public List<Hotel> listarHotel(){

        return hotelRepository.findAll();

    }

}
