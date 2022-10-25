package com.chagwey.springbootinventorymanagement.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Role extends AbstractEntity {

    private String name;

    @ManyToOne
    @JsonIgnoreProperties({"user"})
    @JoinColumn(name = "user_id")
    User user;

}
