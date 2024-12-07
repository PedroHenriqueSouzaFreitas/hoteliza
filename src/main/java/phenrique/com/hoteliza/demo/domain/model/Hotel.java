package phenrique.com.hoteliza.demo.domain.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="hotels")
public class Hotel {
    
    @Id
    @NotNull
    private Long id;
    
    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "hotel")
    private List<Room> roomId;

    @ManyToMany
    @JoinTable(
    name = "hotel_rooms",
    joinColumns = @JoinColumn(name = "hotel_id"),
    inverseJoinColumns = @JoinColumn(name = "room_id")
)
    private List<Room> tags = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Room> getRoom() {
        return roomId;
    }

    public List<Room> getTags() {
        return tags;
    }


}
