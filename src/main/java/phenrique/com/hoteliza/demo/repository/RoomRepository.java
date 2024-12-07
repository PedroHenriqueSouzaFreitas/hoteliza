package phenrique.com.hoteliza.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import phenrique.com.hoteliza.demo.domain.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findAll();

    long count();

}