package com.m1nist3r.dormitory.restful.security.auth.administrator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.m1nist3r.dormitory.restful.security.auth.administrator.group.AuthGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "admin", schema = "dormitory")
public class Administrator implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "id_number", nullable = false, unique = true)
    private String idNumber;
    @JsonIgnore
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "creation_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Column(name = "last_login")
    private Date lastLogin;
    @Column(name = "last_logout")
    private Date lastLogout;
    @Column(name = "is_enabled", nullable = false)
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "id_admin_type", nullable = false, referencedColumnName = "id")
    private AuthGroup authGroup;
}
