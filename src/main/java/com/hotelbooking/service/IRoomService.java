package com.hotelbooking.service;

//import com.hotelbooking.exception.ResourceNotFoundException;
import com.hotelbooking.exception.InternalServerException;
import com.hotelbooking.exception.ResourceNotFoundException;
import com.hotelbooking.model.Room;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;


import java.time.LocalDate;

import java.util.Optional;



public interface IRoomService {
    Room addNewRoom(MultipartFile photo, String roomType, BigDecimal roomPrice) throws SQLException, IOException;

    List<String> getAllRoomTypes();

    List<Room> getAllRooms();

    byte[] getRoomPhotoByRoomId(Long roomId) throws SQLException, ResourceNotFoundException;

    void deleteRoom(Long roomId);

    Room updateRoom(Long roomId, String roomType, BigDecimal roomPrice, byte[] photoBytes) throws InternalServerException;

    Optional<Room> getRoomById(Long roomId);

    List<Room> getAvailableRooms(LocalDate checkInDate, LocalDate checkOutDate, String roomType);
}
