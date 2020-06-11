package com.m1nist3r.dormitory.restful.security.auth.administrator.group;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthGroupRepository extends JpaRepository<AuthGroup, Long> {
}
