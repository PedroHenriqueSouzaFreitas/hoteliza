// RoomController.java
package phenrique.com.hoteliza.demo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phenrique.com.hoteliza.demo.domain.dto.room.RoomOutDTO;
import phenrique.com.hoteliza.demo.domain.model.Room;
import phenrique.com.hoteliza.demo.service.RoomService;
import phenrique.com.hoteliza.demo.assembler.RoomAssembler;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    
    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomAssembler roomAssembler;

    @GetMapping("/list")
    public ResponseEntity<List<RoomOutDTO>> getAllRooms() {
        List<Room> rooms = roomService.findAllRooms();
        List<RoomOutDTO> roomOuts = rooms.stream()
                .map(roomAssembler::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(roomOuts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomOutDTO> getRoomById(@PathVariable Long id) {
        Room room = roomService.findRoomById(id);
        RoomOutDTO roomOut = roomAssembler.toDto(room);
        return ResponseEntity.ok(roomOut);
    }
}