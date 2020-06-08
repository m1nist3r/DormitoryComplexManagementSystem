package com.m1nist3r.dormitory.web.application.business.domain.resident;

import com.m1nist3r.dormitory.web.application.business.domain.payment.Payments;
import com.m1nist3r.dormitory.web.application.business.domain.room.Room;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Resident {
    private long id;
    private String firstName;
    private String lastName;
    private String pesel;
    private char gender;
    private Date dateDOB;
    private String mothersName;
    private String fathersName;
    private String email;
    private String country;
    private String address;
    private String phoneNumber;
    private Date accommodationDate;
    private Date evictionDate;
    private int isBlocked;
    private BigDecimal paymentFee;
    private ResidentType residentType;
    private Room room;
    private List<Payments> payments;
    private List<ResidentTypeFields> residentTypeFields;
    private List<ResidentTypeValuesFields> residentTypeValuesFields;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getDateDOB() {
        return dateDOB;
    }

    public void setDateDOB(Date dateDOB) {
        this.dateDOB = dateDOB;
    }

    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getAccommodationDate() {
        return accommodationDate;
    }

    public void setAccommodationDate(Date accommodationDate) {
        this.accommodationDate = accommodationDate;
    }

    public Date getEvictionDate() {
        return evictionDate;
    }

    public void setEvictionDate(Date evictionDate) {
        this.evictionDate = evictionDate;
    }

    public int getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(int isBlocked) {
        this.isBlocked = isBlocked;
    }

    public BigDecimal getPaymentFee() {
        return paymentFee;
    }

    public void setPaymentFee(BigDecimal paymentFee) {
        this.paymentFee = paymentFee;
    }

    public ResidentType getResidentType() {
        return residentType;
    }

    public void setResidentType(ResidentType residentType) {
        this.residentType = residentType;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<Payments> getPayments() {
        return payments;
    }

    public void setPayments(List<Payments> payments) {
        this.payments = payments;
    }

    public List<ResidentTypeFields> getResidentTypeFields() {
        return residentTypeFields;
    }

    public void setResidentTypeFields(List<ResidentTypeFields> residentTypeFields) {
        this.residentTypeFields = residentTypeFields;
    }

    public List<ResidentTypeValuesFields> getResidentTypeValuesFields() {
        return residentTypeValuesFields;
    }

    public void setResidentTypeValuesFields(List<ResidentTypeValuesFields> residentTypeValuesFields) {
        this.residentTypeValuesFields = residentTypeValuesFields;
    }

    public String getFormattedDate(Date date) {
        if(date != null) return new SimpleDateFormat("yyyy-MM-dd").format(date);
        else return "";
    }
}
