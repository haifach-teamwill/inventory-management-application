package com.chagwey.springbootinventorymanagement.model;


import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
public class SaleItem extends AbstractEntity {
	
	@ManyToOne
	@JoinColumn(name="sale_id")
	Sale sale;
	
	@ManyToOne
	@JoinColumn(name="article_id")
	Article article;
	
	private BigDecimal quantity;
	
	private BigDecimal unitPrice;

}
