package com.m1nist3r.dormitory.web.application.controller;

import com.m1nist3r.dormitory.web.application.business.domain.resident.Resident;
import com.m1nist3r.dormitory.web.application.business.domain.resident.ResidentModel;
import com.m1nist3r.dormitory.web.application.business.domain.resident.ResidentType;
import com.m1nist3r.dormitory.web.application.business.domain.room.Room;
import com.m1nist3r.dormitory.web.application.business.service.ResidentService;
import com.m1nist3r.dormitory.web.application.business.service.RoomService;
import com.m1nist3r.dormitory.web.application.util.PaginatedUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/residents")
public class ResidentController {

    private final Logger logger = LoggerFactory.getLogger(ResidentController.class);

    private final ResidentService detailsService;
    private final RoomService roomService;

    @Autowired
    public ResidentController(ResidentService residentService, RoomService roomService) {
        this.detailsService = residentService;
        this.roomService = roomService;
    }

    @GetMapping
    public String getResidentsDetail(Model model, @RequestParam("page") Optional<Integer> page,
                                     @RequestParam("size") Optional<Integer> size,
                                     @RequestParam("searched") Optional<String> searched) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        String searchedStr = searched.orElse("");
        Page<Resident> residentPage;

        residentPage = PaginatedUtil.getPaginationList(PageRequest.of(currentPage - 1, pageSize),
                detailsService.findPaginatedAllResidents(page.toString(), size.toString(), searchedStr));

        model.addAttribute("residentPage", residentPage);

        PaginatedUtil.setPages(residentPage, model);

        model.addAttribute("currentPage", currentPage);
        return "residents";
    }

    @GetMapping(value = "/add")
    public String getAddResidentForm(Model model) {
        List<Room> roomList = this.roomService.findAllFreeRooms();
        List<ResidentType> residentTypes = this.detailsService.getResidentTypeList();
        model.addAttribute("roomList", roomList);
        model.addAttribute("residentTypes", residentTypes);
        return "add_resident";
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> getResidentValueFieldAjax(@RequestBody String residentTypeId) {
        return ResponseEntity.ok(this.detailsService.getResidentTypeFields(residentTypeId));
    }

    @PostMapping
    public ModelAndView addResident(HttpServletRequest request, Model model,
                                    @ModelAttribute ResidentModel residentModel) {
        Resident resident = this.detailsService.addResident(residentModel);
        model.addAttribute("resident", resident);
        request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
        return new ModelAndView("redirect:/residents/" + resident.getId());
    }

    @GetMapping(value = "/{id}")
    public String getResidentDetails(@PathVariable long id, Model model) {
        Resident resident = this.detailsService.getResidentDetails(id);
        model.addAttribute("resident", resident);
        return "resident";
    }

    @PostMapping(value = "/{id}")
    public String updateResident(Model model, @PathVariable long id, @ModelAttribute ResidentModel residentModel) {
        Resident resident = this.detailsService.updateResident(id, residentModel);
        model.addAttribute("resident", resident);
        model.addAttribute("residentModel", new ResidentModel());
        return "update_resident";
    }


}
