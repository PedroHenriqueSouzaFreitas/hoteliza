package phenrique.com.hoteliza.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import phenrique.com.hoteliza.demo.domain.model.Room;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByAvailable(boolean available);

    long count();

}