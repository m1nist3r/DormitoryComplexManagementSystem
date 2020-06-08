package com.m1nist3r.dormitory.restful.security.auth.administrator;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAdministratorRepository extends JpaRepository<Administrator, Long> {
    Optional<Administrator> findByIdNumber(String idNumber);
}
