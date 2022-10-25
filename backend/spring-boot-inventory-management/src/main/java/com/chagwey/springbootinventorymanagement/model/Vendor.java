package com.chagwey.springbootinventorymanagement.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
public class Vendor extends AbstractEntity {
	
	private String firstName;
	
	private String lastName;
	
	@Embedded
	private Address address;
	
	private String image;
	
	private String email;
	
	private String phoneNumber;
	
	@OneToMany(mappedBy="vendor")
	List<VendorOrder> vendorOrders; 

}
