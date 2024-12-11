package phenrique.com.hoteliza.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phenrique.com.hoteliza.demo.domain.model.Room;
import phenrique.com.hoteliza.demo.repository.RoomRepository;

import java.util.List;

@Service
public class RoomService {
    
    @Autowired
    private RoomRepository roomRepository;

    @Transactional(readOnly = true)
    public List<Room> findAllRooms() {
        return roomRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Room findRoomById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));
    }
}