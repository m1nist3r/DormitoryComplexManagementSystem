package com.m1nist3r.dormitory.web.application.securing.auth.administrator.group;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthGroupRepository extends JpaRepository<AuthGroup, Long> {
}
