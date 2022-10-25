package com.chagwey.springbootinventorymanagement.model;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@MappedSuperclass
public class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "creationDate", nullable = false)
    @JsonIgnore
    @CreationTimestamp
    private Instant creationDate;

    @Column(name = "lastModifiedDate")
    @JsonIgnore
    @UpdateTimestamp
    private Instant modifiedDate;

//    @PrePersist
//    void prePersist() {
//        creationDate = Instant.now();
//
//    }
//
//    @PreUpdate
//    void preUpdate() {
//        modifiedDate = Instant.now();
//    }

}
