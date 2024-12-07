package phenrique.com.hoteliza.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import phenrique.com.hoteliza.demo.domain.model.Room;
import phenrique.com.hoteliza.demo.repository.RoomRepository;


@Service
public class RoomService {
    
    @Autowired
    private RoomRepository roomRepository;

public void atualizarDisponibilidade(Long id, boolean status) {
    Room room = roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room not found"));
    room.setStatus(status);
    roomRepository.save(room);
}

    @Transactional
    public List<Room> listAllRooms() {
        return roomRepository.findAll();
    }
}
