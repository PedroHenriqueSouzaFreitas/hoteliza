package phenrique.com.hoteliza.demo.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import phenrique.com.hoteliza.demo.domain.model.Room;
import phenrique.com.hoteliza.demo.service.RoomService;



@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/list")
    public ResponseEntity<List<Room>> listAllRooms() {
        List<Room> rooms = roomService.listAllRooms();
        return ResponseEntity.ok(rooms);
    }

    @PutMapping("/{id}/availability")
    public ResponseEntity<Void> updateRoomAvailability(@PathVariable Long id, @RequestBody boolean status) {
        roomService.atualizarDisponibilidade(id, status);
        return ResponseEntity.noContent().build();
    }
}