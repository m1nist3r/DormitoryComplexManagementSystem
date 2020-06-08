package com.m1nist3r.dormitory.restful.business.domain.room;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "room_type", schema = "dormitory")
public class RoomType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "capacity", nullable = false)
    private int capacity;
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "roomType", targetEntity = Room.class, fetch = LAZY)
    @JsonIgnore
    private List<Room> roomList;
}
