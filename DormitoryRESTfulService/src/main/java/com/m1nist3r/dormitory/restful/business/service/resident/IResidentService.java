package com.m1nist3r.dormitory.restful.business.service.resident;

import com.m1nist3r.dormitory.restful.business.domain.resident.Resident;

import java.util.List;
import java.util.Optional;

public interface IResidentService {
    List<Resident> findAllResident();

    Optional<Resident> findOneResident(Long id);

    Resident updateResident(Resident resident);

    void deleteResident(Long id);
}
