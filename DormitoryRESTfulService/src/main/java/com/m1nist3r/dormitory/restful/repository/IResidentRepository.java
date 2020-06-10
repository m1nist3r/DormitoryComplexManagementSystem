package com.m1nist3r.dormitory.restful.repository;

import com.m1nist3r.dormitory.restful.business.domain.resident.Resident;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IResidentRepository extends JpaRepository<Resident, Long> {

}
