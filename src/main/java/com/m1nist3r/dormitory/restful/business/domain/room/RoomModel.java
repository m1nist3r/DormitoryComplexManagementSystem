package com.m1nist3r.dormitory.restful.business.domain.room;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RoomModel {
    @Size(min = 2, max = 26)
    @NotBlank(message = "Dormitory Name is mandatory")
    private String dormitoryName;
    @Size(min = 2, max = 26)
    @NotBlank(message = "Remarks is mandatory")
    private String remarks;
    @NotNull(message = "Amount is mandatory")
    private int amount;
    @NotNull(message = "Room Typpe is mandatory")
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
