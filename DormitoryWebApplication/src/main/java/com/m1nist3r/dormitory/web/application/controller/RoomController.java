package com.m1nist3r.dormitory.web.application.controller;

import com.m1nist3r.dormitory.web.application.business.domain.room.Room;
import com.m1nist3r.dormitory.web.application.business.domain.room.RoomModel;
import com.m1nist3r.dormitory.web.application.business.service.RoomService;
import com.m1nist3r.dormitory.web.application.util.PaginatedUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public String getRoomsDetail(Model model, @RequestParam("page") Optional<Integer> page,
                                      @RequestParam("size") Optional<Integer> size,
                                      @RequestParam("searched") Optional<String> searched) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        String searchedStr = searched.orElse("");
        Page<Room> roomPage;

        roomPage = PaginatedUtil.getPaginationList(PageRequest.of(currentPage - 1, pageSize),
                roomService.findPaginatedAllRooms(page.toString(), size.toString(), searchedStr));

        model.addAttribute("roomPage", roomPage);

        PaginatedUtil.setPages(roomPage, model);

        model.addAttribute("currentPage", currentPage);
        return "rooms";
    }

    @GetMapping(value = "/{id}")
    public String getRoomDetails(@PathVariable long id, Model model) {
        Room room = this.roomService.getRoomDetails(id);
        model.addAttribute("room", room);
        return "room";
    }

    @PostMapping(value = "/{id}")
    public String updateRoom(Model model, @PathVariable long id, @ModelAttribute RoomModel roomModel) {
        Room room = this.roomService.updateRoom(id, roomModel);
        model.addAttribute("room", room);
        model.addAttribute("roomModel", new RoomModel());
        return "update_room";
    }


}
