package com.hotelbooking.repository;

import com.hotelbooking.model.BookedRoom;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingRepository extends JpaRepository<BookedRoom, Long> {

    List<BookedRoom> findByRoomId(Long roomId);

    Optional<BookedRoom> findByBookingConfirmationCode(String confirmationCode);

    List<BookedRoom> findByGuestEmail(String email);
}
