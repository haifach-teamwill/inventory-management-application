package com.chagwey.springbootinventorymanagement.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Company extends AbstractEntity {

    private String name;

    private String description;

    private Address address;

    private String codeFiscal;

    private String photo;

    private String email;

    private String phoneNumber;

    private String website;

    @OneToMany(mappedBy = "company")
    @JsonIgnoreProperties({"company"})
    List<User> users;

    @OneToMany(mappedBy = "company")
    List<Article> articles;

}
