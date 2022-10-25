package com.chagwey.springbootinventorymanagement.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractEntity {

    private String firstName;

    private String lastName;

    private String email;

    private String birthDay;

    private String password;

    private Address address;

    private String image;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnoreProperties({"users"})
    Company company;

    @JsonIgnoreProperties({"user"})
    @OneToMany(mappedBy = "user")
    List<Role> roles;


}
