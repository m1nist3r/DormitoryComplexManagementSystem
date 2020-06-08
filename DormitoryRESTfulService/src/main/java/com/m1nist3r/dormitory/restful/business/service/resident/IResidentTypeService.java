package com.m1nist3r.dormitory.restful.business.service.resident;

import com.m1nist3r.dormitory.restful.business.domain.resident.ResidentType;

import java.util.List;
import java.util.Optional;

public interface IResidentTypeService {
    List<ResidentType> findAllResidentTypes();

    Optional<ResidentType> findOneResidentType(Long id);

    ResidentType saveResidentType(ResidentType residentType);

    void deleteResidentType(Long id);

}
