package com.m1nist3r.dormitory.restful.business.service.resident;

import com.m1nist3r.dormitory.restful.business.domain.resident.Resident;
import com.m1nist3r.dormitory.restful.business.domain.resident.ResidentType;
import com.m1nist3r.dormitory.restful.repository.IResidentRepository;
import com.m1nist3r.dormitory.restful.repository.IResidentTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResidentServiceImpl implements IResidentService, IResidentTypeService {

    private final IResidentRepository residentRepository;
    private final IResidentTypeRepository residentTypeRepository;

    public ResidentServiceImpl(IResidentRepository residentRepository,
                               IResidentTypeRepository residentTypeRepository) {
        this.residentRepository = residentRepository;
        this.residentTypeRepository = residentTypeRepository;
    }

    @Override
    public List<Resident> findAllResident() {
        return residentRepository.findAll();
    }

    @Override
    public Optional<Resident> findOneResident(Long id) {
        return residentRepository.findById(id);
    }

    @Override
    public Resident updateResident(Resident resident) {
        return residentRepository.save(resident);
    }

    @Override
    public void deleteResident(Long id) {
        residentRepository.deleteById(id);
    }

    @Override
    public List<ResidentType> findAllResidentTypes() {
        return residentTypeRepository.findAll();
    }

    @Override
    public Optional<ResidentType> findOneResidentType(Long id) {
        return residentTypeRepository.findById(id);
    }

    @Override
    public ResidentType saveResidentType(ResidentType residentType) {
        return residentTypeRepository.save(residentType);
    }

    @Override
    public void deleteResidentType(Long id) {
        residentTypeRepository.deleteById(id);
    }
}
