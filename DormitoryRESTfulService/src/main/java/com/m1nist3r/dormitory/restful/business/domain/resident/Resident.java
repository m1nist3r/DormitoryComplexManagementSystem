package com.m1nist3r.dormitory.restful.business.domain.resident;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.m1nist3r.dormitory.restful.business.domain.room.Room;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "resident", schema = "dormitory")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Resident implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "id_number", unique = true, nullable = false)
    private String idNumber;
    @Column(name = "sex", nullable = false)
    private char sex;
    @Column(name = "date_of_birth", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Column(name = "mother_name", nullable = false)
    private String mothersName;
    @Column(name = "father_name", nullable = false)
    private String fathersName;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "country", nullable = false)
    private String country;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "date_of_accommodation", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date accommodationDate;
    @Column(name = "date_of_eviction", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date evictionDate;
    @Column(name = "is_blocked", nullable = false)
    @JsonIgnore
    private boolean isBlocked;
    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @ManyToOne(targetEntity = ResidentType.class)
    @JoinColumn(name = "id_resident_type", nullable = false, referencedColumnName = "id")
    private ResidentType residentType;

    @ManyToOne(targetEntity = Room.class)
    @JoinColumn(name = "id_room", nullable = false, referencedColumnName = "id")
    private Room room;

}
