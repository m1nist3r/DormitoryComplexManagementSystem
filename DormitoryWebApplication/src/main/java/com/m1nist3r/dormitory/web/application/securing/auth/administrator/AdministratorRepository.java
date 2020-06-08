package com.m1nist3r.dormitory.web.application.securing.auth.administrator;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    Administrator findByPesel(String pesel);
}
