package com.hotelbooking.repository;

import com.hotelbooking.model.BookedRoom;

import java.util.List;
import java.util.Optional;

public interface BookingRepository {
    List<BookedRoom> findAll();

    List<BookedRoom> findByRoomId(Long roomId);

    Optional<BookedRoom> findByBookingConfirmationCode(String confirmationCode);

    List<BookedRoom> findByGuestEmail(String email);

    void deleteById(Long bookingId);

    void save(BookedRoom bookingRequest);
}
