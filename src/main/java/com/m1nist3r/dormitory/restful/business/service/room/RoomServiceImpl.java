package com.m1nist3r.dormitory.restful.business.service.room;

import com.m1nist3r.dormitory.restful.business.domain.room.Room;
import com.m1nist3r.dormitory.restful.business.domain.room.RoomType;
import com.m1nist3r.dormitory.restful.repository.IRoomRepository;
import com.m1nist3r.dormitory.restful.repository.IRoomTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements IRoomService, IRoomTypeService {

    private final IRoomRepository roomRepository;
    private final IRoomTypeRepository roomTypeRepository;

    public RoomServiceImpl(IRoomRepository roomRepository, IRoomTypeRepository roomTypeRepository) {
        this.roomRepository = roomRepository;
        this.roomTypeRepository = roomTypeRepository;
    }

    @Override
    public List<Room> findAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public List<Room> findVacantRooms() {
        return roomRepository.findVacantRooms();
    }

    @Override
    public Optional<Room> findOneRoom(Long id) {
        return roomRepository.findById(id);
    }

    @Override
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    @Override
    public List<RoomType> findAllRoomTypes() {
        return roomTypeRepository.findAll();
    }

    @Override
    public Optional<RoomType> findOneRoomType(Long id) {
        return roomTypeRepository.findById(id);
    }

    @Override
    public RoomType saveRoomType(RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }

    @Override
    public void deleteRoomType(Long id) {
        roomTypeRepository.deleteById(id);
    }
}
