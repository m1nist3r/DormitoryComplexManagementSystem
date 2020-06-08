package com.m1nist3r.dormitory.web.application.securing.auth.administrator.group;

import com.m1nist3r.dormitory.web.application.securing.auth.administrator.Administrator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ADMIN_TYPE")
public class AuthGroup {
    @Id
    @Column(name = "IDADMIN_TYPE")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "authGroup")
    private List<Administrator> administratorList;

    public List<Administrator> getAdministratorList() {
        return administratorList;
    }

    public void setAdministratorList(List<Administrator> administratorList) {
        this.administratorList = administratorList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
