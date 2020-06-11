package com.m1nist3r.dormitory.restful.web;

import com.m1nist3r.dormitory.restful.business.domain.room.Room;
import com.m1nist3r.dormitory.restful.business.domain.room.RoomModel;
import com.m1nist3r.dormitory.restful.business.domain.room.RoomType;
import com.m1nist3r.dormitory.restful.business.service.room.IRoomService;
import com.m1nist3r.dormitory.restful.business.service.room.IRoomTypeService;
import com.m1nist3r.dormitory.restful.util.RoomNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/api/rooms")

public class RoomController {
    private final IRoomService roomService;
    private final IRoomTypeService roomTypeService;

    @Autowired
    public RoomController(IRoomService roomService, IRoomTypeService roomTypeService) {
        this.roomService = roomService;
        this.roomTypeService = roomTypeService;
    }


    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms(
            @RequestParam(name = "filterProperties", required = false) String[] filterProperties) {
        return ok(roomService.findAllRooms());
    }

    @GetMapping("/vacant")
    public ResponseEntity<List<Room>> getVacantRooms() {
        return ok(roomService.findVacantRooms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoom(@PathVariable Long id) {
        return ok(this.roomService.findOneRoom(id).orElseThrow(() ->
                new RoomNotFoundException(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long id, @RequestBody RoomModel roomModel) {
        this.roomService.findOneRoom(id).orElseThrow(() ->
                new RoomNotFoundException(id));
        Room room = roomModel.translateModelToRoom();
        room.setId(id);
        this.roomService.saveRoom(room);
        return noContent().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public ResponseEntity<Room> deleteRoom(@PathVariable Long id) {
        this.roomService.findOneRoom(id).orElseThrow(() ->
                new RoomNotFoundException(id));
        this.roomService.deleteRoom(id);
        return noContent().build();
    }

    @GetMapping("/types")
    public ResponseEntity<List<RoomType>> getAllRoomTypes(
            @RequestParam(name = "filterProperties", required = false) String[] filterProperties) {
        return ok(roomTypeService.findAllRoomTypes());
    }

    @GetMapping("/types/{id}")
    public ResponseEntity<RoomType> getRoomType(@PathVariable Long id) {
        return ok(this.roomTypeService.findOneRoomType(id).orElseThrow(() ->
                new RoomNotFoundException(id)));
    }
}
