package phenrique.com.hoteliza.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import phenrique.com.hoteliza.demo.domain.model.Reservation;
import phenrique.com.hoteliza.demo.domain.model.User;
import phenrique.com.hoteliza.demo.domain.dto.Reservation.ReservationInputDTO;

import phenrique.com.hoteliza.demo.repository.ReservationRepository;
import phenrique.com.hoteliza.demo.repository.RoomRepository;
import phenrique.com.hoteliza.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Transactional
    public Reservation createReservation(ReservationInputDTO reservationInput) {
        Reservation reservation = new Reservation();

        UserDetails userDetails = userRepository.findByEmail(reservationInput.getUserEmail());

        User user = (User) userDetails;

        reservation.setUser(user);
        reservation.setRoom(roomRepository.findById(reservationInput.getRoomId()).orElseThrow(() -> new RuntimeException("Room not found")));
        reservation.setCheckIn(reservationInput.getCheckIn());
        reservation.setCheckOut(reservationInput.getCheckOut());
        return reservationRepository.save(reservation);
    }
    // Método para listar todas as reservas
    @Transactional(readOnly = true)
    public List<Reservation> findAllReservations() {
        return reservationRepository.findAll();
    }

    // Método existente para encontrar reservas por userId
    public List<Reservation> findByUserId(UUID userId) {
        return reservationRepository.findByUserId(userId);
    }

    }

