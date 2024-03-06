package com.hotelbooking.service;

import com.hotelbooking.exception.InternalServerException;
import com.hotelbooking.exception.ResourceNotFoundException;
import com.hotelbooking.model.BookedRoom;
import com.hotelbooking.model.Room;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService implements IRoomService{
    public List<BookedRoom> getAllBookingsByRoomId(Long roomId) {
        return null;
    }

    @Override
    public Room addNewRoom(MultipartFile photo, String roomType, BigDecimal roomPrice) throws SQLException, IOException {
        return null;
    }

    @Override
    public List<String> getAllRoomTypes() {
        return null;
    }

    @Override
    public List<Room> getAllRooms() {
        return null;
    }

    @Override
    public byte[] getRoomPhotoByRoomId(Long roomId) throws SQLException, ResourceNotFoundException {
        return new byte[0];
    }

    @Override
    public void deleteRoom(Long roomId) {

    }

    @Override
    public Room updateRoom(Long roomId, String roomType, BigDecimal roomPrice, byte[] photoBytes) throws InternalServerException {
        return null;
    }

    @Override
    public Optional<Room> getRoomById(Long roomId) {
        return Optional.empty();
    }

    @Override
    public List<Room> getAvailableRooms(LocalDate checkInDate, LocalDate checkOutDate, String roomType) {
        return null;
    }
}
