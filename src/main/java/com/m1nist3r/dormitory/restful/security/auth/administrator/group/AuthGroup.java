package com.m1nist3r.dormitory.restful.security.auth.administrator.group;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.m1nist3r.dormitory.restful.security.auth.administrator.Administrator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "admin_type", schema = "dormitory")
public class AuthGroup implements Serializable {
    @JsonIgnore
    @OneToMany(mappedBy = "authGroup", targetEntity = Administrator.class, fetch = LAZY)
    List<Administrator> administratorList;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "role", nullable = false)
    private String role;
    @Column(name = "description")
    private String description;
}
