package phenrique.com.hoteliza.demo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import phenrique.com.hoteliza.demo.assembler.HotelAssembler;
import phenrique.com.hoteliza.demo.domain.dto.hotel.HotelOutDTO;
import phenrique.com.hoteliza.demo.service.HotelService;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    
    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelAssembler hotelAssembler;


  @GetMapping("/list")
	public List<HotelOutDTO> list() {
		return hotelAssembler.toCollectionDto(hotelService.listarHotel());
	}

}