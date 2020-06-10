package com.m1nist3r.dormitory.restful.business.service.resident;

import com.m1nist3r.dormitory.restful.business.domain.resident.ResidentType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IResidentTypeService {
    List<ResidentType> findAllResidentTypes();

    Optional<ResidentType> findOneResidentType(Long id);

    ResidentType saveResidentType(ResidentType residentType);

    void deleteResidentType(Long id);

}
