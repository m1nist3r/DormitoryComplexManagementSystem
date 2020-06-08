package com.m1nist3r.dormitory.restful.business.domain.room;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.m1nist3r.dormitory.restful.business.domain.resident.Resident;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "room", schema = "dormitory")
public class Room implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "dormitory_name", nullable = false)
    private String dormitoryName;
    @Column(name = "amount", nullable = false)
    private int amount;
    @Column(name = "remarks", nullable = false)
    private String remarks;

    @ManyToOne(targetEntity = RoomType.class)
    @JoinColumn(name = "id_room_type", nullable = false, referencedColumnName = "id")
    private RoomType roomType;

    @OneToMany(mappedBy = "room", targetEntity = Resident.class, fetch = LAZY)
    @JsonIgnore
    private List<Resident> residentList;

}
