package com.epam.reservations.business.service;

import com.epam.reservations.business.domain.RoomReservation;
import com.epam.reservations.data.enity.Guest;
import com.epam.reservations.data.enity.Reservation;
import com.epam.reservations.data.enity.Room;
import com.epam.reservations.data.repository.GuestRepository;
import com.epam.reservations.data.repository.ReservationRepository;
import com.epam.reservations.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReservationService {
    private RoomRepository roomRepository;
    private GuestRepository guestRepository;
    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<RoomReservation> getRoomReservationsForDate(Date date) {
        Iterable<Room> rooms = this.roomRepository.findAll();
        Map<Long, RoomReservation> roomReservationMap = new HashMap<>();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getId());
            roomReservation.setRoomName(room.getName());
            roomReservation.setRoomNumber(room.getNumber());
            roomReservationMap.put(room.getId(), roomReservation);
        });
        Iterable<Reservation> reservations = reservationRepository.findByDate(new java.sql.Date(date.getTime()));
        if (null != reservations) {
            reservations.forEach(reservation -> {
                Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
                if (null != guest) {
                    RoomReservation roomReservation = roomReservationMap.get(reservation.getId());
                    roomReservation.setDate(date);
                    roomReservation.setFirstName(guest.getFirstName());
                    roomReservation.setLastName(guest.getLastName());
                    roomReservation.setGuestId(guest.getId());
                }

            });

        }
        List<RoomReservation> roomReservations = new ArrayList<>();
        for (Long roomId :
                roomReservationMap.keySet()) {
            roomReservations.add(roomReservationMap.get(roomId));
        }
        return roomReservations;
    }
}
