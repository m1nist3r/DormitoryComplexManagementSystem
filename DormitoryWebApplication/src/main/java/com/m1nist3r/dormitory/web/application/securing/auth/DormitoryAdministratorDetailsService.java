package com.m1nist3r.dormitory.web.application.securing.auth;

import com.m1nist3r.dormitory.web.application.securing.auth.administrator.Administrator;
import com.m1nist3r.dormitory.web.application.securing.auth.administrator.AdministratorRepository;
import com.m1nist3r.dormitory.web.application.securing.auth.administrator.group.AuthGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DormitoryAdministratorDetailsService implements UserDetailsService {

    private final AdministratorRepository administratorRepository;

    @Autowired
    public DormitoryAdministratorDetailsService(AdministratorRepository administratorRepository) {
        super();
        this.administratorRepository = administratorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String pesel) throws UsernameNotFoundException {
        Administrator administrator = this.administratorRepository.findByPesel(pesel);
        if (null == administrator) {
            throw new UsernameNotFoundException("Cannot find PESEL: " + pesel);
        }
        List<AuthGroup> authGroups = new ArrayList<>();
        authGroups.add(administrator.getAuthGroup());
        return new DormitoryAdministratorPrinciple(administrator, authGroups);
    }
}
