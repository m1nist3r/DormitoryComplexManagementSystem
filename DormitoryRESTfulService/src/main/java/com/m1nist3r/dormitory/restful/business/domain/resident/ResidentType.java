package com.m1nist3r.dormitory.restful.business.domain.resident;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "resident_type", schema = "dormitory")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResidentType {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "type", nullable = false)
    private String type;
    @Column(name = "description")
    private String description;
}
