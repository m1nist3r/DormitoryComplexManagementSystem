package com.m1nist3r.dormitory.restful.repository;

import com.m1nist3r.dormitory.restful.business.domain.room.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoomTypeRepository extends JpaRepository<RoomType, Long> {
}
