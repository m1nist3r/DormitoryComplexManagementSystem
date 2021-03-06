package com.m1nist3r.dormitory.restful.business.service.room;

import com.m1nist3r.dormitory.restful.business.domain.room.Room;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IRoomService {
    List<Room> findAllRooms();

    List<Room> findVacantRooms();

    Optional<Room> findOneRoom(Long id);

    Room saveRoom(Room room);

    void deleteRoom(Long id);
}
