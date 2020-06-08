package com.m1nist3r.dormitory.restful.repository;

import com.m1nist3r.dormitory.restful.business.domain.resident.ResidentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IResidentTypeRepository extends JpaRepository<ResidentType, Long> {

}
