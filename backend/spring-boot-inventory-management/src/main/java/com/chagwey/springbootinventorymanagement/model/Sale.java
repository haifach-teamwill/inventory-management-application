package com.chagwey.springbootinventorymanagement.model;


import java.time.Instant;
import java.util.List;

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
public class Sale extends AbstractEntity {
	
	private String code;
	
	private Instant saleDate;
	
	private String comment;
	
	@OneToMany(mappedBy="sale")
	List<SaleItem> saleItems;

}
