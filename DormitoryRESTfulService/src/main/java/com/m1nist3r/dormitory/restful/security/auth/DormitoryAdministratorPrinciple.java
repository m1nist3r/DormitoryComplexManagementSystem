package com.m1nist3r.dormitory.restful.security.auth;

import com.m1nist3r.dormitory.restful.security.auth.administrator.Administrator;
import com.m1nist3r.dormitory.restful.security.auth.administrator.group.AuthGroup;
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
        authGroups.forEach(authGroup -> grantedAuthorities.add(new SimpleGrantedAuthority(authGroup.getRole())));
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return administrator.getPassword();
    }

    @Override
    public String getUsername() {
        return administrator.getIdNumber();
    }

    @Override
    public boolean isAccountNonExpired() {
        return administrator.isActive();
    }

    @Override
    public boolean isAccountNonLocked() {
        return administrator.isActive();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return administrator.isActive();
    }

    @Override
    public boolean isEnabled() {
        return administrator.isActive();
    }
}
