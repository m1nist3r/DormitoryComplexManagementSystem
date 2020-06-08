package com.m1nist3r.dormitory.restful.web;

import com.m1nist3r.dormitory.restful.business.domain.resident.Resident;
import com.m1nist3r.dormitory.restful.business.domain.resident.ResidentModel;
import com.m1nist3r.dormitory.restful.business.domain.resident.ResidentType;
import com.m1nist3r.dormitory.restful.business.domain.room.Room;
import com.m1nist3r.dormitory.restful.business.service.resident.IResidentService;
import com.m1nist3r.dormitory.restful.business.service.resident.IResidentTypeService;
import com.m1nist3r.dormitory.restful.business.service.room.IRoomService;
import com.m1nist3r.dormitory.restful.util.ResidentNotFoundException;
import com.m1nist3r.dormitory.restful.util.ResidentTypeNotFoundException;
import com.m1nist3r.dormitory.restful.util.RoomNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.http.ResponseEntity.*;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping(value = "/api/residents")
public class ResidentController {

    private final IResidentService residentService;
    private final IResidentTypeService residentTypeService;
    private final IRoomService roomService;

    @Autowired
    public ResidentController(IResidentService residentService,
                              IResidentTypeService residentTypeService, IRoomService roomService) {
        this.residentService = residentService;
        this.residentTypeService = residentTypeService;
        this.roomService = roomService;
    }

    @GetMapping
    public ResponseEntity<List<Resident>> getAllResidents(
            @RequestParam(name = "filterProperties", required = false) String[] filterProperties) {
        return ok(this.residentService.findAllResident());
    }

    @PostMapping
    public ResponseEntity<Resident> saveResident(@Valid @RequestBody ResidentModel residentModel) {
        Resident resident = this.residentService.updateResident(residentModel.translateModelToResident());
        Room room = roomService.findOneRoom(residentModel.getRoomId()).orElseThrow(() ->
                new RoomNotFoundException(residentModel.getRoomId()));
        room.setAmount(room.getAmount() + 1);
        roomService.saveRoom(room);
        URI location = fromCurrentRequest()
                .path("/{id}").buildAndExpand(resident.getId()).toUri();
        return created(location).body(resident);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resident> getResident(@PathVariable Long id) {
        return ok(this.residentService.findOneResident(id).orElseThrow(() ->
                new ResidentNotFoundException(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resident> updateResident(
            @PathVariable Long id, @Valid @RequestBody ResidentModel residentModel) {
        Resident exist = this.residentService.findOneResident(id).orElseThrow((() ->
                new ResidentNotFoundException(id)));
        if (exist.getRoom().getId() != residentModel.getRoomId()) {
            Room room = roomService.findOneRoom(residentModel.getRoomId()).orElseThrow(() ->
                    new RoomNotFoundException(residentModel.getRoomId()));
            room.setAmount(room.getAmount() - 1);
            roomService.saveRoom(room);
        }
        Resident resident = residentModel.translateModelToResident();
        resident.setId(id);
        this.residentService.updateResident(resident);
        return noContent().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public ResponseEntity<Resident> deleteResident(@PathVariable Long id) {
        this.residentService.findOneResident(id).orElseThrow(() ->
                new ResidentNotFoundException(id));
        this.residentService.deleteResident(id);
        return noContent().build();
    }

    @GetMapping("/types")
    public ResponseEntity<List<ResidentType>> getResidentTypeList() {
        return ok(this.residentTypeService.findAllResidentTypes());
    }

    @GetMapping("/types/{id}")
    public ResponseEntity<ResidentType> getResidentType(@PathVariable Long id) {
        return ok(this.residentTypeService.findOneResidentType(id).orElseThrow(() ->
                new ResidentTypeNotFoundException(id)));
    }
}
