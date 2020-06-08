package com.m1nist3r.dormitory.web.application.securing.auth;

import com.m1nist3r.dormitory.web.application.securing.auth.administrator.Administrator;
import com.m1nist3r.dormitory.web.application.securing.auth.administrator.group.AuthGroup;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class DormitoryAdministratorPrinciple implements UserDetails {

    private final Administrator administrator;
    private final List<AuthGroup> authGroups;

    public DormitoryAdministratorPrinciple(Administrator administrator, List<AuthGroup> authGroup) {
        super();
        this.administrator = administrator;
        this.authGroups = authGroup;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (null == authGroups) {
            return Collections.emptySet();
        }
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
        authGroups.forEach(authGroup -> grantedAuthorities.add(new SimpleGrantedAuthority(authGroup.getDescription())));
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return administrator.getPassword();
    }

    @Override
    public String getUsername() {
        return administrator.getPesel();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
