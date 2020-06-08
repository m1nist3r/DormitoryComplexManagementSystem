package com.m1nist3r.dormitory.restful.security.auth;

import com.m1nist3r.dormitory.restful.security.auth.administrator.Administrator;
import com.m1nist3r.dormitory.restful.security.auth.administrator.IAdministratorRepository;
import com.m1nist3r.dormitory.restful.security.auth.administrator.group.AuthGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DormitoryAdministratorDetailsService implements UserDetailsService {

    private final IAdministratorRepository administratorRepository;

    @Autowired
    public DormitoryAdministratorDetailsService(IAdministratorRepository administratorRepository) {
        super();
        this.administratorRepository = administratorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String idNumber) throws UsernameNotFoundException {
        Administrator administrator = this.administratorRepository.findByIdNumber(idNumber).orElseThrow(() ->
                new UsernameNotFoundException("Cannot find ID Number: " + idNumber));
        List<AuthGroup> authGroups = new ArrayList<>();
        authGroups.add(administrator.getAuthGroup());
        return new DormitoryAdministratorPrinciple(administrator, authGroups);
    }
}
