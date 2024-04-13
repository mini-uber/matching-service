package com.miniuber.matchingservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.Generated;

@Entity
public class Matching {

    @Id
    @Generated
    private Long id;

    private Long userId;
    private Long driverId;

}
