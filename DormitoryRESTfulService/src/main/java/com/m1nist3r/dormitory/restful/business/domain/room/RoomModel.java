package com.m1nist3r.dormitory.restful.business.domain.room;

import lombok.Data;

@Data
public class RoomModel {
    private String dormitoryName;
    private String status;
    private int capacity;
    private String remarks;
    private int amount;
    private RoomType roomType;


    public Room translateModelToRoom() {
        Room room = new Room();
        room.setDormitoryName(this.dormitoryName);
        room.setRemarks(this.remarks);
        room.setAmount(this.amount);
        room.setRoomType(this.roomType);

        return room;
    }
}
