package com.m1nist3r.dormitory.restful.repository;

import com.m1nist3r.dormitory.restful.business.domain.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRoomRepository extends JpaRepository<Room, Long> {
    @Query(value = "select r from Room r where r.roomType.capacity > r.amount")
    List<Room> findVacantRooms();
}
