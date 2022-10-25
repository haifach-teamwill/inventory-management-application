package com.chagwey.springbootinventorymanagement.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Article extends AbstractEntity {

	private String code;

	private String description;

	private BigDecimal taxExclUnitPrice;

	private BigDecimal vatRate;

	private BigDecimal taxInclUnitPrice;

	private String image;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	//*
	@JsonIgnore
	@OneToMany(mappedBy = "article")
	List<ClientOrderItem> clientOrderItems;
	//*
	@JsonIgnore
	@OneToMany(mappedBy = "article")
	List<VendorOrderItem> vendorOrderItems;
	//*
	@JsonIgnore
	@OneToMany(mappedBy = "article")
	List<SaleItem> SaleItems;

	//*
	@JsonIgnore
	@OneToMany(mappedBy = "article")
	List<StockMvt> stockMvt;


}
