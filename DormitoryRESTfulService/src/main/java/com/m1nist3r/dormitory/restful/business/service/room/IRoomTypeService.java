package com.m1nist3r.dormitory.restful.business.service.room;

import com.m1nist3r.dormitory.restful.business.domain.room.RoomType;

import java.util.List;
import java.util.Optional;

public interface IRoomTypeService {
    List<RoomType> findAllRoomTypes();

    Optional<RoomType> findOneRoomType(Long id);

    RoomType saveRoomType(RoomType roomType);

    void deleteRoomType(Long id);

}
