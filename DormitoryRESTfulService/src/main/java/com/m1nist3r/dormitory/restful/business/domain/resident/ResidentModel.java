package com.m1nist3r.dormitory.restful.business.domain.resident;

import com.m1nist3r.dormitory.restful.business.domain.room.Room;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResidentModel {
    @Size(min = 2, max = 26)
    @NotBlank(message = "First Name is mandatory")
    private String firstName;
    @Size(min = 2, max = 26)
    @NotBlank(message = "Last Name is mandatory")
    private String lastName;
    @NotBlank(message = "ID Number is mandatory")
    private String idNumber;
    @Pattern(regexp = "^[M|F]$", message = "Must be M or F")
    @NotNull(message = "SEX is mandatory")
    private String sex;
    @NotNull(message = "Date of Birth is mandatory")
    private LocalDate birthDate;
    @Size(min = 2, max = 26)
    @NotBlank(message = "Mother Name is mandatory")
    private String mothersName;
    @Size(min = 2, max = 26)
    @NotBlank(message = "Father Name is mandatory")
    private String fathersName;
    @Email
    @NotBlank(message = "Email is mandatory")
    private String email;
    @Size(min = 2, max = 100)
    @NotBlank(message = "Country is mandatory")
    private String country;
    @Size(min = 2, max = 255)
    @NotBlank(message = "Address is mandatory")
    private String address;
    @Size(min = 2, max = 25)
    @NotBlank(message = "Phone Number is mandatory")
    private String phoneNumber;
    @PastOrPresent
    @NotNull(message = "Date of Accommodation  is mandatory")
    private LocalDate accommodationDate;
    @FutureOrPresent
    @NotNull(message = "Date of Eviction is mandatory")
    private LocalDate evictionDate;
    @NotNull(message = "Is blocked is mandatory")
    private boolean isBlocked;
    @NotNull(message = "Type of Resident is mandatory")
    private ResidentType residentType;
    @NotNull(message = "Room Number is mandatory")
    private Room room;
    @Size(min = 2, max = 20)
    @NotBlank(message = "Postal Code is mandatory")
    private String postalCode;

    public Resident translateModelToResident() {
        Resident resident = new Resident();
        resident.setFirstName(this.firstName);
        resident.setLastName(this.lastName);
        resident.setIdNumber(this.idNumber);
        resident.setSex(this.sex.toCharArray()[0]);
        resident.setBirthDate(this.birthDate);
        resident.setMothersName(this.mothersName);
        resident.setFathersName(this.fathersName);
        resident.setEmail(this.email);
        resident.setCountry(this.country);
        resident.setAddress(this.address);
        resident.setPhoneNumber(this.phoneNumber);
        resident.setAccommodationDate(this.accommodationDate);
        resident.setEvictionDate(this.evictionDate);
        resident.setRoom(room);
        resident.setResidentType(residentType);
        resident.setPostalCode(this.postalCode);

        return resident;
    }
}
