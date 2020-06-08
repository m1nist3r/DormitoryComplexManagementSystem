package com.m1nist3r.dormitory.restful.business.domain.resident;

import com.m1nist3r.dormitory.restful.business.domain.room.Room;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class ResidentModel {
    @NotBlank(message = "First Name is mandatory")
    private String firstName;
    @NotBlank(message = "Last Name is mandatory")
    private String lastName;
    @NotBlank(message = "ID Number is mandatory")
    private String idNumber;
    @NotBlank(message = "SEX is mandatory")
    private char sex;
    @NotBlank(message = "Date of Birth is mandatory")
    private Date birthDate;
    @NotBlank(message = "Mother Name is mandatory")
    private String mothersName;
    @NotBlank(message = "Father Name is mandatory")
    private String fathersName;
    @NotBlank(message = "Email is mandatory")
    private String email;
    @NotBlank(message = "Country is mandatory")
    private String country;
    @NotBlank(message = "Address is mandatory")
    private String address;
    @NotBlank(message = "Phone Number is mandatory")
    private String phoneNumber;
    @NotBlank(message = "Date of Accommodation  is mandatory")
    private Date accommodationDate;
    @NotBlank(message = "Date of Eviction is mandatory")
    private Date evictionDate;
    private boolean isBlocked;
    @NotBlank(message = "Type of Resident is mandatory")
    private long residentTypeId;
    @NotBlank(message = "Room Number is mandatory")
    private long roomId;
    @NotBlank(message = "Postal Code is mandatory")
    private String postalCode;

    public Resident translateModelToResident() {
        Resident resident = new Resident();
        resident.setFirstName(this.firstName);
        resident.setLastName(this.lastName);
        resident.setIdNumber(this.idNumber);
        resident.setSex(this.sex);
        resident.setBirthDate(this.birthDate);
        resident.setMothersName(this.mothersName);
        resident.setFathersName(this.fathersName);
        resident.setEmail(this.email);
        resident.setCountry(this.country);
        resident.setAddress(this.address);
        resident.setPhoneNumber(this.phoneNumber);
        resident.setAccommodationDate(this.accommodationDate);
        resident.setEvictionDate(this.evictionDate);
        resident.setBlocked(this.isBlocked);
       // resident.setResidentType(this.residentType);
       // resident.setRoom(this.room);
        resident.setPostalCode(this.postalCode);

        return resident;
    }
}
