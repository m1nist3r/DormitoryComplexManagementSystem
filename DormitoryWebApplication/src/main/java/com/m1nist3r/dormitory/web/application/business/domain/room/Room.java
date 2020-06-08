package com.m1nist3r.dormitory.web.application.business.domain.room;

import com.m1nist3r.dormitory.web.application.business.domain.resident.Resident;

import java.util.List;

public class Room {
    private long id;
    private int roomType;
    private int dormNum;
    private String roomStatus;
    private int resAmount;
    private int floor;
    private String remarks;
    private List<Resident> residentList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRoomType() {
        return roomType;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    public int getDormNum() {
        return dormNum;
    }

    public void setDormNum(int dormNum) {
        this.dormNum = dormNum;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public int getResAmount() {
        return resAmount;
    }

    public void setResAmount(int resAmount) {
        this.resAmount = resAmount;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<Resident> getResidentList() {
        return residentList;
    }

    public void setResidentList(List<Resident> residentList) {
        this.residentList = residentList;
    }
}
