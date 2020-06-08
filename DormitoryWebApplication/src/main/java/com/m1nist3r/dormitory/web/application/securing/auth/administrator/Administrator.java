package com.m1nist3r.dormitory.web.application.securing.auth.administrator;

import com.m1nist3r.dormitory.web.application.securing.auth.administrator.group.AuthGroup;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ADMINSTRATOR")
public class Administrator {
    @Id
    @Column(name = "IDADMIN")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idAdmin;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "PESEL", nullable = false, unique = true)
    private String pesel;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "DOB")
    private Date dateDOB;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "LAST_LOGIN")
    private Date dateLogin;
    @Column(name = "LAST_LOGOUT")
    private Date dateLogout;
    @Column(name = "DATE_OF_CREATION")
    private String dateCreation;

    @ManyToOne
    @JoinColumn(name = "IDADMIN_TYPE", nullable = false)
    private AuthGroup authGroup;

    public AuthGroup getAuthGroup() {
        return authGroup;
    }

    public void setAuthGroup(AuthGroup authGroup) {
        this.authGroup = authGroup;
    }

    public long getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(long idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateDOB() {
        return dateDOB;
    }

    public void setDateDOB(Date dateDOB) {
        this.dateDOB = dateDOB;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateLogin() {
        return dateLogin;
    }

    public void setDateLogin(Date dateLogin) {
        this.dateLogin = dateLogin;
    }

    public Date getDateLogout() {
        return dateLogout;
    }

    public void setDateLogout(Date dateLogout) {
        this.dateLogout = dateLogout;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }
}
