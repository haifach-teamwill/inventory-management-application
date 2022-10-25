package com.chagwey.springbootinventorymanagement.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Client extends AbstractEntity {

    private String firstName;

    private String lastName;

    @Embedded
    private Address address;

    private String image;

    private String email;

    private String phoneNumber;

    @OneToMany(mappedBy = "client")
    @JsonIgnoreProperties({"client"})
    List<ClientOrder> clientOrders;

}
